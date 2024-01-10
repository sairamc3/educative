import java.util.*;
import java.util.stream.*;

/**
* Find the element in the array, which is sorted by shifted left or right multiple times
* We can search the whole array to find the element
* but to make it efficient, since it is sorted, need to use modified binary search
*/
public class SearchInRotatedArray {

	public static void main(String[] arg) {
		
		int[] given = {40,100,-100,40,0,24,40};
		int searchElement = -100;

		int foundIndex = binarySearch(given, 0, given.length-1, -100);
		
		System.out.println("Given Array ->" +Arrays.stream(given)
								.mapToObj(String::valueOf)
								.collect(Collectors.joining(", ", "{", "}")))	;
		System.out.println("Searching element ->" + searchElement);
		System.out.println("The element found at the index -> " + foundIndex);
	
	}

	/** 
	* Using modified binary search here
	* Idea is to 
	* 	1. Find the middle element
	* 	2. Check if the middle element is equal to the searchElement (if it is then the process stops)
	*	3. Check if left part of the array is sorted
	* 		- This can be done if left part of the array is less than the middle part of array
	* 		- Then search in the left array
	* 	4. If not search in the right array
	* 	5. Check if right part of the array is sorted
	*		- This can be done if the right part of the array is greater than the middle part of array
	*		- Then search the right array
	*	6. If not search in the left array
	* 	7. Additional case is written to check if there are duplicated elements
	* 	8. If the mid element is equal to the first element then left side all elments are same
	*	9. Then search in the right elment
	* 	10. If not search on the both sides
	* 	11. If the element is not found even then, return -1, represents item not found.
	*/
	private static int binarySearch(int[] given, int left, int right, int searchElement) {
		
		int mid = (left+right)/2;
		
		if(given[mid] == searchElement) return mid;
	
		if(right<left) return -1;

		if(given[left]<given[mid]) {

			// The left half of the array is sorted
			if(searchElement < given[mid] && searchElement >= given[left]) {
				return binarySearch(given, left, mid-1, searchElement);
			} else {
	
				return binarySearch(given, mid+1, right, searchElement);
			}
		} else if(given[mid] < given[right]) {
			// The right half of the array is sorted
			if(searchElement > given[mid] && searchElement <= given[right]) {
				return binarySearch(given, mid+1, right, searchElement);
			} else {
				return binarySearch(given, left, mid-1, searchElement);
			}
		} else if(given[mid] == given[left]) {
			
			// Elements in the left array are all the same 
			if(given[mid] != given[right]) {
				return binarySearch(given, mid+1, right, searchElement);
			} else {
				int result = binarySearch(given, left, mid-1, searchElement);

				if(result == -1) {
					return binarySearch(given, mid+1, right, searchElement);
				} else {
					return result;
				}
			}
		}
		return -1;		

		
	}
}
