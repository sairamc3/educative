import java.util.*;
import java.util.stream.*;

public class StariCase {

	public static void main (String [] args) {

		System.out.println("BruteForce Approach -> " + countWays(10));
		System.out.println("Memoization Approach -> " + memoization(10));
		System.out.println("Tabularization Approach -> " + tabularization(10));
	}

	private static int countWays(int n) {

		if(n<0) return 0;
		else if (n == 0) return 1;
		else return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}

	private static int memoization(int n) {

		int[] lookupTable = new int[n+1];

		for(int i=0; i<n+1; i++) {

			lookupTable[i] = -1;
		}

		return countWays(n, lookupTable);
	}

	private static int countWays(int n, int[] lookupTable) {

		if(n<0) return 0;
		else if(n == 0) return 1;
		else if(lookupTable[n] > -1) return lookupTable[n];
		else lookupTable[n] = countWays(n-1, lookupTable) + countWays(n-2, lookupTable) + countWays(n-3, lookupTable);

		return lookupTable[n];
	}

	private static int tabularization(int n) {

		int[] lookupTable = new int[n+1];
		
		// initialize first 3 elements
		lookupTable[0] = 1;
		lookupTable[1] = 1;
		lookupTable[2] = 2;

		for(int i=3; i<=n; i++) {

			lookupTable[i] = lookupTable[i-1] + lookupTable[i-2] + lookupTable[i-3];
		}

		return lookupTable[n];
	}
}
