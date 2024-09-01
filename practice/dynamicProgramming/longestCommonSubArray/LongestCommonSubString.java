import java.util.*;
import java.util.stream.*;

public class LongestCommonSubString {

	public static void main(String[] args) {

		String s1 = "0abc321";
		String s2 = "123abcdef";

		System.out.println("s1 -> " +s1);
		System.out.println("s2 -> " +s2);

		System.out.println("The longest common SubString");
		System.out.println("BruteForce " + bruteForce(s1,s2));
		System.out.println("Memoizaton" + memoization(s1,s2));
		System.out.println("Tabulation" + tabulation(s1,s2));
	}

	private static int bruteForce(String s1, String s2) {

		return bruteForceRecursive(s1,s2,0,0,0);
	}

	private static int bruteForceRecursive(String s1, String s2, int i1, int i2, int count) {
		
		if(i1 == s1.length() || i2 == s2.length()) return count;

		if(s1.charAt(i1) == s2.charAt(i2)) {
			count = bruteForceRecursive(s1,s2,i1+1,i2+1,count+1);
		}
		int c1 = bruteForceRecursive(s1,s2,i1+1, i2, 0);
		int c2 = bruteForceRecursive(s1,s2,i1, i2+1, 0);

		count = Math.max(count, Math.max(c1,c2));

		return count;
	}

	private static int memoization(String s1, String s2) {

		int maxOfBothLength = Math.max(s1.length(),s2.length());
		int[][][] lookuptable = new int[s1.length()] [s2.length()] [maxOfBothLength];

		//initialize the lookup table

		for(int i=0; i<s1.length(); i++) 
			for(int j=0; j<s2.length(); j++)
				for(int k=0; k<maxOfBothLength; k++)
					lookuptable[i][j][k] = -1;

		return memoizationRecursive(lookuptable, s1, s2, 0, 0, 0);
	}

	private static int memoizationRecursive(int[][][] lookuptable, String s1, String s2, int i1, int i2, int count) {

		if(s1.length() == i1 || s2.length() == i2) return count;

		if(lookuptable[i1][i2][count] == -1) {

			int c1 = count;
			
			if(s1.charAt(i1) == s2.charAt(i2)){
				c1 = memoizationRecursive(lookuptable, s1, s2, i1+1, i2+1, count+1);
			}
			int c2 = memoizationRecursive(lookuptable, s1, s2, i1+1, i2, 0);
			int c3 = memoizationRecursive(lookuptable, s1, s2, i1, i2+1, 0);

			lookuptable[i1][i2][count] = Math.max(c1, Math.max(c2, c3));
		}
		return lookuptable[i1][i2][count];
	}

	private static int tabulation(String s1, String s2) {

		int maxLength = 0;
		
		int[][] lookuptable = new int[s1.length()+1][s2.length()+1];

		for(int i=0; i<=s1.length(); i++) {
			for(int j=0; j<=s2.length(); j++) {
				lookuptable[i][j] = 0;
			}
		}

		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					lookuptable[i][j] = 1 + lookuptable[i-1][j-1];
					maxLength = Math.max(maxLength, lookuptable[i][j]);
				}
			}
		}


		return maxLength;
	}
}

		
