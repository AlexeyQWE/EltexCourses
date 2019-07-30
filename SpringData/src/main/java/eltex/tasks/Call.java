package eltex.tasks;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;

@Document
public class Call {

    @Id
    @Getter @Setter private Integer id;
    @Getter @Setter private Integer caller_id;
    @Getter @Setter private Integer receiver_id;
    @Getter @Setter private String date;

    Call () {}

    Call(Integer id, Integer caller_id, Integer receiver_id, String date) {
        this.id = id;
        this.caller_id = caller_id;
        this.receiver_id = receiver_id;
        this.date = date;

    }
}