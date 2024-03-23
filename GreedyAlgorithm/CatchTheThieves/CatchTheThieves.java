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

	public static int greedy(char[] givenArray, int k) {

		return 0;
	}
}


