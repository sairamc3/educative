import java.util.*;
import java.util.stream.*;

public class StringInterleaving {

	public static void main(String[] args) {

		String m = "abcdef";
		String n = "mnop";
		String p = "mnaobcdepf";

		System.out.println("Given Strings: ");
		System.out.println("m -> " + m);
		System.out.println("n -> " +n);
		System.out.println("p -> " + p);

		boolean bruteForce = bruteForce(m,n,p);
		boolean memoization = memoization(m,n,p);
		boolean tabulation = tabulation(m,n,p);

		System.out.println("BruteForce ->" + bruteForce);
		System.out.println("Memoization ->" + memoization);
		System.out.println("Tabulation ->" + tabulation);
	}

	public static boolean bruteForce(String m, String n, String p) {

		return bruteForce(m, n, p, 0, 0, 0);
	}

	private static boolean bruteForce(String m, String n, String p, int mIndex, int nIndex, int pIndex) {

		if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length()) return true;

		if(pIndex == p.length()) return false;

		boolean b1=false, b2=false;

		if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex)) 
			b1 = bruteForce(m,n,p,mIndex+1, nIndex, pIndex+1);

		if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
			b2 = bruteForce(m,n,p,mIndex, nIndex+1, pIndex+1);

		return (b1 || b2);
	}

	public static boolean memoization(String m, String n, String p) {

		Map<String, Boolean> lookupMap = new HashMap<>();

		return memoization(lookupMap, m, n, p, 0,0,0);
	}

	private static boolean memoization(Map<String, Boolean> lookupMap, 
														String m, 
														String n, 
														String p, 
														int mIndex, 
														int nIndex, 
														int pIndex)
	{
		if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length()) return true;

		if(pIndex == p.length()) return false;

		String subProblemKey = m + "-" + n + "-" + p;

		if(lookupMap.containsKey(subProblemKey) == false){

			boolean b1 = false, b2=false;

			if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
				b1 = memoization(lookupMap, m, n, p, mIndex+1, nIndex, pIndex+1);
			if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
				b2 = memoization(lookupMap, m, n, p, mIndex, nIndex+1, pIndex+1);

			lookupMap.put(subProblemKey, b1||b2);

		}
		return lookupMap.get(subProblemKey);
	}

	/**
	 * The logic in this method is little different
	 */
	public static boolean tabulation(String m, String n, String p) {

		boolean[][] lookupTable = new boolean[m.length()+1][n.length()+1];

		if(m.length() + n.length() != p.length()) return false;
		
		for(int mIndex=0; mIndex<=m.length(); mIndex++) {

			for(int nIndex=0; nIndex<=n.length(); nIndex++) {

				if(mIndex==0 && nIndex == 0) lookupTable[mIndex][nIndex] = true;
				else if(mIndex==0 && n.charAt(nIndex-1) == p.charAt(mIndex + nIndex -1))
					lookupTable[mIndex][nIndex] = lookupTable[mIndex][nIndex-1];
				else if(nIndex==0 && m.charAt(mIndex-1) == p.charAt(mIndex + nIndex -1))
					lookupTable[mIndex][nIndex] = lookupTable[mIndex-1][nIndex];
				else {
					if(mIndex > 0 && m.charAt(mIndex-1) == p.charAt(mIndex + nIndex -1))
						lookupTable[mIndex][nIndex] = lookupTable[mIndex-1][nIndex];
					if(nIndex > 0 && n.charAt(nIndex-1) == p.charAt(mIndex + nIndex -1))
						lookupTable[mIndex][nIndex] |= lookupTable[mIndex][nIndex-1];
				}
			}
		}
		

		return lookupTable[m.length()][n.length()];
	}

}
