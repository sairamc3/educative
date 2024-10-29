import java.util.*;

/**
 * It's my own implementation
 */
public class MergeSortedArrays{

	public static void main(String[] args) {

		int[][] given = {{16,25,36}, {2,9,15}, {22,55,67}, {79,38,99}};

		int[] singleSorted = mergeArrays(given);

		System.out.println("Given Arrays are:");

		for(int i=0; i< given.length; i++) {

			System.out.println(Arrays.toString(given[i]));
		}

		System.out.println("The sorted single array is");

		System.out.println(Arrays.toString(singleSorted));
	}

	private static int[] mergeArrays(int[][] given) {

		int arraySize = given[0].length;
		int noOfArrays = given.length;

		int[] result = new int[arraySize * noOfArrays];

		// by default every element in the array will have
		// 0
		int[] indexes = new int[noOfArrays];

		
		for(int i=0; i<result.length; i++) {

			System.out.println("Finding the element for index -> " +i);

			int[] minFoundIndex = new int[2];
			int min = Integer.MAX_VALUE;

			System.out.println("Indexes array -> " + Arrays.toString(indexes));

			for(int a=0; a < indexes.length; a++) {

				if(indexes[a] == arraySize) continue;

				System.out.println("Finding the element from the array -> " + a);

				System.out.println("Comparing min -> " + min + " with " + given[a][indexes[a]]);
				
				if(min > given[a][indexes[a]] ) {
					min = given[a][indexes[a]];
					minFoundIndex[0] = a;
					minFoundIndex[1] = indexes[a]+1;
				}
			}

			System.out.println("The min found index is " + Arrays.toString(minFoundIndex));
			
			indexes[minFoundIndex[0]] = minFoundIndex[1];

			result[i] = min;
		}

		return result;
	}
}



