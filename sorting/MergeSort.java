import java.util.*;
import java.util.stream.*;

/**
* It is a recursive divide and conquer algorithm.
* It divides the given array into two halfes, leftArray and rightArray.
* Sorts those halfes
* Merges them together in order. 
* The merge part is where the most heavy lifting happens.
* Time Complexity: O(nlogn)
*/
public class MergeSort {

	public static void main(String[] arg) {

		int[] given={5,4,1,0,5,95,4,-100,200,0};

		mergeSort(given, 0, given.length-1);

		String sortedArrayAsString = Arrays.stream(given)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(", ", "{", "}"));

		System.out.println(sortedArrayAsString);

	}

	public static void mergeSort(int[] given, int leftIndex, int rightIndex) {

		// Implementation

		if(leftIndex < 0 || rightIndex < 0) return;

		if(rightIndex > leftIndex){
		
			// Equivalant to (leftIndex + rightIndex)/2, but avoids the overflow
			int mid = leftIndex+(rightIndex-leftIndex)/2;
			
			// Sorting the first and second halfes (left and right sub arrays)
			mergeSort(given, leftIndex, mid);
			mergeSort(given, mid+1, rightIndex);
			
			// Merging the array
			merge(given, leftIndex, mid, rightIndex);
		}


	
	}
	
	private static void merge(int[] given, int leftIndex, int mid, int rightIndex) {

		int i, j, k;
		
		// Initializing the size of temperory arrays
		int sizeOfLeftArray = mid - leftIndex +1;
		int sizeOfRightArray= rightIndex - mid;

		// Initializing temperory arrays
		int[] leftArray = new int[sizeOfLeftArray];
		int[] rightArray = new int[sizeOfRightArray];

		// Copying the given array in to temperory arrays
		for( i=0; i<sizeOfLeftArray; i++) {

			leftArray[i]=given[leftIndex + i];
		}

		for( j=0; j<sizeOfRightArray; j++ ) {
		
			rightArray[j] = given[mid+1 +j];
		}


		// Merging the temporary arrays back to the given array

		i=0; // initial index of first sub array
		j=0; // initial index of second sub array
		k=leftIndex; //initial index of the given array

		// This is the main part of the whole algorithm
		// Iterate over the both arrays and copy the smallest one into the given array
		while(i<sizeOfLeftArray && j<sizeOfRightArray) {
			
			if(leftArray[i] <= rightArray[j]) {
				
				given[k] = leftArray[i];
				i++;
			} else {
				
				given[k] = rightArray[j];
				j++;
			}

			k++;
		}

		// Copying the remaining elements of the left array if any are left
		while(i < sizeOfLeftArray) {
			
			given[k] = leftArray[i];
			i++;
			k++;
		}

		// Copying the remaining elements of the right array if any are left
		while(j<sizeOfRightArray) {
		
			given[k] = rightArray[j];
			j++;
			k++;
		}

		
	}
}
