import java.util.*;

public class MissingNumberInSortedArray {

	public static void main(String[] args) {

		int[] array1 = {1,2,3,4,6,7,8,9};
		int[] array2 = {2,3,4};
		int[] array3 = {1,2,3,4,5,6,8};
		int[] array4 = {1,2,3,4,5,6};

		int missingElement1 = findTheMissingElement(array1, 0, array1.length);
		int missingElement2 = findTheMissingElement(array2, 0, array2.length);
		int missingElement3 = findTheMissingElement(array3, 0, array3.length);
		int missingElement4 = findTheMissingElement(array4, 0, array4.length);

		System.out.println("Array 1 -> " + Arrays.toString(array1));
		System.out.println("The missing element in array 1 is ->  " + missingElement1);
		System.out.println("Array 2 -> " + Arrays.toString(array2));
		System.out.println("The missing element in array 2 is ->  " + missingElement2);
		System.out.println("Array 3 -> " + Arrays.toString(array3));
		System.out.println("The missing element in array 3 is ->  " + missingElement3);
		System.out.println("Array 4 -> " + Arrays.toString(array4));
		System.out.println("The missing element in array 4 is ->  " + missingElement4);
	}

	private static int findTheMissingElement(int[] given, int start, int end) {
		
		// If an empty array is given
		if(given.length == 0) return -1;

		// The array should start with 1 and if not that's the missing element
		if(given[0] != 1) return 1;

		// If the last element is equal to the length of the array
		// then none of the elements are missing
		if(given[given.length-1] == given.length) return -1;

		// The above two validations need not be iterated
		// From here actual itertion starts

		// Making sure we are not crossing over
		if(start > end) return -1;

		// Calculate the mid index
		int mid = (start + end)/2;

		// if the middle element is not in order and element before the middle elemet is in order
		// then the middle elment itself is missing 
		if(given[mid] != mid+1 && given[mid-1] == mid) return given[mid]-1;

		// Here the middle elment is out of order
		// So we search the left subarry for the missing element
		if(given[mid] != mid+1) return findTheMissingElement(given, start, mid);

		// here we search the right array, since the middle element is in order
		else return findTheMissingElement(given, mid+1, end);
			
	}
}


