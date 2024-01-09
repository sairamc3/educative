import java.util.*;
import java.util.stream.*;

/** 
* Need to still work on the logic to work on quick sort.
* Although i understood the concept. The explination by educative is complex.
* So I am finding an other source to explain this.
* Until them moving to other concepts
*/
public class QuickSort {

	public static void main(String[] args) {
		
		int[] given = {5,4,1,0,5,95,4,-100,200,0};
	
		quickSort(given);

		String sortedArray = Arrays.stream(given)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(", ", "{", "}"));

		System.out.println(sortedArray);

	}

	private static void quickSort(int[] given) {

	}

}
