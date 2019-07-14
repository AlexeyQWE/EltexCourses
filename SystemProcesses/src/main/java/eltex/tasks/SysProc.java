package eltex.tasks;
import java.io.*;
import java.lang.NullPointerException;
import java.util.Scanner;

class SysProc {

	public static void main(String[] args) {
		
		File dir = new File("/proc");

		String [] proc_dir = dir.list();
		String [] pid_dir = new String[1000];

		for (int i = 0, j = 0; i <proc_dir.length; ++i) {
			if (proc_dir[i].matches("\\d+")) {
				pid_dir[j] = proc_dir[i];
				++j;
			}
		}

		String [] proc_name = new String [1000];

		for (int i = 0; i < pid_dir.length; ++i) {
			if (pid_dir[i] == null) 
				break;
			try {
				FileReader fr = new FileReader("/proc/" + pid_dir[i] + "/stat");
				Scanner scan = new Scanner(fr);
				while (scan.hasNextLine()) {
					String stat_info = scan.nextLine();
					String [] tmp = stat_info.split("\\(|\\)");
					proc_name[i] = tmp[1];
				}
				fr.close();
			}
			catch (IOException error) {
	     		System.err.print(error.getMessage()); 
	     	}
		}
		writeJSON(pid_dir, proc_name);
	}

	public static void writeJSON(String [] pid_dir, String [] proc_name) {

		File  f = new File("resources/");
		f.mkdir();

		try {
			FileWriter fw = new FileWriter ("resources/proc_info.json");	
			for (int i = 0; i < proc_name.length; ++i)  {
				if (pid_dir[i] == null) {
					fw.write("}");
					break;
				}
			if (i == 0) 
				fw.write("{\n\"PID\":\"" + pid_dir[i] +"\",\"Program name\":\"" + proc_name[i] +"\",\n");
			else if (pid_dir[i + 1] == null)
				fw.write("\"PID\":\"" + pid_dir[i] +"\",\"Program name\":\"" + proc_name[i] +"\"\n");
			else
				fw.write("\"PID\":\"" + pid_dir[i] +"\",\"Program name\":\"" + proc_name[i] +"\",\n");
			}
			fw.close();
		}
		catch (IOException error) {
			    System.err.print(error.getMessage()); 
		}

	}
}