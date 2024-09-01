import java.util.*;
import java.util.stream.*;

public class LongestPalandromicSubSequence {

	public static void main(String[] args) {

		String given = "abdbca";

		System.out.println("Given String -> " + given);
		System.out.println("BruteForce -> " + bruteforce(given));
		System.out.println("Memoization -> " + memoization(given));
		System.out.println("Tabulation -> " + tabulation(given));
	}

	private static int bruteforce(String given) {

		return recursiveBruteforce(given, 0, given.length()-1);
	}

	private static int recursiveBruteforce(String given, int startIndex, int endIndex){

		if(startIndex > endIndex) return 0;

		if(startIndex == endIndex) return 1;

		if(given.charAt(startIndex) == given.charAt(endIndex)) {
			return 2 + recursiveBruteforce(given, startIndex +1, endIndex -1);
		}
		int l1 = recursiveBruteforce(given, startIndex+1, endIndex);
		int l2 = recursiveBruteforce(given, startIndex, endIndex-1);

		return Math.max(l1,l2);
	}


	private static int memoization(String given) {
		
		int[][] lookuptable = new int[given.length()][given.length()];

		for(int i=0; i<given.length(); i++) 
			for( int j=0; j<given.length(); j++) 
				lookuptable[i][j] = i==j ? 1 : 0;

		return recursiveMemoization(lookuptable, given, 0, given.length() - 1 );
	}

	private static int recursiveMemoization(int[][] lookuptable, String given, int startIndex, int endIndex) {

		if(startIndex > endIndex) return 0;

		if(startIndex == endIndex) return 1;

		if(lookuptable[startIndex][endIndex] == 0) {

			if(given.charAt(startIndex) == given.charAt(endIndex)) {

				lookuptable[startIndex][endIndex] = 2 + recursiveMemoization(lookuptable, given, startIndex +1, endIndex -1);
			} else {
				lookuptable[startIndex][endIndex] = Math.max(recursiveMemoization(lookuptable, given, startIndex + 1, endIndex),
						recursiveMemoization(lookuptable, given, startIndex, endIndex -1));
			}
		}
		return lookuptable[startIndex][endIndex];
	}


	private static int tabulation(String given) {
		
		// set the lookup table
		int[][] lookuptable = new int[given.length()][given.length()];
		
		// We know that palindrome of comparing the same element would be one
		// using that logic, initialize the array with zero and then 1 diagnolly

		for(int i=0; i<given.length(); i++)
			for(int j=0; j< given.length(); j++)
				lookuptable[i][j] = i==j ? 1 : 0;

		for(int startIndex=given.length()-1; startIndex >=0; startIndex--){
			for(int endIndex=startIndex+1; endIndex < given.length(); endIndex++) {

				if(given.charAt(startIndex) == given.charAt(endIndex)) {
					lookuptable[startIndex][endIndex] = 2 + lookuptable[startIndex + 1][endIndex - 1];
				} else {
					lookuptable[startIndex][endIndex] = Math.max(lookuptable[startIndex+1][endIndex],
							lookuptable[startIndex][endIndex-1]);
				}
			}
		}

		return lookuptable[0][given.length()-1];
	}
}

