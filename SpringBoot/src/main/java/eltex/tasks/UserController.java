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

    @RequestMapping("/create")
    /**
     * добавление пользователей
     * Метод для сопоставления с точкой входа <b>/create</b>
     * @see User#User()
     */
    public String create() {
        users.add(new User(1, "Alexey", "900"));
        users.add(new User(2, "Gena", "800"));
        users.add(new User(3, "Eugene", "700"));
        users.add(new User(4, "Venc", "600"));

        return "Users has create";
    }

    @RequestMapping("/get_users")
    /**
     * вывод всех пользователей
     * Метод для сопоставления с точкой входа <b>/get_users</b>
     * @return Строка формата JSON
     * @see User#User()
     */
    public String getUsers() throws IOException {
        if (!users.isEmpty())
            return mapper.writeValueAsString(users);
        else
            return "Users not found";
    }

    @RequestMapping("/get_user/{id}")
    /**
     * вывод пользователя по id
     * Метод для сопоставления с точкой входа <b>/get_user/{id}</b>
     * @return Строка формата JSON
     * @see User#User()
     */
    public String getUser(@PathVariable("id") Integer id) throws IOException {
        if (!users.isEmpty())
            return mapper.writeValueAsString(users.get(id - 1));
        else
            return "Current user not found";
    }

    @RequestMapping("/admin")
    /**
     * удаление пользователей
     * Метод для сопоставления с точкой входа <b>/admin</b>
     * @see User#User()
     */
    public String admin() {

        users.clear();
        return "Users has removed from list";
    }
}
