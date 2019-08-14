package eltex.tasks;

import lombok.*;

@NoArgsConstructor
public class User {

    @Getter @Setter private Integer id;
    @Getter @Setter private String fio;
    @Getter @Setter private String phone;

    User(Integer id, String fio, String phone) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;

    }
}
