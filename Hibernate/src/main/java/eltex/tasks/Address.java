package eltex.tasks;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "address")

public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String city;

    @Getter @Setter
    private String street;

    @Getter @Setter
    private String building;

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    @Getter @Setter
    private Collection <User> tenants;
}
