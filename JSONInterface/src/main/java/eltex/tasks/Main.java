package eltex.tasks;
import java.util.Scanner;
import java.io.*;


public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		String json_info = null;

		try {
				FileReader fr = new FileReader ("resources/user_info.json");
				Scanner scan = new Scanner(fr);

				for (; scan.hasNextLine();) 
		          	json_info = scan.nextLine();	       
		        fr.close();
		     }
		     catch (IOException error) {
		     	System.err.print(error.getMessage()); 
		     }

		user.fromJSON(json_info);

		try {
				FileWriter fw = new FileWriter ("resources/user_output_info.json");
				fw.write(user.toJSON());
				fw.close();
		}
		catch (IOException error) {
	     	System.err.print(error.getMessage()); 
	     }

	System.out.println(user.getfirstName() + " " + user.getlastName());
	}

}
