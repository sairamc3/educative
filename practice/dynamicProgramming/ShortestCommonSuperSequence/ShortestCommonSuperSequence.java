import java.util.*;
import java.util.stream.*;

public class ShortestCommonSuperSequence {

	public static void main(String[] args) {

		String s1 = "abcdz";
		String s2 = "bdcf";

		System.out.println("Given Strings -> s1: " + s1 + ", s2: " + s2);

		System.out.println("Bruteforce -> " + bruteforce(s1,s2));
		System.out.println("memoization -> " + memoization(s1,s2));
		System.out.println("tabulation -> " + tabulation(s1,s2));
	}

	private static int bruteforce(String s1, String s2) {
		
		return recursiveBruteforce(s1, s2, 0, 0);
	}

	private static int recursiveBruteforce(String s1, String s2, int i1, int i2) {

		if(i1 == s1.length()) return s2.length() - i2;
		if(i2 == s2.length()) return s1.length() - i1;

		if(s1.charAt(i1) == s2.charAt(i2)) {
			return 1 + recursiveBruteforce(s1, s2, i1+1, i2+1);
		}
		int l1 = 1 + recursiveBruteforce(s1, s2, i1+1, i2);
		int l2 = 1 + recursiveBruteforce(s1, s2, i1, i2+1);

		return Math.min(l1, l2);
	}

	private static int memoization(String s1, String s2) {

		// set up the lookup table
		int[][] lookuptable = new int[s1.length()][s2.length()];

		for(int i=0; i<s1.length(); i++) 
			for(int j=0; j<s2.length(); j++)
				lookuptable[i][j] = 0;
		
		return recursiveMemoization(lookuptable, s1, s2, 0, 0);
	}

	private static int recursiveMemoization(int[][] lookuptable, String s1, String s2, int i1, int i2) {

		if(i1 == s1.length()) return s2.length()-i2;
		if(i2 == s2.length()) return s1.length()-i1;

		if(lookuptable[i1][i2] == 0) {

			if(s1.charAt(i1) == s2.charAt(i2)) {

				lookuptable[i1][i2] = 1 + recursiveMemoization(lookuptable, s1, s2, i1+1, i2+1);
			} else {
				int l1 = 1 + recursiveMemoization(lookuptable, s1, s2, i1+1, i2);
				int l2 = 1 + recursiveMemoization(lookuptable, s1, s2, i1, i2+1);
				lookuptable[i1][i2] = Math.min(l1, l2);
			}
		}
		return lookuptable[i1][i2];
	}

	private static int tabulation(String s1, String s2) {

		// set up the look up table
		int[][] lookuptable = new int[s1.length()+1] [s2.length()+2];

		// initialize the array
		for(int i=0; i<=s1.length(); i++) 
			for(int j=0; j<=s2.length(); j++)
				lookuptable[i][j] = 0;

		return tabulation(lookuptable, s1, s2);
	}

	private static int tabulation(int[][] lookuptable, String s1, String s2) {

		for(int i=0; i<=s1.length(); i++) lookuptable[i][0] = i;
		for(int j=0; j<=s2.length(); j++) lookuptable[0][j] = j;

		for(int i=1; i<=s1.length(); i++){
			for(int j=1; j<=s2.length(); j++) {

				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					lookuptable[i][j] = 1 + lookuptable[i-1][j-1];
				} else {
					lookuptable[i][j] = 1 + Math.min(lookuptable[i-1][j], lookuptable[i][j-1]);
				}
			}
		}
		return lookuptable[s1.length()][s2.length()];
	}

}
		
