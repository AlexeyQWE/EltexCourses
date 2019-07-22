package eltex.tasks;

import java.util.Arrays;

public class Developer extends User {

	private String [] lang = new String[3];

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

		String str = String.join("; ", lang);

		return str;
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


	public String toCSV() {

        String str = String.join("; ", lang);

		return this.id.toString() + "; " + this.fio + "; " + this.phone + "; " + this.email + "; " + str + "; ";
	}

	public void fromCSV(String str) {

		String [] arg = str.split(";");
		setId (arg [0]);
		setFio (arg [1]);
		setPhone (arg [2]);
		setEmail (arg [3]);

		for (int i = 0, j = 4; i < lang.length; ++i, ++j)
		    setLang(arg[j],i);
	}
}