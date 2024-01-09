import java.util.*;
import java.util.stream.*;

public class BinarySearch {

	public static void main(String[] args) {
	
		int[] given = {3,5,21,32,41,100,-21,11,1,3};

		Arrays.sort(given);
		
		System.out.println("Sorted array: ");

		String sortedArrayInString = Arrays.stream(given)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(", ","{","}"));

		int search = 21;

		System.out.println(sortedArrayInString);
		System.out.println("Item being searched: " + search);

		int index = binarySearch(given, search);
		
		if(index >=0) {

			System.out.println("Item found at the index " + index);
		}else {
			System.out.println("Item not found in the array " );
		}

	}

	private static int binarySearch(int[] given, int search){
	
		// Assuming that the given array is sorted
		int start =0;
		int end = given.length-1;
		int mid;
		
		while(start<=end) {

			mid = (start+end)/2;
			
			if(given[mid] > search) {
				end = mid -1;
			} else if (given[mid] < search ) {
				start = mid+1;
			} else {
				return mid;
			}

		}
		return -1;
	}
}	
