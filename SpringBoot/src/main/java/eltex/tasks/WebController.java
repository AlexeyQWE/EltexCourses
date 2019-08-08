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
     * Загрузка стартовой страницы Hello
     * Метод для сопоставления с точкой входа <b>/</b>
     * @see User#User()
     */
    public String index(Model model) {
        model.addAttribute("name", "Alexey");
        return "index";
    }
}
