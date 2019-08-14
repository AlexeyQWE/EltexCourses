package eltex.tasks;

import lombok.*;

/**
 * Класс представления пользователя
 * @author Alexey Karasev
 * @version v1.0
 */
@NoArgsConstructor
public class User {

    /** Поле идентификатора */
    @Getter @Setter private Integer id;
    /** Поле ФИО */
    @Getter @Setter private String fio;
    /** Поле телефона */
    @Getter @Setter private String phone;

    User(Integer id, String fio, String phone) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;

    }
}