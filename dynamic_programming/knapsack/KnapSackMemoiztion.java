import java.util.*;
import java.util.stream.*;

public class KnapSackMemoiztion {

	public static void main(String[] args) {

		int[] profits = {1, 6, 10, 16};
		int[] weights = {1, 2, 3, 5};
		int capacity = 6;

		System.out.println("Total KnapSack Profit ----> " 
				+ knapsack(profits, profits.length, weights, weights.length, capacity));
	}

	private static int knapsack(int[] profits, int profitLength, int[] weights, int weightsLength, int capacity) {

		int[][] lookupTable = new int[profitLength][];

		for(int i=0; i<profitLength; i++) {

			lookupTable[i] = new int[capacity+1];

			for( int j=0; j<= capacity; j++) {

				lookupTable[i][j] = 0;
			}
		}

		return knapsack(lookupTable, profits, profitLength, weights, weightsLength, capacity, 0);
	}

	private static int knapsack(int[][] lookupTable, int[] profits, int profitsLength, 
			int[] weights, int weightsLength, int capacity, int currentIndex) {

		// base checks
		if(capacity <=0 
				|| currentIndex >= profitsLength 
				|| currentIndex < 0 
				|| weightsLength != profitsLength
				) 
			return 0;

		// if we have already solved the problem then return the result from the lookup table
		if(lookupTable[currentIndex][capacity] != 0) return lookupTable[currentIndex][capacity];

		// recursive call after choosing the element at the current index
		// if the weight of the currentIndex exceeds the capacity then we should not consider it
		
		int profit1 = 0;

		if(weights[currentIndex] <= capacity) 

			profit1 = profits[currentIndex] + knapsack(lookupTable, profits, profitsLength,
					weights, weightsLength, capacity-weights[currentIndex], currentIndex + 1) ;

		int profit2 = knapsack(lookupTable, profits, profitsLength, weights, weightsLength,
				capacity, currentIndex+1);

		lookupTable[currentIndex][capacity] = Math.max(profit1, profit2);

		return lookupTable[currentIndex][capacity];
	}
}


