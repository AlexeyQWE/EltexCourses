package eltex.tasks;

import java.util.ArrayList;

class lambda {

	public static void main(String[] args) {
		
		ArrayList <Integer> list = new ArrayList <> ();

		for (int i = 0; i < 1001 ; ++i) {
			list.add(i);
		}
		 int sum = list.stream ().map(x ->  x * x).reduce((x,y) -> x + y).get();
		 System.out.println("The sum of squares 0 - 1000 = " + sum);
	}
}