import java.util.*;

public class ShuffleIntegers {

	public static void main(String[] args) {

		int[] given = {1,3,5,7,2,4,6,8};

		boolean shuffeld = shuffle(given);

		System.out.println("The given array is -> " + Arrays.toString(given));

		if(shuffeld)
			System.out.println("The array is shuffled");
		else
			System.out.println("The array cannot be shuffled");

	}

	/** 
	 * Shuffle the array if it's size is even number
	 */
	private static boolean shuffle(int[] given) {

		// If the given array length is not even we cannot shuffle the array
		// as desired
		if(given.length % 2 != 0 ) return false;

		// If the array is of size two, no need to shuffle
		// we can just say it as shuffled
		if(given.length == 2) return true;

		// Create a new array where the elements can be copied to
		int[] output = new int[given.length];

		// Find the midIndex for dividing the array
		int midIndex = given.length/2;

		// Iterate through the array stepping two indexes every time
		for(int i=0; i<given.length; i=i+2) {
			
			// Since we are incrementing the index by 2
			// The element from the given element should be fetched 1 by one
			// Hence we divide the index of the given array by 2
			output[i] = given[i/2];

			// Add the second part of the given array with the same logic
			output[i+1] = given[midIndex + i/2];
		}

		System.out.println("The shuffled array is -> " + Arrays.toString(output));

		return true;
	}
}


