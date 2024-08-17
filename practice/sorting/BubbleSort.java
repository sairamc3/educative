import java.util.*;
import java.util.stream.*;

public class BubbleSort{

	public static void main(String[] args) {

		int[] unsortedArray = {5,4,1,0,5,95,4,-100,200,0};

		int[] sortedArray = bubbleSort(Arrays.copyOf(unsortedArray, unsortedArray.length));

		System.out.println("Unsorted Array: " + Arrays.stream(unsortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

		System.out.println("Sorted Array: " + Arrays.stream(sortedArray)
				.mapToObj(String::valueOf)
				.collect(Collectors.joining(", ", "{", "}")));

	}

	private static int[] bubbleSort(int[] unsortedArray) {

		int length = unsortedArray.length;
		
		int[] sortedArray = unsortedArray;
		for(int i=0; i< length-1; i++) {
			
			for(int j=0; j< length - i - 1; j++) {

				if(unsortedArray[j] > unsortedArray[j+1]) {

					int temp = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = temp;
				}
			}
		}

		return unsortedArray;
	}
	


}
