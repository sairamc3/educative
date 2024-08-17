import java.util.*;
import java.util.stream.*;

public class SelectionSort {

	public static void main(String[] args) {

		int[] unsortedArray = {5,4,1,0,5,95,4,-100,200,0};

		int[] sortedArray = selectionSort(Arrays.copyOf(unsortedArray, unsortedArray.length));

		System.out.println("Unsorted Array: " + Arrays.stream(unsortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

		System.out.println("Sorted Array: " + Arrays.stream(sortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

	}

	private static int[] selectionSort(int[] unsortedArray) {

		int length = unsortedArray.length;

		for(int i=0; i< length; i++) {

			int minIndex = findMinIndex(unsortedArray, length, i) ;

			int temp = unsortedArray[minIndex];
			unsortedArray[minIndex] = unsortedArray[i];
			unsortedArray[i] = temp;
		}

		return unsortedArray;
	}
	

	private static int findMinIndex(int[] unsortedArray, int length, int currentIndex) {

		int minIndex = currentIndex;

		for(int i=currentIndex; i < length; i++) {
			
			if(unsortedArray[i] < unsortedArray[minIndex]) minIndex = i;
		}

		return minIndex;
	}

}
