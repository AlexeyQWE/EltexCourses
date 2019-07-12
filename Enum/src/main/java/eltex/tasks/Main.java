package eltex.tasks;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		
		System.out.print("Input day: ");

		Scanner scan = new Scanner(System.in);
		String day = scan.nextLine();

		switch (WorkDay.valueOf(day.toUpperCase())) {

			case MONDAY:
				 System.out.println("5 days left to saturday from " + day  + "!"); break;
			case TUESDAY:
				 System.out.println("4 days left to saturday from " + day  + "!"); break;
			case WEDNESDAY:
				 System.out.println("3 days left to saturday from " + day  + "!"); break;
			case THURSDAY:
				 System.out.println("2 days left to saturday from " + day  + "!"); break;
			case FRIDAY:
				 System.out.println("1 days left to saturday from " + day  + "!"); break;
			default:
				 System.out.println("Current day not found");
		}
	}
}