import java.util.*;
import java.util.stream.*;

public class MergeSort{

	public static void main(String[] args) {

		int[] unsortedArray = {5,4,1,0,5,95,4,-100,200,0};


		System.out.println("Unsorted Array: " + Arrays.stream(unsortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

		mergeSort(unsortedArray,
				0, 
				unsortedArray.length-1);

		System.out.println("Sorted Array: " + Arrays.stream(unsortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

	}

	private static void mergeSort(int[] unsortedArray, int leftIndex, int rightIndex) {


		if(leftIndex >= rightIndex) return ;


			int midIndex = leftIndex + (rightIndex-leftIndex)/2;

			// dividing the array into left and right arrays
			mergeSort(unsortedArray, leftIndex, midIndex); // left array
			mergeSort(unsortedArray, midIndex+1, rightIndex); // right array

			// Merging the array
			mergeSort(unsortedArray, leftIndex, midIndex, rightIndex);

	}
	
	private static void mergeSort(int[] unsortedArray, int leftIndex, int midIndex, int rightIndex) {

		int i,j,k;

		int sizeOfLeftArray = midIndex - leftIndex + 1;
		int sizeOfRightArray = rightIndex - midIndex;

		// initializing the temperory arrays
		int[] leftArray= new int[sizeOfLeftArray];
		int[] rightArray = new int[sizeOfRightArray];

		// copy the original array content to left and right array
		for( i = 0; i< sizeOfLeftArray; i++) leftArray[i] = unsortedArray[leftIndex + i];
		for( j = 0; j< sizeOfRightArray; j++) rightArray[j] = unsortedArray[midIndex+ 1 + j];

		// merging the temporary arrays back to the original array
		
		i = 0;
		j = 0;
		k = leftIndex;

		while(i<sizeOfLeftArray && j < sizeOfRightArray) {
			
			if(leftArray[i] <= rightArray[j]) {

				unsortedArray[k] = leftArray[i];
				i++;
			} else {
				unsortedArray[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while(i < sizeOfLeftArray) {

			unsortedArray[k] = leftArray[i];
			i++;
			k++;
		}
		while(j < sizeOfRightArray) {

			unsortedArray[k]= rightArray[j];
			j++;
			k++;
		}

	}
}
