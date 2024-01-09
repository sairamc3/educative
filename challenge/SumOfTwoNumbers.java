import java.util.*;
import java.util.stream.*;

public class SumOfTwoNumbers {

	public static void main(String[] args) {

		System.out.println("Given Array: ");
		
		// Input data
		int[] given = {1,21,3,14,5,60,7,6};
		int sum = 81;

		String givenArrayAsString = Arrays.stream(given)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(", ", "{", "}"));

		System.out.println(givenArrayAsString);
		System.out.println("Sum we are looking for: "+sum);
		
		int[] numbersToSum = findTheNumbersToSum(given, sum);

		System.out.println("Numbers to get the sum in the array: ");

		System.out.println(Arrays.stream(numbersToSum)
						.mapToObj(String::valueOf)
						.collect(Collectors.joining(", ", "{", "}")));

	}

	private static int[] findTheNumbersToSum(int[] given, int sum) {
	
		int[] twoNumbers = new int[2];

		// Implement the logic here
		Map<Integer, Integer> alreadyChecked = new HashMap<>();

		for(int i=0; i<given.length; i++) {

			Integer diff = sum - given[i];
			
			if(alreadyChecked.containsKey(given[i])) {
				
				twoNumbers[0] = diff;
				twoNumbers[1] = given[i];
			
				return twoNumbers;
			} else {
				
				alreadyChecked.put(diff, i);
			}
			
		}		


		return twoNumbers;
	}
	
}
