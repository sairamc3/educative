import java.util.*;
import java.util.stream.*;

/** This sorting technique is not always efficient
 * It depends on which index are we going to choose as pivot
 * Normatlly pivot is taken either the last or the middle element
 */
public class QuickSort{

	public static void main(String[] args) {

		int[] unsortedArray = {5,4,1,0,5,95,4,-100,200,0};


		System.out.println("Unsorted Array: " + Arrays.stream(unsortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

		quickSort(unsortedArray,
				0, 
				unsortedArray.length-1);

		System.out.println("Sorted Array: " + Arrays.stream(unsortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

	}

	private static void quickSort(int[] given, int low, int high) {

		// Stop further processing
		if(low >= high) return;

		// Find the pivot index
		// And sort based on the comparing with the pivot element
		int pivotIndex = process(given, low, high);

		// Subdivide the process into subarray
		quickSort(given, low, pivotIndex-1);
		quickSort(given, pivotIndex+1, high);

	}

	private static int process(int[] given, int low, int high) {

		// Get the value of the pivot element
		// Here we are taking the last element as pivot here
		// There are some other approaches to identify which pivot element can be taken
		int pi = given[high];

		int i=low-1;

		// Iterate through the loop between low and high
		for(int j=low; j < high; j++) {

			// if the comparing element is less than the pivot element
			if(given[j] < pi) {
				
				// Exchange the element 
				i++;
				int temp = given[j];
				given[j] = given[i];
				given[i] = temp;
			}
		}

		// By here the elmenets which are less than the pivot element
		// will be placed until the index i
		// So keep the pivot element at place i+1 and retun the index as the pivot index
		int tmp = given[i+1];
		given[i+1] = pi;
		given[high] = tmp;

		return i+1;
	}


}
