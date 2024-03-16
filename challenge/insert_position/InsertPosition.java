import java.util.*;
import java.util.stream.*;

/**
* Find the insertion position of the key element in the array. The array is sorted and does not contain duplicated elements.
* We modified binary search to do the job.
* Modified the binary search by adding a varible position and keep on changing the position as we iterate through the array. 
*/
public class InsertPosition {

	public static void main (String[] args) {

		int[] given = {0, 1, 2, 3, 5, 6};

		int key = 5;

		// Assume there are no duplicates

		System.out.println("Given Array -> " + Arrays.stream(given)
								.mapToObj(String::valueOf)
								.collect(Collectors.joining(", ", "{", "}")));
		System.out.println("Key -> " + key);

		int index = findInsertionOrder(given, key);

		System.out.println("Insertion Order -> " + index);

	}

	private static int findInsertionOrder(int[] given, int key){

		// Modified binary Search

		int start = 0;
		int end = given.length - 1;
		int mid;
		int position=0;

		// Iterating through the array
		while (start <= end) {

			mid = start + (end-start)/2;

			if(given[mid] > key) {

				end = mid -1;
				position = mid; // because  if the value in the array is big, then we will insert it before the element
			} else if (given[mid] < key) {

				start = mid +1;
				position = mid + 1; // because if the value in the array is less, then we will insert it after the element
			} else {
				
				return mid;
			}
		}
		return position;

	}
}	

