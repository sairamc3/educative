import java.util.*;
import java.util.stream.*;

/**
 * This isn't the right approach
 * I did not understand the problem right. But the code is doing what I have expected it to do.
 * So need to rework on why the problem is different, with pleasent mind
 */
public class ShortCommonSuperSeq {

    public static void main(String[] args) {
        
        String s1 = "abcdz";
        String s2 = "bdcf";

        System.out.println("s1 -> " + s1);
        System.out.println("s2 -> " + s2);

        int brute = bruteForce(s1, s2);
	int memoization = memoization(s1, s2);
	int tabulation = tabulation(s1, s2);
        
	System.out.println("SCS using Bruteforce -> " + brute);
	System.out.println("SCS using memoization -> " + memoization);
	System.out.println("SCS using tabulation -> " + tabulation);
    }
	
	/** 
	* Brute Force approach
	*/
	public static int bruteForce(String s1, String s2){
		
		int count = bruteForce(s1,s2,0,0);
		
		return count;
	}

	private static int bruteForce(String s1, String s2, int i1, int i2){

		int count = 0;

		if(i1 == s1.length()) return s2.length()-i2;
		if(i2 == s2.length()) return s1.length()-i1;

		if(s1.charAt(i1)==s1.charAt(i2)) count = 1+ bruteForce(s1,s2, i1+1, i2+1);
		else {
			int c1 = 1+ bruteForce(s1,s2, i1+1, i2);
			int c2 = 1+ bruteForce(s1,s2, i1, i2+1);
		
			count = Math.min(c1, c2);
		}
		return count;
	}


	/** 
	* Memoization approach
	*/
	public static int memoization(String s1, String s2) {
		
		int[][] lookupTable = new int[s1.length()][s2.length()];

		for(int i=0; i<s1.length(); i++) {
	
			for(int j=0; j< s2.length(); j++) {

				lookupTable[i][j] = 0;
			}
		}
		
		return memoization(lookupTable, s1, s2, 0, 0);
	}

	private static int memoization(int[][] lookupTable, String s1, String s2, int i1, int i2){

		if(i1 >= s1.length()) return s2.length()-i2;
		if(i2 >= s2.length()) return s2.length()-i1;

		if(lookupTable[i1][i2] == 0 ){

			if(s1.charAt(i1) == s2.charAt(i2)) 
				lookupTable[i1][i2] = 1 + memoization(lookupTable, s1, s2, i1+1, i1+2);
			else {
				lookupTable[i1][i2] = Math.min(1+ memoization(lookupTable, s1, s2, i1+1, i2),
								1 + memoization(lookupTable, s1, s2, i1, i2+1));
			}
 		}
		return lookupTable[i1][i2];
	}
		

	/** 
	* Tabulation approach
	*/
	public static int tabulation(String s1, String s2) {
		
		int l1 = s1.length();
		int l2 = s2.length();

		int[][] lookupTable = new int[l1+1][l2+1];

		for(int i=0; i<=l1; i++) {
	
			for(int j=0; j<=l2; j++) {

				lookupTable[i][j] = 0;
			}
		}

		for(int i=0; i<=l1; i++) lookupTable[i][0] = i;
		for(int j=0; j<=l2; j++) lookupTable[0][j] = j;

		for(int i=1; i<=l1; i++){
			for(int j=1; j<=l2; j++) {
			
				if(s1.charAt(i-1)==s2.charAt(j-1)) lookupTable[i][j] = 1 + lookupTable[i-1][j-1];
				else lookupTable[i][j] = 1+ Math.min( lookupTable[i-1][j],
									 lookupTable[i][j-1]);
			}
		} 
		

		return lookupTable[l1][l2];
	}


   
}
