import java.util.*;
import java.util.stream.*;

public class CatchTheThieves {

	public static void main(String[] args) {

		char[] givenArray = {'P', 'T', 'T', 'P', 'T'};
		int k = 2;

		int bruteForce = bruteForce(givenArray, k);

		int greedy = greedy(givenArray, k);

		System.out.println("Given array -> " + Arrays.toString(givenArray));

		System.out.println("Brute force -> " + bruteForce);
		System.out.println("Greedy approach -> " + greedy);


	}

	/**
	 * BruteForce Approach.
	 * The idea is to iterate through the array and find the police.
	 * For each police, find if there are any thieves within a distance of k. 
	 * This can be done by iterating through the array from point of the police and until k distance upwards
	 * same has to be done by k distance downwards
	 * Since each police can catch only one thief and each theif can be caught by only one police,
	 * we maintain the status of the police and thief in the array 'caught'
	 * We compare the flage before catching a theif.
	 */
	public static int bruteForce(char[] givenArray, int k){

		int length = givenArray.length;

		int result = 0;

		// Array to track the status of police and thief
		// Since a police can catch only one thief 
		// and a theif can be caught by only one police
		boolean[] caught = new boolean[length];
		
		// Initialize the array with 'false'
		for(boolean c: caught) c=false;

		// Iterate through the array
		for(int i=0; i<length; i++) {

			// If it is police and his status is not caught
			if('P' == givenArray[i] && caught[i] == false) {

				// Iterate upwards until k distance to find the thief
				for(int j=i; j<i+k && j<length; j++) {

					// if the thief is caught
					if(givenArray[j] == 'T' && caught[j] == false) {
					
						// increment the result
						result++;
						
						// mark the status of police as caught
						caught[i] = true;
						
						// mark the status of thief as caught
						caught[j] = true;

						// Since both of them are done.. 
						// we can stop the search for thief by the police
						break;
					}
				}
			}

			// If it is police and his status is not caught
			if('P' == givenArray[i] && caught[i] == false) {

				// iterate downwards until k distance to find the thief
				for(int j=i; j>(j-k) && j>-1; j--) {

					// if thief is caught
					if(givenArray[j] == 'T' && caught[j] == false) {

						// increment the result
						result++;

						// mark the police as caught
						caught[i] = true;

						// mark the thief as caught
						caught[j] = true;

						// stop the search
						break;
					}
				}
			}
		}

		// return the result
		return result;
						
	}

	/**
	 * Store the indexes of Police and thief in the separate arraylist
	 * iterate through both the array list and find the difference between each value of them.
	 * When the absolute difference(ignoring the sign) is less than 'k' 
	 * then we can conclude that the thief is caught and increment the result, police and thief
	 * if not then incrment the one having low value
	 */
	public static int greedy(char[] givenArray, int k) {

		
		int length = givenArray.length;

		int result = 0;

		// Declare the lists
		List<Integer> thieves = new ArrayList<>();
		List<Integer> police = new ArrayList<>();

		// Set element fetching from the given array list
		for(int i=0; i<length; i++) {

			if('P' == givenArray[i]) police.add(i);
			else thieves.add(i);
		}

		// Initialize the indexes
		int trackThieves=0, trackPolice=0;

		// While both the indexes are less than the size of thier corrosponding array lists
		while(trackThieves < thieves.size() && trackPolice < police.size()) {

			// Absolute value ignores the sign of the integer
			// So you can consider the difference as distance and compare with the given limit
			if(Math.abs(thieves.get(trackThieves) - police.get(trackPolice)) <= k) {

				// Increment the result, since theif is caught
				result++;

				// Incriment thieves
				trackThieves++;

				// Incriment police
				trackPolice++;

			} 

			// Since the iteration should not stop for the uncaught thieves
			// Incement the one with low value
			// If thieves index is less then increment it
			else if (thieves.get(trackThieves) < police.get(trackPolice)) trackThieves++;
			
			// if not increment the police
			else trackPolice++;
		}

		return result;
	}
}


