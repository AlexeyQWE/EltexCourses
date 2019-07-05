package eltex_tasks;

class Main {

	public static void main(String args[]) {

		String [] fio = {"Brown", "Smit", "Vega"};
		String [] phone = {"+71231232323", "+78531239856", "+79356782356"};
		String [] email = {"Brown@eltex.com", "Smit@eltex.com", "Vega@eltex.com"};

		Developer [] dev = new Developer[3];
		Manager [] mng = new Manager[3];

		for (int i = 0; i < 3; ++i) {
			dev[i] = new Developer(fio[i], phone[i], email[i]);
			dev[i].speak();
			System.out.println("My Id is " + dev[i].getId());
			System.out.println("My last name is " + dev[i].getFio());
			System.out.println("My phone is " + dev[i].getPhone());
			System.out.println("My email is " + dev[i].getEmail());
			System.out.println("I use the language " + dev[i].getLang() + "\n");
		}
		
		dev[0].resetId();

		for (int i = 0; i < 3; ++i) {
			mng[i] = new Manager(fio[i], phone[i], email[i]);
			mng[i].speak();
			System.out.println("My Id is " + mng[i].getId());
			System.out.println("My last name is " + mng[i].getFio());
			System.out.println("My phone is " + mng[i].getPhone());
			System.out.println("My email is " + mng[i].getEmail());
			System.out.println("Im selling " + mng[i].getTitle() + ", Cost is " + mng[i].getPrice() + "\n");
		}


	}
}