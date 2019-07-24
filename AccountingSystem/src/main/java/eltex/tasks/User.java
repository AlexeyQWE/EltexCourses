package eltex.tasks;

import lombok.*;

@ToString(exclude = "id", includeFieldNames = true)

public abstract class User implements CSV, Comparable <User>{

	@Getter @Setter
	protected Integer id;

	@Getter @Setter
	protected String fio;

	@Getter @Setter
	protected String phone;

	@Getter @Setter
	protected String email;

	abstract public String toCSV();
	abstract public void fromCSV(String str);
	
	 public int compareTo (User other) {

	 	return this.id.compareTo(other.getId());
	 }
}

