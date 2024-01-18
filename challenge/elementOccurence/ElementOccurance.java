import java.util.*;
import java.util.stream.*;

/**
* Instead of using linear search, binary search has been used to count the no of occurences of the given element in the given array.
* Once the element index is found using binary search. 
* Since it is a sorted array, if the same element is present in the array, then it will be beside the current elment, left or right
* Hence find the count of the elments, which are left and right with the same value.
* That becomes the total no of occurences.
*/
public class ElementOccurance {

	public static void main(String[] args) {

		int[] given = {-5,-3,0,1,3,3,3,3,4,5};

		int searchElement = 3;

		System.out.println("Given Array -> " + Arrays.stream(given)
								.mapToObj(String::valueOf)
								.collect(Collectors.joining(", ", "{", "}"))); 

		System.out.println("searchElement -> " + searchElement);		

		int count = calculateElementFreq(given, searchElement);

		System.out.println("No of Elements -> " + count);
	}

	private static int calculateElementFreq(int[] given, int key) {

		// Find the index of the element in the array using binary search
		int index = binarySearch(given, key, given.length);
	
		if(index == -1) return 0; // If element is not present

		int count = 1;

		// Count the left side of the element 
		int start = index -1;

		while(start >=0 && given[start] == key){

			count++;
			start--;
		}

		// Count the right side of the element
		int end = index +1;
	
		while(end < given.length && given[end] == key) {

			count++;
			end++;
		}
	

		return count;
	}

	private static int binarySearch(int[] given, int key, int size) {

		if(size <=0) return -1;

		if(size ==1) {

			if(key == given[0]) return 0;
			else return -1;
		}

		int start = 0;
		int end = size-1;

		while(start<=end) {
	
			int mid = (start+end)/2;
			
			if(given[mid] < key) {
			
				start = mid +1;
			} else if (given[mid] > key) {

				end = mid-1;
			} else {
			
				return mid;
			}
		}
		return -1;
	}
		
}	
	

