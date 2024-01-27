import java.util.*;
import java.util.stream.*;

public class Partition {

	public static void main (String[] args) {

		int[] array1 = {1,2,3,4};
		int[] array2 = {1,1,3,4,7};
		int[] array3 = {2,3,4,6};

		System.out.println(Arrays.toString(array1) + "\t--->\t" + canPartition(array1));
		System.out.println(Arrays.toString(array2) + "\t--->\t" + canPartition(array2));
		System.out.println(Arrays.toString(array3) + "\t--->\t" + canPartition(array3));

		System.out.println("-------------------------------------------------------");

		System.out.println(Arrays.toString(array1) + "\t--->\t" + canPartitionMem(array1));
		System.out.println(Arrays.toString(array2) + "\t--->\t" + canPartitionMem(array2));
		System.out.println(Arrays.toString(array3) + "\t--->\t" + canPartitionMem(array3));
	}

	/**
	* This is brute force approach
	* The complexity is O(2^n)
	*/
	public static boolean canPartition(int[] given) {
	
		int givenLength = given.length;
		
		Integer sum = Arrays.stream(given).sum();
		
		if(sum % 2 !=0) return false;
		
		return canRecursivePartition(given, sum/2, 0);
	}

	private static boolean canRecursivePartition(int[] given, int sum, int index) {

		int length = given.length;
		
		if(sum == 0 ) return true;
		if(length == 0 || index >= length) return false;
	
		if(given[index] <= sum &&  
			canRecursivePartition(given, sum-given[index], index+1))
				return true;

		return canRecursivePartition(given, sum, index+1);
	}

	/**
	* This is memoization approach, where you store the information that you have already calculated and store it in a array
	* and then use that information for the next cycles so that we can stop repeated calculations
	*/
	public static int canPartitionMem(int[] given) {

		int givenLength = given.length;

		Integer sum = Arrays.stream(given).sum();

		if(sum % 2 !=0) return 0;

		int[][] lookupTable = new int[givenLength][];

		for(int i=0; i< givenLength; i++) {

			lookupTable[i] = new int[sum/2+1];

			for(int j=0; j<sum/2+1; j++) {

				lookupTable[i][j] = -1;
			}
		}

		return canPartitionRecursive(lookupTable, given, sum/2, 0);
	}

	private static int canPartitionRecursive(int[][] lookupTable, int[] given, int sum, int index) {

		int length = given.length;

		if(sum == 0 ) return 1;
		if(length == 0 || index >= length) return 0;

		if(lookupTable[index][sum] == -1 ) {

			if(given[index] <= sum) { 

				if( canPartitionRecursive(lookupTable, given, sum-given[index], index+1) == 1) {
			
					lookupTable[index][sum] = 1;
					
					return 1;
				}
			}
			lookupTable[index][sum] = canPartitionRecursive(lookupTable, given, sum, index+1);
		
		}
		return lookupTable[index][sum];
	}
}

		
