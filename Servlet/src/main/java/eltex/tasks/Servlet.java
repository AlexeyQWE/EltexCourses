package eltex.tasks;

import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get_users")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, "Alexey"));
        users.add(new User(2, "Gena"));
        users.add(new User(3, "Eugene"));
        users.add(new User(4, "Venc"));

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();

        try {
            String output = mapper.writeValueAsString(users);
            System.out.println(output);
            writer.write(output);
            writer.flush();
        }finally {
            writer.close();
        }
    }
}
