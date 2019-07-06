package eltex_tasks;
import java.io.*;
import java.util.Scanner;

class Main {

	public static void read (String [] fio, String [] phone, String [] email)  {

		try {
			FileReader fr = new FileReader ("files/emails.txt");
			Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	email[j] = scan.nextLine();
	        }
	     }
	     catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	    try {
	       FileReader fr = new FileReader ("files/last_names.txt");
	       Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	fio[j] = scan.nextLine();
	        }
	     }
	     catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	    try {
	       FileReader fr = new FileReader ("files/phones.txt");
	       Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	phone[j] = scan.nextLine();
	        }
	    }
	    catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void main(String args[])  {

		String [] fio =  new String[3];
		String [] phone = new String[3];
		String [] email = new String[3];

		Developer [] dev = new Developer[3];
		Manager [] mng = new Manager[3];
		MainManager [] main_mng = new MainManager[3];

		read(fio, phone, email);

		for (int i = 0; i < 3; ++i) {
			dev[i] = new Developer(fio[i], phone[i], email[i]);
			dev[i].speak();
			System.out.println("My Id is " + dev[i].getId());
			System.out.println("My last name is " + dev[i].getFio());
			System.out.println("My phone is " + dev[i].getPhone());
			System.out.println("My email is " + dev[i].getEmail());
			System.out.println("I use the language " + dev[i].getLang() + "\n");
		}

		System.out.println();
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

		System.out.println();
		mng[0].resetId();

		MainManager tmp = new MainManager ();
		tmp.sort();

		for (int i = 0; i < 3; ++i) {
			main_mng[i] = new MainManager(fio[i], phone[i], email[i]);
			main_mng[i].speak();
			System.out.println("My Id is " + main_mng[i].getId());
			System.out.println("My last name is " + main_mng[i].getFio());
			System.out.println("My phone is " + main_mng[i].getPhone());
			System.out.println("My email is " + main_mng[i].getEmail());
			System.out.println("Im selling " + tmp.getTitle() + ", Cost is " + tmp.getPrice() + "\n");
		}
	}
}