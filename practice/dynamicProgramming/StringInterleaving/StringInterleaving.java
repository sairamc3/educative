import java.util.*;
import java.util.stream.*;

public class StringInterleaving {

	public static void main (String[] args) {

		String m = "abd", n = "cef", p= "abcdef";
		
		System.out.println("Given Strings -> m: " + m + ", n: " + n + ", p: " + p);

		System.out.println("BruteForce -> " + bruteforce(m, n, p));
		System.out.println("Memoization -> " + memoization(m, n, p));
		System.out.println("Tabulation -> " + tabulation(m, n, p));
	}

	public static boolean bruteforce(String m, String n, String p) {

		// Call a recursive function with indexes
		return bruteforce(m, n, p, 0, 0, 0);

	}

	public static boolean bruteforce(String m,  String n, String p, int mIndex, int nIndex, int pIndex) {

		// base case
		// If all the lengths are same 
		// Which happens at the end of iterating all the strings
		if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length()) return true;

		if(pIndex == p.length()) return false; 

		boolean b1 = false, b2 = false;

		if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex)) 
			b1 = bruteforce(m, n, p, mIndex + 1, nIndex, pIndex+1);
		if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
			b2 = bruteforce(m, n, p, mIndex, nIndex +1, pIndex+1) ;

		return b1 || b2;
	}



	public static boolean memoization(String m, String n, String p) {

		return false;
	}

	public static boolean tabulation(String m, String n, String p) {

		return false;
	}
}
		

