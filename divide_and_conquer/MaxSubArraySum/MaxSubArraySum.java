import java.util.*;
import java.util.stream.*;

public class MaxSubArraySum {

	public static void main (String[] args) {

		int[] given = {-2,-3,4,-1,-2,1,5,-3};

		System.out.println("Given array: " + Arrays.stream(given)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(",","{","}")));

		System.out.println("Through BruteForrce/Naive approach: " + bruteForce(given));
		System.out.println("Through divideAndConquer: " + divideAndConquer(given));
		System.out.println("Through kadanessAlgorithm: " + kadanesAlgorithm(given)); 
	}

	/**
	 * Time complexity: <b>O(n)^2</b>
	 */
	public static int bruteForce(int[] given) {

		int max = 0;

		for(int i=0; i< given.length; i++) {

			int sum =0;

			for(int j=i; j< given.length; j++) {
				
				sum += given[j];

				if(sum > max) max = sum;
			}
		}

		return max;
	}

	/**
	 * <h> Efficient </h>
	 * TimeComplexity: <b>O(n * logn)</b>
	 */
	public static int divideAndConquer(int[] given) {

		return divideAndConquerRecursive(given, 0, given.length-1);
	}

	private static int divideAndConquerRecursive(int[] given, int left, int right) {

		// If there is only one element in the array
		if(left == right) return given[left];

		// Calculate the mid
		int mid = (left + right)/2;

		// Find the max of below possible combinations
		return max(divideAndConquerRecursive(given, left, mid), // Max subarray sum present in the left side of array
				divideAndConquerRecursive(given, mid+1, right), // Max subarray sum present in the right side of array
				crossingSum(given, left, mid, right)); // Max subarray sum including the midpoint
	}

	private static int max(int n1, int n2, int n3) {

		return Math.max(Math.max(n1, n2), n3);
	}

	/**
	 * Finding the largest possible sum in the given array
	 */
	private static int crossingSum(int[] given, int left, int mid, int right) {

		// mid + elements to the left of the mid

		int sum = 0;
		int leftSum = Integer.MIN_VALUE;

		for(int i=mid; i>=left; i--) {

			sum += given[i];

			if(sum > leftSum) leftSum = sum ;
		}

		// mid + elements to the right of the mid
		sum = 0;
		int rightSum = Integer.MIN_VALUE;

		for(int i=mid+1; i<=right; i++) {

			sum += given[i];

			if(sum > rightSum) rightSum = sum;
		}

		return leftSum + rightSum;
	}


	public static int kadanesAlgorithm(int[] given) {

		return -1;
	}

}

