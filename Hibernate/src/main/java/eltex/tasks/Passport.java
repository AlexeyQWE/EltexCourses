package eltex.tasks;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "passports")

public class Passport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter @Setter
    private long id;

    @OneToOne(mappedBy = "passport")
    @Getter @Setter
    private User user;

    @Getter @Setter
    private String series;
    @Getter @Setter
    private String number;
}
