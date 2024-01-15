import java.util.*;
import java.util.stream.*;

public class SearchMatrix {

	public static void main (String[] args) {

		int[][] given = {{10, 11, 12, 13},
				 {14, 15, 16, 17},
				 {27, 29, 30, 31},
				 {32, 33, 39, 80}};

		int target = 10;

		System.out.println("Given Matrix: { ");

		for(int[] row: given){
		
			System.out.println(Arrays.stream(row)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(", ", "{", "}")));
		}

		System.out.println("}");

		System.out.println("Target to be found: " + target);

		boolean found= searchMatrix(given, 4, 4, target);

		System.out.println("Is the target found in the matrix ? " + found);

	}

	private static boolean searchMatrix(int[][] matrix, int rowSize, int columnSize, int target) {

		int[] searchArray= null;
		
		for(int row=1; row < rowSize; row++) {
			
			if(matrix[row][0] > target) {

				searchArray = matrix[row-1];
			 
				return  Arrays.stream(searchArray).filter(x -> x==target).findAny().isPresent();
				
			}		
		}
		
		

		return Arrays.stream(matrix[rowSize-1]).filter(x -> x==target).findAny().isPresent();

	}

}

		
