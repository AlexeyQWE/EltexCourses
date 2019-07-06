package eltex_tasks;

public class Developer extends User {

	private String [] lang = {"Pyton", "Ruby", "Java"};

	Developer (String fio, String phone, String email) {

		this.fio = fio;
		this.phone = phone;
		this.email = email;
		++this.id;
	}

	public void speak () {

		System.out.println("Hello! Im a Developer! ");
	}

	public int getId () {

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

		return this.lang[this.id - 1];
	}
}