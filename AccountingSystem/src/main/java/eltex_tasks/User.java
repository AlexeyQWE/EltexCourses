package eltex_tasks;

public abstract class User  {

	protected static int id;
	protected String fio;
	protected String phone;
	protected String email; 

	abstract public void speak();
	abstract public int getId ();
	abstract public String getFio ();
	abstract public String getEmail ();

	public void resetId () {

		this.id = 0;
	}

}

