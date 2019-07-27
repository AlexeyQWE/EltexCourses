package eltex.tasks;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "languages")

public class Lang {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter @Setter
	private Integer id;

	@Getter @Setter
	private String title;

	@ManyToMany(mappedBy = "lang", fetch = FetchType.EAGER)
    @Getter @Setter
    private List <User> users;
}
