package eltex_tasks;
import java.io.*;
import java.util.Scanner;

class Main {

	public static void read (String [] dev, String [] mng, String [] main_mng)  {

		try {
			FileReader fr = new FileReader ("files/dev.csv");
			Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	dev[j] = scan.nextLine();
	        }
	     }
	     catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	   try {
	       FileReader fr = new FileReader ("files/mng.csv");
	       Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	mng[j] = scan.nextLine();
	        }
	     }
	     catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	    try {
	       FileReader fr = new FileReader ("files/main_mng.csv");
	       Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	main_mng[j] = scan.nextLine();
	        }
	    }
	    catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void wtire (Developer [] dev, Manager [] mng, MainManager [] main_mng) {

		try {
			FileWriter fw = new FileWriter ("files/dev_output_info.csv");
			for (int i = 0; i < 3; ++i) {
				fw.write(dev[i].toCSV() + '\n');	
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	    try {
			FileWriter fw = new FileWriter ("files/mng_output_info.csv");
			for (int i = 0; i < 3; ++i) {
				fw.write(mng[i].toCSV() + '\n');
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	     try {
			FileWriter fw = new FileWriter ("files/main_mng_output_info.csv");
			for (int i = 0; i < 3; ++i) {
				fw.write(main_mng[i].toCSV() + '\n');
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void main(String args[]) {

		String [] devs =  new String[3];
		String [] mngs = new String[3];
		String [] main_mngs = new String[3];

		Developer [] dev = new Developer[3];
		Manager [] mng = new Manager[3];
		MainManager [] main_mng = new MainManager[3];

		read(devs, mngs, main_mngs);

		for (int i = 0; i < 3; ++i) {
			dev[i] = new Developer();
			dev[i].fromCSV(devs[i]);
			dev[i].speak();	
			System.out.println("My last name is" + dev[i].getFio());
			System.out.println("Check my info in dev_output_info.txt\n");
		}

		System.out.println();

		for (int i = 0; i < 3; ++i) {
			mng[i] = new Manager();
			mng[i].fromCSV(mngs[i]);
			mng[i].speak();
			System.out.println("My last name is" + mng[i].getFio());
			System.out.println("Check my info in mng_output_info.txt\n");
		}

		System.out.println();

		for (int i = 0; i < 3; ++i) {
			main_mng[i] = new MainManager();
			main_mng[i].fromCSV(main_mngs[i]);
			main_mng[i].speak();
			main_mng[i].sort();
			System.out.println("My last name is" + main_mng[i].getFio());
			System.out.println("Check my info in main_mng_output_info.txt\n");
		}

		wtire(dev, mng, main_mng);
	}
}