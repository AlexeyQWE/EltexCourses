package eltex.tasks;
import java.io.*;
import java.sql.SQLException;
import java.util.Scanner;

class Main {

	public static void read (String [] dev, String [] mng)  {

		try {
			FileReader fr = new FileReader ("resources/dev.csv");
			Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	dev[j] = scan.nextLine();
	        }
	        fr.close();
	     }
	     catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	   try {
	       FileReader fr = new FileReader ("resources/mng.csv");
	       Scanner scan = new Scanner(fr);

			for (int j = 0; scan.hasNextLine(); ++j) {
	           	mng[j] = scan.nextLine();
	        }
	        fr.close();
	     }
	     catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void wtire (Developer [] dev, Manager [] mng) {

		try {
			FileWriter fw = new FileWriter ("resources/dev_output_info.csv");
			for (int i = 0; i < 3; ++i) {
				fw.write(dev[i].toCSV(i) + '\n');
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	    try {
			FileWriter fw = new FileWriter ("resources/mng_output_info.csv");
			for (int i = 0; i < 3; ++i) {
				fw.write(mng[i].toCSV(i) + '\n');
			}
			fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }
	}

	public static void main(String args[]) throws SQLException {

		String [] devs =  new String[3];
		String [] mngs = new String[3];

		Developer [] dev = new Developer[3];
		Manager [] mng = new Manager[3];
		
		read(devs, mngs);

		for (int i = 0; i < 3; ++i) {
			dev[i] = new Developer();
			dev[i].fromCSV(devs[i]);
		}

		System.out.println();

		for (int i = 0; i < 3; ++i) {
			mng[i] = new Manager();
			mng[i].fromCSV(mngs[i]);
		}

		//DUMP.fromMySQL(dev,mng);
		//DUMP.toMySQL(dev, mng);
		wtire(dev, mng);

		Task <Manager, Developer > [] task =  new Task[3]; 

		for (int i = 0; i < 3; ++i) {
			task[i] = new Task <> ();
			task[i].setOwner(mng[i]);
			task[i].setQa(dev[i]);
			task[i].setTitle("Data base testing");
			task[i].setDescription("Fix bag in data base system");
		}

	}
}