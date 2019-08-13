package eltex.tasks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Класс-контроллер
 * @author Alexey Karasev
 * @version v1.0
 */

@Controller
public class WebController {
    @RequestMapping("/")
    /**
     * Загрузка стартовой страницы Users List
     * Метод для сопоставления с точкой входа <b>/</b>
     * @see User#User()
     */
    public String index_default(Model model) {
        model.addAttribute("name", "Users List");
        model.addAttribute("user1", (new User(1, "Alexey", "900")));
        model.addAttribute("user2", (new User(2, "Gena", "800")));
        model.addAttribute("user3", (new User(3, "Eugene", "700")));
        model.addAttribute("user4", (new User(4, "Venc", "600")));

        return "index_default";
    }

    @RequestMapping("/admin")
    /**
     * Загрузка стартовой страницы Admin Page
     * Метод для сопоставления с точкой входа <b>/admin</b>
     * @see User#User()
     */
    public String index_admin(Model model) {
        model.addAttribute("name", "Admin Page");
        model.addAttribute("user1", (new User(1, "Alexey", "900")));
        model.addAttribute("user2", (new User(2, "Gena", "800")));
        model.addAttribute("user3", (new User(3, "Eugene", "700")));
        model.addAttribute("user4", (new User(4, "Venc", "600")));

        return "index_admin";
    }
}
