package eltex.tasks;

@People(gender = "woman")
public class Manager extends User {

	private Sales [] sales = new Sales[3];

	{
		for (int i = 0; i < 3; ++i)
			sales[i] = new Sales();
	}

	Manager () {};

	public String getTitle () {

		String [] arg = new String[3];

		for (int i = 0; i < 3; ++i) 
			arg[i] = this.sales[i].getTitle();
		
		String str = String.join("; ", arg);

		return str;
	}

	public String getTitle (int i) {

		return  this.sales[i].getTitle();
	}

	public String getPrice () {

		String [] arg = new String[3];

		for (int i = 0; i < 3; ++i) 
			arg[i] = this.sales[i].getPrice();
		
		String str = String.join("; ", arg);

		return str;
	}

	public String getPrice (int i) {

		return  this.sales[i].getPrice();
	}

	public String getSaleId () {

		String [] arg = new String[3];
		Integer tmp;

		for (int i = 0; i < 3; ++i) {
			tmp = this.sales[i].getId();
			arg[i] = tmp.toString();
		}

		String str = String.join("; ", arg);

		return str;
	}

	public Integer getSaleId (int i) {

		return  this.sales[i].getId();
	}

	public void setTitle (String title, int i) {

		this.sales[i].setTitle(title);
	}

	public void setPrice (String price, int i) {

		this.sales[i].setPrice(price);
	}

	public void setSaleId (Integer id, int i) {

		this.sales[i].setId(id);
	}

	public String toCSV() {

		String [] arg = new String[3];

		arg[0] = getSaleId();
		arg[1] = getTitle();
		arg[2] = getPrice();

		String str = String.join("; ", arg);

		return this.id.toString() + "; " + this.fio + "; " + this.phone + "; " + this.email + "; " + str + "; ";
	}

	public void fromCSV(String str) {

		String [] arg = str.split(";");
		setId (Integer.valueOf(arg [0]));
		setFio (arg [1]);
		setPhone (arg [2]);
		setEmail (arg [3]);

		for (int i = 0, j = 4, k = 7, q = 10; i < sales.length; ++i, ++j, ++k, ++q) {
			setSaleId(Integer.valueOf(arg[j]),i);
			setTitle(arg[k],i);
			setPrice(arg[q],i);
		}
	}
}
