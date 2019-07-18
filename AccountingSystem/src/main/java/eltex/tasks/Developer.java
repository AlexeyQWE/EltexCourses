package eltex.tasks;

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

	public String getLang (int i) {

		return this.lang[i];
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

	public void setLang (String arg, int i) {

		this.lang[i] = arg;
	}


	public String toCSV(int i) {

		return this.id.toString() + " ; " + this.fio + " ; " + this.phone + " ; " + this.email + " ; " + this.lang[i] + " ; ";
	}

	public void fromCSV(String str) {

		String [] arg = str.split(";");
		setId (arg [0]);
		setFio (arg [1]);
		setPhone (arg [2]);
		setEmail (arg [3]);
	}
}