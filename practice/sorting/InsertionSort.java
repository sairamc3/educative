import java.util.*;
import java.util.stream.*;

public class InsertionSort{

	public static void main(String[] args) {

		int[] unsortedArray = {5,4,1,0,5,95,4,-100,200,0};

		int[] sortedArray = insertionSort(Arrays.copyOf(unsortedArray, unsortedArray.length));

		System.out.println("Unsorted Array: " + Arrays.stream(unsortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

		System.out.println("Sorted Array: " + Arrays.stream(sortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

	}

	private static int[] insertionSort(int[] unsortedArray) {

		int length = unsortedArray.length;

		for(int i=1; i<length; i++) {

			int key= unsortedArray[i];

			int j=i-1;

			while(j>=0 && unsortedArray[j] > key) {

				unsortedArray[j+1] = unsortedArray[j];
				j = j-1;
			}
			unsortedArray[j+1] = key;
		}
		

		return unsortedArray;
	}
	


}
