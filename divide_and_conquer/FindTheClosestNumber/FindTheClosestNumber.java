import java.util.*;
import java.util.stream.*;

/**
 * Find the closest number in the given array for the provided target.
 *
 * 1. There can be duplicates in the array
 * 2. There can be negative numbers in the array
 */
public class FindTheClosestNumber {

	public static void main(String[] args) {

		// Case 1
		int[] given1 = {1,2,4,5,6,6,8,9};
		int target1 = 7;

		System.out.println("Given 1 array ->" + Arrays.toString(given1));
		System.out.println("Target -> " + target1);
		System.out.println("The Closest Number is -> " + closestNumber(given1, target1));
		
		// Case 2
		int[] given2 = {3,5,7,9,11,17};
		int target2 = 10;

		System.out.println("Given 2 array ->" + Arrays.toString(given2));
		System.out.println("Target -> " + target2);
		System.out.println("The Closest Number is -> " + closestNumber(given2, target2));
	}

	/**
	 * Make the standard obvious checks and call the recursive method for binary search
	 */
	private static int closestNumber(int[] given, int target){

		// If there are not elments in the given array just return -1
		// This is never defined in the question
		if(given.length == 0) return -1;

		// If the length of the array is 1 then it's the only nearest number
		if(given.length == 1) return given[0];

		// If the target number is bigger than the right most element then 
		// the last element is the nearest element
		if(target > given[given.length -1]) return given[given.length -1];
		
		// If the given number is less than the left most element
		// then the first element is the nearest element
		if(target < given[0]) return given[0];

		// If none of the cases above match then call the recursive function. 
		return recursive(given, target, 0, given.length -1);
	}

	/**
	 * It follows the similar search of the binary search 
	 */
	private static int recursive(int[] given, int target, int start, int end) {

		int mid = (start + end)/2;
	
		// If the mid element is equal to the target,
		// then no need to search anymore, we can return the mid element
		if(given[mid] == target) return given[mid];

		// if the mid element is bigger than the target
		// Then we should continue to search in the left part of the array
		if(target < given[mid]) {

			// If the one element just before the mid element is lesser than the target
			// That means target is in between the mid and mid-1
			if(mid >0 && target > given[mid-1]) {

				// Then find the closer value among the two
				return closer(given[mid-1], given[mid], target);
			}

			// If not iterate through the left part of the arry
			return recursive(given, target, start, mid);
			
		} else {
			// When target is greater than the mid elment
			// You should continue with the right part of the array
			
			// if the next element to the array is larger than the target
			// Then the closer value lies in between mid and mid+1
			if(mid < given.length-1 && target < given[mid+1])

				// Find the closer value among the two
				return closer(given[mid], given[mid+1], target);

			// Search for the element in the right array
			return recursive(given, target, mid+1, end);
		}
	}

	/**
	 * Find the closer value of the target among the provided two values
	 */
	private static int closer(int first, int second, int target) {

		if((target - first) >= (second - target))
			return second;
		else
			return first;
	}

}
