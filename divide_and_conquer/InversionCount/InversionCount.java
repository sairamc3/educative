import java.util.*;

public class InversionCount {

	public static void main(String[] args) {

		int[] given = {9,5,6,11,8,10};

		System.out.println("Given array -> " + Arrays.toString(given));

		int inversions = findInversions(given);

		System.out.println("The inversion required for sorted array are -> " + inversions);

		int efficient = findInversionEfficient(given);

		System.out.println("The inversion using effective method -> " + efficient);
	}

	private static int findInversions(int[] given) {

		int count = 0;

		for(int i=0; i<given.length-1; i++) {

			for(int j=i+1; j<given.length; j++) {

				if(given[i] > given[j]) count++;
			}
		}
		return count;
	}

	/**
	 * The solution is suggested by Educative
	 * but the results are inaccurate
	 * Hence don't follow this solution
	 */
	private static int findInversionEfficient(int[] given) {

		int[] sorted = new int[given.length];

		int inversionCount = findInversion(given, sorted, 0, given.length-1);
		System.out.println("Sorted Array is -> " + Arrays.toString(sorted));
		return inversionCount;
	}

	private static int findInversion(int[] given, int[] sorted, int start, int end) {

		int mid, inversionCount = 0;

		if(start < end) {

			mid = (start + end) /2;

			inversionCount = findInversion(given, sorted, start, mid);
			inversionCount += findInversion(given, sorted, mid+1, end);

			inversionCount += merge(given, sorted, start, mid+1, end);
		}

		return inversionCount;
	}

	private static int merge(int[] given, int[] sorted, int start, int mid, int end) {

		int inversionCount = 0;

		int i = start; // for the left array
		int j = mid; // for the right array
		int k = start; // for the sorted array

		while(i<=(mid-1) && j <=(end)) {

			if(given[i] <= given[j]) {

				sorted[k++] = given[i++];
			}
			else {
				sorted[k++] = given[j++];
				inversionCount = inversionCount + (mid-i);
			}
		}

		return inversionCount;
	}



}
