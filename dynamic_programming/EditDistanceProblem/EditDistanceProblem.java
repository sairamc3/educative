import java.util.*;
import java.util.stream.*;

/**
 * Edit distance is a metric to quantify how dissimilar two string are to one another 
 * by counting the min no of operations required to transaform one string to another
 */
public class EditDistanceProblem {

	/**
	 * You are given two strings, write code to calculate how many min distance operations are required to
	 * covert one string to another
	 * Time Complexity: O(3^n)
	 */
	public static void main(String[] args) {

		String str1 = "Tuesday";
		String str2 = "Thursday";

		System.out.println("Given Strings : str1 -> " + str1 + ", str2 -> " + str2);

		int bruteforce = bruteForce(str1, str2, str1.length(), str2.length());
		int memoization = memoization(str1, str2);
		int tabulation = tabulation(str1, str2);

		System.out.println("Bruteforce -> " + bruteforce);
		System.out.println("memoization -> " + memoization);
		System.out.println("tabulation -> " + tabulation);

	}

	/**
	 * Time Complexity: O(3^n)
	 */
	public static int bruteForce(String str1, String str2, int m, int n) {

		// Incase the first string in empty,
		// insert all chars in the second string to first string
		if(m == 0 ) return n;

		// Incase the second string is empty,
		// remove all the chars of the first string 
		if(n == 0 ) return m;
		
		// In case last chars are same,
		// Ignore the last char and count for the remaining string
		if(str1.charAt(m-1) == str2.charAt(n-1)) return bruteForce(str1, str2, m-1, n-1);

		// Incase, the last characters are not same,
		// consider all 3 operations on last character of first string, recursively
		// Take min of all 3 operations
		return 1 +  min(bruteForce(str1, str2, m, n-1), // Insertion
				bruteForce(str1, str2, m-1, n), // Deletion
				bruteForce(str1, str2, m-1, n-1)); // Substitution

	}

	/**
	 * Use LookupTable to store the count and avoid recalculating the same problem
	 * TimeComplexity: O(m*n)
	 */
	public static int memoization(String str1, String str2) {

		int[][] lookupTable = new int[str1.length()][str2.length()];

		// Initialize the lookup table with -1
		for(int i=0; i< str1.length() ; i++) 
			for(int j=0; j< str2.length(); j++)
				lookupTable[i][j] = -1;

		return memoization(str1, str2, str1.length(), str2.length(), lookupTable);
	}

	private static int memoization(String str1, String str2, int m, int n, int[][] lookupTable) {

		if(m == 0) return n;

		if(n == 0) return m;

		// If the recursive call has been called previously
		// then the value might already exist
		if(lookupTable[m-1][n-1] != -1) return lookupTable[m-1][n-1];

		// Incase the last chars are same,
		// igonre the last char and count for remaining
		if(str1.charAt(m-1) == str2.charAt(n-1)) 
			return lookupTable[m-1][n-1] = memoization(str1, str2, m-1, n-1, lookupTable);

		// If the last chars are not same, 
		// Consider all 3 operations on the last char of the first string
		// Recursively, calculate the min of those 3 operations
		return lookupTable[m-1][n-1] = 1 + min(memoization(str1, str2, m, n-1, lookupTable), //Insertion
				memoization(str1, str2, m-1, n, lookupTable), // Deletion
				memoization(str1, str2, m-1, n-1, lookupTable)); // Substitution
	}

	/**
	 * It has the same complexity as memoization 
	 * Time Complexity: O(m*n)
	 */
	public static int tabulation(String str1, String str2) {
		
		int m = str1.length();
		int n = str2.length();

		// Create a table to store the results of subproblems
		int[][] lookupTable = new int[m+1][n+1];

		// Loop through the whole matrix
		for(int i=0; i<=m; i++) {

			for(int j=0; j<=n; j++) {

				// Incase, Str1 is empty
				// Insert all chars of second string into first string
				if(i==0) lookupTable[i][j] = j;

				// Incse, str2 is empty
				// Remove all the characters from the str1
				else if(j==0) lookupTable[i][j] = i;

				// If the last chars are same
				else if(str1.charAt(i-1) == str2.charAt(j-1))
					lookupTable[i][j] = lookupTable[i-1][j-1];
	
				// If the last chars are different
				// Include the current one and along with it find the min of 3 operations
				else 
					lookupTable[i][j] = 1 + min(lookupTable[i][j-1], // Insertion
							lookupTable[i-1][j], // Deletion
							lookupTable[i-1][j-1]); // Substitution
			}
		}

		// Return the last value of the matrix
		return lookupTable[m][n];
	}

	/**
	 * Find the min of all the 3 input parameters
	 */
	private static int min(int a, int b, int c) {

		if(a<=b && a<=c) return a;
		if(b<=a && b<=c) return b;
		else return c;
	}
}
