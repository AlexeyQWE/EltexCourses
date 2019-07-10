package eltex_tasks;

public class Developer extends User {

	private String [] lang = {"Pyton", "Ruby", "Java"};

	private String task_title;
	private String task_description;

	public void speak () {

		System.out.println("Hello! Im a Developer! ");
	}

	public Integer getId () {

		return this.id;
	}

	public String getFio () {

		return this.fio;
	}

	public String getPhone () {

		return this.phone;
	}

	public String getEmail () {

		return this.email;
	}

	public String getLang () {

		return this.lang[this.id];
	}

	public String getTaskTitle () {

		return this.task_title;
	}

	public String getTaskDescription () {

		return this.task_description;
	}
		
	public void setId (String arg) {

		this.id = Integer.valueOf(arg);
	}
	

	public void setFio (String arg) {

		this.fio = arg;
	}

	public void setPhone (String arg) {

		this.phone = arg;
	}

	public void setEmail (String arg) {

		this.email = arg;
	}

	public void setTaskTitle (String arg) {

		this.task_title = arg;
	}

	public void setTaskDescription (String arg) {

		this.task_description = arg;
	}


	public String toCSV() {

		return this.id.toString() + " ; " + this.fio + " ; " + this.phone + " ; " + this.email + " ; " + this.lang[this.id] + " ; " + 
				this.task_title + ";" + this.task_description + ";";
	}

	public void fromCSV(String str) {

		String [] arg = str.split(";");
		setId (arg [0]);
		setFio (arg [1]);
		setPhone (arg [2]);
		setEmail (arg [3]);
		setTaskTitle(arg[4]);
		setTaskDescription(arg[5]);
	}
}