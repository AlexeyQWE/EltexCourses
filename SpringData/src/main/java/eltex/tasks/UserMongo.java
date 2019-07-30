package eltex.tasks;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;

@Document
public class UserMongo {

    @Id
    @Getter @Setter private Integer id;
    @Getter @Setter private String fio;
    @Getter @Setter private String phone;

    UserMongo () {}

    UserMongo(String fio, String phone, Integer id) {
        this.fio = fio;
        this.phone = phone;
        this.id = id;

    }
}

