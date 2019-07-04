package eltex_tasks;
import java.util.Scanner; 

class SimpleCalc {
	public static void main(String args[]){

		String expr;
		System.out.print("Введите выражение: ");
		Scanner sc = new Scanner (System.in);
		expr = sc.nextLine();

		String [] pars = expr.split(" ");
		double el1 = Double.parseDouble(pars[0]); 
		double el2 = Double.parseDouble(pars[2]);

		switch (pars[1]) {
			case "+": 
				System.out.println("Результат: " + expr + " = " + (el1 + el2));
				break;
			case "-": 
				System.out.println("Результат: " + expr + " = " + (el1 - el2));
				break;
			case "*": 
				System.out.println("Результат: " + expr + " = " + (el1 * el2));
				break;
			case "/": 
				System.out.println("Результат: " + expr + " = " + (el1 / el2));
				break;
		 	
		 } 
	}
}
