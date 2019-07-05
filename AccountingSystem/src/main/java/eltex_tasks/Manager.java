package eltex_tasks;

public class Manager extends User {

	private Sales [] sales = new Sales[3];

	{
		sales[0] = new telephone();
		sales[1] = new headphone();
		sales[2] = new keyboard();
	}

	Manager (String fio, String phone, String email) {

		this.fio = fio;
		this.phone = phone;
		this.email = email;
		++this.id;
	}

	public void speak () {

		System.out.print("Hello! Im a Manager! ");

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

	public String getTitle () {

		return this.sales[this.id - 1].getTitle();
	}

	public int getPrice () {

		return this.sales[this.id - 1].getPrice();
	}
}
