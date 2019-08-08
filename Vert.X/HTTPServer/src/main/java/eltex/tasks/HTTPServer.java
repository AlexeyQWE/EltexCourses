package eltex.tasks;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.ArrayList;

public class HTTPServer {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, "Alexey"));
        users.add(new User(2, "Gena"));
        users.add(new User(3, "Eugene"));
        users.add(new User(4, "Venc"));

        ObjectMapper mapper = new ObjectMapper();
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        vertx.createHttpServer().requestHandler(request -> {
            System.out.println(request.uri()); 
            String[] input = request.uri().split("/");
            if (input[1].equals("get_users")){
                try {
                    String output = mapper.writeValueAsString(users);
                    request.response()
                            .putHeader("Content-Type", "application/json")
                            .end(output); 
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (input[1].equals("get_user")){
                try {
                    Integer id = Integer.parseInt(input[2]);
                    String output = mapper.writeValueAsString(users.get(id - 1));
                    request.response()
                            .putHeader("Content-Type", "application/json")
                            .end(output); 
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).listen(8081); 
    }
}
