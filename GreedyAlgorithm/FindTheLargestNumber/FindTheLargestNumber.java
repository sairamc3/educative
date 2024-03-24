import java.util.*;
import java.util.stream.*;

public class FindTheLargestNumber {

	public static void main(String[] args) {

		int digitCount = 3;
		int sumOfDigits = 20;

		int maxNumber = findMaxNumber(digitCount, sumOfDigits);

		System.out.println(" Given \t Digit Count -> " + digitCount + " ,Sum of the digits -> " + sumOfDigits);

		System.out.println("The possible Max number is -> " + maxNumber);
	}

	/**
	 * Idea to implement
	 * The largest digit would be 9
	 * Start with left most element.
	 * if the sum is greater than 9 then add 9 as the left most digit.
	 * If the sum is less than or equal to 9 then add the sum as the left remaining element and 
	 * for the remaining elements add 0 as the remaning digits.
	 */
	public static int findMaxNumber(int digitCount, int sumOfDigits) {
		
		// String is one way to append the number
		// In it's place even array can be used and printed as combined output
		String number = "";

		// Iterate through the no of digits
		for(int i=0; i<digitCount; i++) {

			// Initialize the digit as 0
			int digit = 0;

			if(sumOfDigits > 9) digit = 9;
			else if(sumOfDigits <= 9) digit = sumOfDigits;
			
			sumOfDigits -= digit;

			number += digit;
		}

		// if the sum is not equal to 0
		// that means even after adding all 9's, if the sum is greater 
		// then we cannot find the number
		// in a real problem we might want to print 'none'
		if(sumOfDigits !=0) return 0;

		return Integer.valueOf(number);

	}
}

