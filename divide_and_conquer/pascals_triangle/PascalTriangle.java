import java.util.*;
import java.util.stream.*;

public class PascalTriangle {

	public static void main(String[] args) {

		int n = 5;

		pascalsTriangleRecursive(n);
	}

	public static int[] pascalsTriangleRecursive(int lineNumber) {

		int currentLineSize = lineNumber;
		int previousLineSize = lineNumber-1;

		int[] currentLine = new int[currentLineSize];

		if(lineNumber == 1) {

			currentLine[0] = 1;
			System.out.println(1);

			return currentLine;
		} else {

			// We will calculate the current line based on the previous line
			int[] previousLine = pascalsTriangleRecursive(lineNumber - 1);

			// Let's go through all the elements in the current line 
			// except the first and last element ( which are obviously 1's)
			// and calculate the current coefficient based on the previous line
			for(int numIndex = 0; numIndex < currentLineSize; numIndex++) {

				// if the index is not zero, i.e., if the it is not the first element
				// left is equal to previous line left side element
				int left = (numIndex - 1) >=0 ? previousLine[numIndex - 1] : 0;

				// If the elment is not the last element, i.e., the last element index 
				// would be the same as the size of the previous line.
				// So less than that would be previous to the last element
				int right = numIndex < previousLineSize ? previousLine[numIndex]: 0;

				// Sum both left and right
				currentLine[numIndex] = left + right;

				// Print the current element in the row
				System.out.print(left + right + " ");

			}

			// New line to differentiate the next row
			System.out.println();

			return currentLine;
		}
	}
}



