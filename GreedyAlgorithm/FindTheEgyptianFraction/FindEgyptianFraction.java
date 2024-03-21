import java.util.*;
import java.util.stream.*;

public class FindEgyptianFraction {

	public static void main(String[] args) {

		int n = 6, d = 14;

		System.out.println("Egyptian Fraction of " + n +"/" + d + " is ");

		printEgyptianFraction(n,d);

	}

	/**
	 * Egyptian Fraction 
	 */
	public static void printEgyptianFraction(int n, int d) {

		// If either of the numerator or denominator is 0, stop the process
		if( n==0 || d == 0) return;
		
		// If numberator divides the denominator  -> fraction is in 1/n form
		// So no need to process further and print the value
		if( d%n == 0) {

			System.out.println("1/" + d/n);
			return;
		}

		// if denominator can divide numerator -> number is not fraction
		if( n%d == 0) {

			System.out.println(n/d);
			return;
		}

		// If numerator is greater than the denominator
		if(n>d) {

			// print the first fraction
			System.out.print(n/d + ",");

			// Iterate through the remaining
			printEgyptianFraction(n%d, d);
			return;
		}

		// This is else case, where denominator > numerator
		// This whole logic can be explained by math notes
		// This is the greatest possible unit fraction
		int x = d/n + 1;

		System.out.print("1/" + x + ",");

		// Call function recursively for the remaining part
		printEgyptianFraction(n*x - d, d*x);
	}
}
		

