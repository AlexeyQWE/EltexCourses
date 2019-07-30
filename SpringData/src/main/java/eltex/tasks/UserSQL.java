package eltex.tasks;

import lombok.*;;
import javax.persistence.*;

@Entity
public class UserSQL {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Getter @Setter private Integer id;
    @Getter @Setter private String fio;
    @Getter @Setter private String phone;

    UserSQL () {}

    UserSQL(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;

    }
}