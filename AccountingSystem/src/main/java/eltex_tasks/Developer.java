package eltex_tasks;

public class Developer extends User {

	private String [] lang = {"Pyton", "Ruby", "Java"};

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

	public String toCSV() {

		return Integer.toString(this.id) + " ; " + this.fio + " ; " + this.phone + " ; " + this.email + " ; " + this.lang[this.id] + " ; ";
	}

	public void fromCSV(String str) {

		String [] arg = str.split(";");
		setId (arg [0]);
		setFio (arg [1]);
		setPhone (arg [2]);
		setEmail (arg [3]);
	}
}