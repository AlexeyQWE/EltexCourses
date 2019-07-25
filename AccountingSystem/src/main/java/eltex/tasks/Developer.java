package eltex.tasks;

@People(gender = "man")

public class Developer extends User {

	private Languages [] lang = new Languages[3];
	{
		for (int i = 0; i < 3; ++i)
			lang[i] = new Languages();
	}

	public String getLangTitle () {

		String [] arg = new String[3];

		for (int i = 0; i < 3; ++i)
			arg[i] = this.lang[i].getTitle();

		String str = String.join("; ", arg);

		return str;
	}

	public String getLangTitle (int i) {

		return  this.lang[i].getTitle();
	}

	public String getLangId () {

		String [] arg = new String[3];
		Integer tmp;

		for (int i = 0; i < 3; ++i) {
			tmp = this.lang[i].getId();
			arg[i] = tmp.toString();
		}

		String str = String.join("; ", arg);

		return str;
	}

	public Integer getLangId (int i) {

		return  this.lang[i].getId();
	}

	public void setLangTitle (String title, int i) {

		this.lang[i].setTitle(title);
	}

	public void setLangId (Integer id, int i) {

		this.lang[i].setId(id);
	}

	public String toCSV() {

		String [] arg = new String[2];

		arg[0] =getLangId();
		arg[1] = getLangTitle();

		String str = String.join("; ", arg);

		return this.id.toString() + "; " + this.fio + "; " + this.phone + "; " + this.email + "; " + str + "; ";
	}

	public void fromCSV(String str) {

		String [] arg = str.split(";");
		setId (Integer.valueOf(arg [0]));
		setFio (arg [1]);
		setPhone (arg [2]);
		setEmail (arg [3]);

		for (int i = 0, j = 4, k = 7; i < lang.length; ++i, ++j, ++k) {
			setLangTitle(arg[k],i);
			setLangId(Integer.valueOf(arg[j]), i);
		}
	}
}