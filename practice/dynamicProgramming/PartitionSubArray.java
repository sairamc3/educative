import java.util.*;
import java.util.stream.*;

public class PartitionSubArray {

	public static void main(String[] args) {

		int[] given = {1, 2, 3, 4};

		System.out.println("Given Array -> " + Arrays.stream(given)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(",","{","}")));

		System.out.println("Using bruteforce approach -> " + bruteforce(given));

		System.out.println("Using memoization approach -> " + memoization(given));
	}

	private static boolean bruteforce(int[] given) {

		int sum = Arrays.stream(given).sum();


		if(sum%2 != 0) return false;


		return recursiveBruteForce(given, sum/2, 0);
	}

	private static boolean recursiveBruteForce(int[] given, int sum, int currentIndex) {


		// do some basic validations
		if(sum == 0) return true;

		if(given.length ==0 || currentIndex >= given.length ) return false;

		if(given[currentIndex] <= sum)
			if(recursiveBruteForce(given, sum - given[currentIndex], currentIndex + 1)) 
				return true;

		return recursiveBruteForce(given, sum, currentIndex+1);
	}

		

	/** This is the same approach but to improve the performance
	 * Storing some solutions and then not repeating the same process again
	 */
	private static boolean memoization(int[] given) {

		int sum = Arrays.stream(given).sum();

		if(sum % 2 !=0) return false;

		int[][] lookuptable = new int[given.length][];

		for(int i = 0; i< given.length ; i++ ) {
			lookuptable[i] = new int[sum + 1];

			for(int j=0; j<= sum; j++) {

				lookuptable[i][j] = -1;
			}
		}


		if(recursiveMemoization(lookuptable, given, sum/2, 0) == 1) return true;
		else return false;
	}

	private static int recursiveMemoization(int[][] lookuptable, int[] given, int sum, int currentIndex) {


		if(sum == 0) return 1;

		if(given.length == 0 || currentIndex >= given.length) return 0;

		if(lookuptable[currentIndex][sum] == -1) {

			if(given[currentIndex] <= sum) {
				if(recursiveMemoization(lookuptable, given, sum - given[currentIndex], currentIndex + 1) == 1) {
					lookuptable[currentIndex][sum] = 1;
					return 1;
				}
			} 

			lookuptable[currentIndex][sum] = recursiveMemoization(lookuptable, given, sum, currentIndex + 1);
		}

		return lookuptable[currentIndex][sum];
	}

}
