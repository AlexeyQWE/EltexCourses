package eltex.tasks;

public class Manager extends User {

	protected Sales [] sales = new Sales[3];

	{
		sales[0] = new Sales("Telephone", 10000);
		sales[1] = new Sales("Keyboard", 8000);
		sales[2] = new Sales("headphone", 6000);
	}

	private String task_title;
	private String task_description;

	Manager () {};

	public void speak () {

		System.out.print("Hello! Im a Manager! ");

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

	public String getSaleTitle () {

		return this.sales[this.id].getTitle();
	}

	public int getPrice () {

		return this.sales[this.id].getPrice();
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

		return this.id.toString() + " ; " + this.fio + " ; " + this.phone + " ; " + this.email + " ; " + this.sales[this.id].getTitle() + " ; "
		+  this.sales[this.id].getPrice() + ";" + this.task_title + ";" + this.task_description + ";";
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
