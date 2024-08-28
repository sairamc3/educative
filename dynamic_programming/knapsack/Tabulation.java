import java.util.*;
import java.util.stream.*;

public class Tabulation {

	public static void main (String[] args) {

		int[] weights = {1, 2, 3, 5};
		int[] profits = {1, 6, 10, 16};

		int capacity = 6;

		System.out.println("Total KnapSack Profit " + knapsack(profits, profits.length, weights, weights.length, capacity));
	}

	private static int knapsack(int[] profits, int profitsLength, int[] weights, int weightsLength, int capacity) {

		// Basic validations
		if(capacity <= 0 
				|| profitsLength != weightsLength
				|| profitsLength == 0
		  ) return 0;

		// Lookup table
		int[][] lookupTable = new int[profitsLength+1][capacity+1];

		// Building lookup table in bottom up manner
		int i, cap;

		for(i=0; i <= profitsLength; i++) {

			for(cap=0; cap<=capacity; cap++) {

				if(i == 0 || cap == 0) lookupTable[i][cap] = 0;
				else if(weights[i-1] <= cap) 
					lookupTable[i][cap] = Math.max(profits[i-1] + lookupTable[i-1][cap-weights[i-1]], lookupTable[i-1][cap]);
				else lookupTable[i][cap] = lookupTable[i-1][cap];
			}
		}

		return lookupTable[profitsLength][capacity];
	}
}


