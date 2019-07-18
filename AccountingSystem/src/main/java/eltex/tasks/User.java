package eltex.tasks;

public abstract class User implements CSV, Comparable <User>{

	protected Integer id;
	protected String fio;
	protected String phone;
	protected String email; 

	abstract public Integer getId ();
	abstract public String getFio ();
	abstract public String getPhone();
	abstract public String getEmail ();

	abstract public void setId (String arg);
	abstract public void setFio (String arg);
	abstract public void setEmail (String arg);
	abstract public void setPhone (String arg);

	abstract public String toCSV(int i);
	abstract public void fromCSV(String str);
	
	 public int compareTo (User other) {

	 	return this.id.compareTo(other.getId());
	 }
}

