import java.util.*;

public class BubbleSort {

	public static void main(String arg[]) {
		
		int[] given = {5,4,1,0,5,95,4,-100,200,0};
		
		int[] sortedArray = selectionSort(given);
		
		System.out.print("{");
		for(int value: sortedArray){
			System.out.print(value + ",");
		}
		System.out.print("}");
	}

	private static int[] selectionSort(int[] unsortedArray) {
	
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
