import java.util.*;

public class CollectCoins {

	public static void main(String[] args) {

		int[] input1 = {3,1,1,5,1};
		int[] input2 = {4,2,1,5,2};

		System.out.println("Min Steps required for " + Arrays.toString(input1) + " --> " + minSteps(input1));
		System.out.println("Min Steps required for " + Arrays.toString(input2) + " --> " + minSteps(input2));
	}

	private static int minSteps(int[] given) {

		return minStepsUntil(0, given.length, 0, given);
	}

	private static int minStepsUntil(int left, int right, int h, int[] given) {

		// Base case 
		// All coins are collected
		if(left >= right) return 0;

		// Find the index of the element which has lower value
		int min = left; 

		for(int i=left; i<right; i++) 
			if(given[i] < given[min]) min = i;

		return Math.min(right - left, // all vertical lines 
				minStepsUntil(left, min, given[min], given) // horizantal lines left
				+ minStepsUntil(min+1, right, given[min], given) // horizantal lines right
				+ given[min] // The no of horizantal lines collected (given[min] -h) 
				- h);
	}
}


