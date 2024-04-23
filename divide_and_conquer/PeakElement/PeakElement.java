import java.util.*;
import java.util.stream.*;

public class PeakElement {

	public static void main(String[] args) {

		int[] given = {13,27,54,31,99,11};

		int peakElementIndex = findAPeakElement(given);

		System.out.println("Given array: " + Arrays.stream(given)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(",","{","}")));
		
		System.out.println("Peak element: " + peakElementIndex);

		// Efficient approach
		// Using divide and conquer
		int peakElmentIndexEfficient = findPeakByDivideAndConquer(given);

		System.out.println("Peak Element by Divide and conquer: " + peakElmentIndexEfficient);
	}

	private static int findPeakByDivideAndConquer(int[] given) {

		int length = given.length;

		return findPeakRecursive(0, length-1, length, given);
	}

	/**
	 * This function is based on recursive binary search algorithm,
	 * returning the index of the peak element in the given array
	 */
	private static int findPeakRecursive(int low, int high, int size, int[] given) {

		// Just like binary search
		// Find the middle element
		int middle = low + (high - low)/2 ;

		// If the nighbours of the middle element exists
		// compare them with the middle element
		if((middle == size-1 || given[middle+1] <= given[middle])
				&& (middle == 0 || given[middle-1] <= given[middle])) return middle;

		// If the left nighbour of the middle element is greater,
		// The peak element must be in the left subarray
		else if(given[middle-1] > given[middle] && middle > 0) 

			return findPeakRecursive(low, middle-1, size, given);

		// If the right nighbour of the middle element is greater,
		// The peak element must be in the right subarray
		else return findPeakRecursive(middle + 1, high, size, given);
	}

	/** 
	 * Own implementation
	 */
	private static int findAPeakElement(int[] given) {

		for(int i=0; i<given.length; i++ ) {

			int index, preIndex, postIndex;
			index = i;

			if(i == 0 ) {
		
				postIndex = index +1;

				if(given[index] > given[postIndex]) return index;
			
			}else if(i == (given.length -1)){
				preIndex = index -1;

				if(given[index] > given[preIndex]) return index;

			}else {

				preIndex = index -1;
				postIndex = index +1;

				if(given[index] > given[preIndex] && given[index] > given[postIndex]) return index;
			}
		}
			
		return -1;
	}
}

