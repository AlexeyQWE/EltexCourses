package eltex.tasks;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс-контроллер
 * @author Alexey Karasev
 * @version v1.0
 */
@RestController
public class UserController {

    private ObjectMapper mapper = new ObjectMapper();
    private ArrayList<User> users = new ArrayList<User>();

    @RequestMapping("/clear")
    /**
     * Метод для сопоставления с точкой входа <b>/clear</b>
     * @see User#User()
     */
    public void clear() {
        users.clear();
    }

    @RequestMapping("/create")
    /**
     * Метод для сопоставления с точкой входа <b>/create</b>
     * @see User#User()
     */
    public void create() {
        users.add(new User(1, "Alexey", "900"));
        users.add(new User(2, "Gena", "800"));
        users.add(new User(3, "Eugene", "700"));
        users.add(new User(4, "Venc", "600"));
    }

    @RequestMapping("/get_users")
    /**
     * Метод для сопоставления с точкой входа <b>/get_users</b>
     * @return Строка формата JSON
     * @see User#User()
     */
    public String getUser() throws IOException {
        if (!users.isEmpty())
            return mapper.writeValueAsString(users);
        else
            return "Users not found";
    }

    @RequestMapping("/get_user/{id}")
    /**
     * Метод для сопоставления с точкой входа <b>/get_user/id</b>
     * @return Строка формата JSON
     * @see User#User()
     */
    public String getUserWithID(@PathVariable("id") Integer id) throws IOException {
        if (!users.isEmpty())
            return mapper.writeValueAsString(users.get(id - 1));
        else
            return "Current user not found";
    }
}
