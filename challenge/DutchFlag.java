import java.util.*;
import java.util.stream.*;

public class DutchFlag {

	public static void main(String[] args) {

		int[] given = {2, 0, 0, 1, 2, 1, 0};
		
		System.out.println("Given -> " + Arrays.stream(given)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(", ", "{", "}")));

		int[] sorted = sortDutchFlagArray(given);

		System.out.println("After Sorting -> " + Arrays.stream(sorted)
								.mapToObj(String::valueOf)
								.collect(Collectors.joining(", ", "{", "}")));

	}

	private static int[] sortDutchFlagArray(int[] given) {

		Map<Integer, Integer> count = new HashMap<>();
		int[] sorted = new int[given.length];
		
		for(int element:given) {

			if(count.containsKey(element)) {

				int temp = count.get(element);
				count.put(element, temp+1);
			} else {

				count.put(element, 1);
			}
		}

		int index=0;
		
		while(index < count.get(0)) {
			sorted[index] = 0;
			index++;
		}

		while(index < sorted.length - count.get(2)) {
			sorted[index] = 1;
			index++;
		}

		while(index < sorted.length) {
			sorted[index] = 2;
			index++;
		}

		return sorted;
	}
}
