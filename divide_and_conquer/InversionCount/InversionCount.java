import java.util.*;

public class InversionCount {

	public static void main(String[] args) {

		int[] given = {9,5,6,11,8,10};

		System.out.println("Given array -> " + Arrays.toString(given));

		int inversions = findInversions(given);

		System.out.println("The inversion required for sorted array are -> " + inversions);
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
}
