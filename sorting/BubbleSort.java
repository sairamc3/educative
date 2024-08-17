import java.util.*;


/**
* For BubbleSort better to visualize to remember this. 
* For every iteration the max element will reach the last index. 
* Hence the inner loop can exclude already last element in every iteration.
* Hence the inner loop has "unsortedArray.length - i -1" as the condition.
* Bubble sort compares two adjecent values starting from index 0, and moves the max
* value to the right. 
* So max value will reach the last index in the array by the end of the array.
* Hence for the next iteration we can exclude the last element, reducing the comparisions.
*/
public class BubbleSort {

	public static void main(String arg[]) {
		
		int[] given = {5,4,1,0,5,95,4,-100,200,0};
		
		int[] sortedArray = bubbleSort(given);
		
		System.out.print("{");
		for(int value: sortedArray){
			System.out.print(value + ",");
		}
		System.out.print("}");
	}

	private static int[] bubbleSort(int[] unsortedArray) {
	
		for(int i=0; i< unsortedArray.length - 1; i++) {

			for(int j=0; j< unsortedArray.length - i - 1; j++) {
				
				if(unsortedArray[j] > unsortedArray[j+1]) {
					
					int temp = unsortedArray[j];
					unsortedArray[j]=unsortedArray[j+1];
					unsortedArray[j+1] = temp;
				}
			}
		}
	
		return unsortedArray;
	}
}
