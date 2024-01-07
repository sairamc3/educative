import java.util.*;
import java.util.stream.*;

/**
* It works the way you would normally sort items in real life.
* It iterates over the given array, finds the correct position of the element in the array.
* And Inserts each element in its place.
* Complexity: O(n^2)
* This algorithm is not efficient.
*/
public class InsertionSort {

	public static void main (String[] arg) {
		
		int[] givenArray = {5,4,1,0,5,95,4,-100,200,0};
		
		int[] sortedArray = insertionSort(givenArray);

		String sortedArrayInString = Arrays.stream(sortedArray)
			.mapToObj(String::valueOf)
			.collect(Collectors.joining(", ", "{", "}"));
		System.out.println(sortedArrayInString);
	}
	

	public static int[] insertionSort(int[] givenArray){
		
		int element;
		int j;
		
		// Iterate over each element in the array
		for(int i=0; i<givenArray.length; i++) {
		
			// Store the current iterating value in a variable
			element = givenArray[i];
			j=i-1;

			// Shift the elements back to create space for inserting the element
			while(j>=0 && givenArray[j]>element) {
				
				givenArray[j+1]=givenArray[j];
				j = j-1;
			}
			givenArray[j+1]=element;
		}
	 
		
		return givenArray;
	}
}
