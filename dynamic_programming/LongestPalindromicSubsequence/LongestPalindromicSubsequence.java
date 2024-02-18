import java.util.*;
import java.util.stream.*;

public class LongestPalidromaticSubSequence {

	public static void main(String[] args) {

		String given = "cddpd";

		System.out.println("Given String -> " + given);

		int bruteForceCount = bruteForce(given);

		int memoizationCount = memoization(given);

		int tabulationCount = tabulation(given);

		System.out.println("Brute Force approach Count -> " + bruteForceCount);
		System.out.println("Memoization approach Count -> " + memoizationCount);
		System.out.println("Tabulation apporach Count -> " + tabulationCount);
	}

	/**
	 * TimeComplexity : O(2^n)
	 */
	public static int bruteForce(String given) {

		return bruteForce(given, 0, given.length() - 1);

	}

	private static int bruteForce(String given, int startIndex, int endIndex) {

		if (startIndex > endIndex)
			return 0;
		if (startIndex == endIndex)
			return 1;

		if (given.charAt(startIndex) == given.charAt(endIndex))
			return 2 + bruteForce(given, startIndex + 1, endIndex - 1);

		int c1 = bruteForce(given, startIndex + 1, endIndex);
		int c2 = bruteForce(given, startIndex, endIndex - 1);

		return Math.max(c1, c2);
	}

	/**
	 * Time Complexity: O(N^2)
	 * 
	 * @param given
	 * @return
	 */
	public static int memoization(String given) {

		int[][] lookupTable = new int[given.length()][given.length()];

		for (int i = 0; i < given.length(); i++) {

			for (int j = 0; j < given.length(); j++) {

				lookupTable[i][j] = 0;
			}
		}
		return memoization(lookupTable, given, 0, given.length() - 1);
	}

	private static int memoization(int[][] lookupTable, String given, int startIndex, int endIndex) {

		if (startIndex > endIndex)
			return 0;
		if (startIndex == endIndex)
			return 1;

		if (lookupTable[startIndex][endIndex] == 0) {

			if (given.charAt(startIndex) == given.charAt(endIndex))
				lookupTable[startIndex][endIndex] = 2 + memoization(lookupTable, given, startIndex + 1, endIndex - 1);

			else
				lookupTable[startIndex][endIndex] = Math.max(memoization(lookupTable, given, startIndex + 1, endIndex),
						memoization(lookupTable, given, startIndex, endIndex - 1));
		}
		return lookupTable[startIndex][endIndex];
	}

	/**
	 * Bottom up dynamic programming with tabularization
	 * Time complexity O(N^2)
	 * @param given
	 * @return
	 */
	public static int tabulation(String given) {

		int[][] lookupTable = new int[given.length()][given.length()];

		for (int i = 0; i < given.length(); i++)
			for (int j = 0; j < given.length(); j++)
				lookupTable[i][j] = i == j ? 1 : 0;

		for (int startIndex = given.length() - 1; startIndex >= 0; startIndex--) {

			for (int endIndex = startIndex + 1; endIndex < given.length(); endIndex++) {

				lookupTable[startIndex][endIndex] = given.charAt(startIndex) == given.charAt(endIndex)
						? 2 + lookupTable[startIndex + 1][endIndex - 1]
						: Math.max(lookupTable[startIndex + 1][endIndex], lookupTable[startIndex][endIndex - 1]);
			}
		}

		return lookupTable[0][given.length() - 1];

	}

}
