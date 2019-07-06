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

	public static void wtire (Developer [] dev) {

		try {
			FileWriter fw = new FileWriter ("files/dev_output_info.txt");
			for (int i = 0; i < 3; ++i) {
				fw.write("\nMy Id is " + dev[i].getId());
				fw.write("\nMy last name is " + dev[i].getFio());
				fw.write("\nMy phone is " + dev[i].getPhone());
				fw.write("\nMy email is " + dev[i].getEmail() + "\n"); 		
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void wtire (Manager [] mng) {

		try {
			FileWriter fw = new FileWriter ("files/mng_output_info.txt");
			for (int i = 0; i < 3; ++i) {
				fw.write("\nMy Id is " + mng[i].getId());
				fw.write("\nMy last name is " + mng[i].getFio());
				fw.write("\nMy phone is " + mng[i].getPhone());
				fw.write("\nMy email is " + mng[i].getEmail() + "\n");
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void wtire (MainManager [] mng) {

		try {
			FileWriter fw = new FileWriter ("files/main_mng_output_info.txt");
			for (int i = 0; i < 3; ++i) {
				fw.write("\nMy Id is " + mng[i].getId());
				fw.write("\nMy last name is " + mng[i].getFio());
				fw.write("\nMy phone is " + mng[i].getPhone());
				fw.write("\nMy email is " + mng[i].getEmail() + "\n");
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void main(String args[]) {

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
			System.out.println("My last name is " + dev[i].getFio());
			System.out.println("I use the language " + dev[i].getLang() + "\nCheck my info in dev_output_info.txt\n");
		}

		wtire(dev);

		System.out.println();
		dev[0].resetId();

		for (int i = 0; i < 3; ++i) {
			mng[i] = new Manager(fio[i], phone[i], email[i]);
			mng[i].speak();
			System.out.println("My last name is " + mng[i].getFio());
			System.out.println("Im selling " + mng[i].getTitle() + ", Cost is " + mng[i].getPrice() + "\nCheck my info in mng_output_info.txt\n");
		}

		wtire(mng);

		System.out.println();
		mng[0].resetId();

		MainManager tmp = new MainManager ();
		tmp.sort();

		for (int i = 0; i < 3; ++i) {
			main_mng[i] = new MainManager(fio[i], phone[i], email[i]);
			main_mng[i].speak();
			System.out.println("My last name is " + main_mng[i].getFio());
			System.out.println("Im selling " + tmp.getTitle() + ", Cost is " + tmp.getPrice() + "\nCheck my info in main_mng_output_info.txt\n");
		}

		wtire(main_mng);
	}
}