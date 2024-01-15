import java.util.*;
import java.util.stream.*;

public class ElementOccurence {

	public static void main (String [] args) {

		int[] given = {};
		int searchElement = 3;

		System.out.println("Given Array: ");

		System.out.println(Arrays.stream(given).mapToObj(String::valueOf).collect(Collectors.joining(", ","{","}")));

		int occurences = findOccurences(given, searchElement);
	}

	private static int findOccurences(int[] given, int searchElement){

		return 0;
	}
}
