package eltex.tasks;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.*;
import java.net.*;
import java.util.*;

@SpringBootApplication
public class Main {

    private User user1;
    private User user2;
    private Date date;

    public static void main(String[] args) {

        SpringApplication.run(Main.class);
    }
    @Bean
    public CommandLineRunner demo(UserRepository CrudRepository) {
        return (args) -> {
            user1 = new User(1, "Ivan", "900");
            user2 = new User(2, "Boris", "800");
            CrudRepository.save(user1);
            CrudRepository.save(user2);
        };
    }
    @Bean
    public CommandLineRunner demo1(CallRepository MongoRepository) {
        Date date = new Date();
        return (args) -> {
            MongoRepository.save(new Call(1,  user1.getId(), user2.getId(),date.toString()));
            MongoRepository.save(new Call(2,user2.getId(), user1.getId(), date.toString()));
        };
    }
    @Bean
    public CommandLineRunner demo2(UserRepository CrudRepository) {
        return (args) -> {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                Socket client = server.accept();
                new Thread (() -> {
                    try {
                        InputStream inStream = client.getInputStream();
                        Scanner in = new Scanner(inStream);
                        String client_request = in.nextLine();
                        String [] arg = client_request.split(" ");
                        String [] tokens = arg[1].split("/");
                        String output = null;

                        if (tokens[1].equals("get_users") && tokens.length == 2) {
                            ObjectMapper mapper = new ObjectMapper();
                            ArrayList<User> users = new ArrayList<>();
                            CrudRepository.findAll().forEach(users::add);
                            output = mapper.writeValueAsString(users);
                            output = "HTTP/1.1 200 OK\n\n" + output;
                        }

                        else if (tokens[1].equals("get_user") && tokens.length > 2) {
                            Integer id = Integer.valueOf(tokens[2]);
                            ObjectMapper mapper = new ObjectMapper();
                            User u = CrudRepository.findById(id).get();
                            output = mapper.writeValueAsString(u);
                            output = "HTTP/1.1 200 OK\n\n" + output;
                        }
                        else {
                            output = "HTTP/1.1 404";
                        }
                        OutputStream outStream = client.getOutputStream();
                        PrintWriter out = new PrintWriter(outStream);
                        out.write(output);
                        out.flush();
                        client.close();
                    }
                    catch (IOException e) {
                        System.err.println(e.getMessage());
                    }

                }).start();
            }
        };
    }
}
