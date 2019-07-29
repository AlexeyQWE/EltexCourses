package eltex.tasks;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String fio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    @Getter @Setter
    private Passport passport;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @Getter @Setter
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "language_id")
    @Getter @Setter
    private Collection<Lang> lang;
}
