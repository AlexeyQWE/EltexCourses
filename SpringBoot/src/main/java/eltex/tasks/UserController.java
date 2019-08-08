package eltex.tasks;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class UserController {

    private ObjectMapper mapper = new ObjectMapper();
    private ArrayList<User> users = new ArrayList<User>();

    @RequestMapping("/get_users")
    public String getUser() throws IOException {
        users.add(new User(1, "Alexey", "900"));
        users.add(new User(2, "Gena", "800"));
        users.add(new User(3, "Eugene", "700"));
        users.add(new User(4, "Venc", "600"));
        return mapper.writeValueAsString(users);
    }
    @RequestMapping("/get_user/{id}")
    public String getUserWithID(@PathVariable("id") Integer id) throws IOException {
        return mapper.writeValueAsString(users.get(id - 1));
    }
}
