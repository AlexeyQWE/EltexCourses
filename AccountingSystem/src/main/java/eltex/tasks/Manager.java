package eltex.tasks;

public class Manager extends User {

	protected Sales [] sales = new Sales[3];

	{
		sales[0] = new Sales("Telephone", 10000);
		sales[1] = new Sales("Keyboard", 8000);
		sales[2] = new Sales("headphone", 6000);
	}

	Manager () {};

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

	public String getTitle (int i) {

		return this.sales[i].getTitle();
	}

	public int getPrice (int i) {

		return this.sales[i].getPrice();
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

	public void setTitle (String arg, int i) {

		this.sales[i].setTitle(arg);
	}

	public void setPrice (String arg, int i) {

		this.sales[i].setPrice(Integer.parseInt(arg));
	}

	public String toCSV(int i) {

		return this.id.toString() + " ; " + this.fio + " ; " + this.phone + " ; " + this.email + " ; " + this.sales[i].getTitle() + " ; "
		+  this.sales[i].getPrice() + ";";
	}

	public void fromCSV(String str) {

		String [] arg = str.split(";");
		setId (arg [0]);
		setFio (arg [1]);
		setPhone (arg [2]);
		setEmail (arg [3]);
	}
}
