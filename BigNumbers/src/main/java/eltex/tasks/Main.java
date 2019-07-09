package eltex.tasks;
import java.math.*;

class Main {

	public static void main(String[] args) {

		BigInteger num = BigInteger.valueOf(2);

		for (int i = 1; i < 100; ++i) {		
		 	num = num.multiply(BigInteger.valueOf(2));
		}

		System.out.println("BigInteger");
		System.out.println("2^100 = " + num);

		num = BigInteger.valueOf(2);

		for (int i = 1; i < 1000; ++i) {		
		 	num = num.multiply(BigInteger.valueOf(2));
		}

		System.out.println("2^1000 = " + num + "\n\n");


		BigDecimal num1 = BigDecimal.valueOf(2.0);

		for (int i = 1; i < 100; ++i) {		
		 	num1 = num1.multiply(BigDecimal.valueOf(2.0));
		}

		System.out.println("BigDecimal");
		System.out.println("2^100 = " + num1);

		num1 = BigDecimal.valueOf(2.0);

		for (int i = 1; i < 1000; ++i) {		
		 	num1 = num1.multiply(BigDecimal.valueOf(2));
		}

		System.out.println("2^1000 = " + num1);

	}
}