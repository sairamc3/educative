import java.util.*;
import java.util.stream.*;

public class Duplicates {

	public static void main(String[] args) {

		int[] given = {1, 3, 4, 3, 5, 4, 100, 100};
		System.out.println("Given: " ) ;

		System.out.println(Arrays.stream(given).mapToObj(String::valueOf).collect(Collectors.joining(", ","{","}")));



		List<Integer> duplicates = findDuplicates(given);

		System.out.println("Duplicates:");

		duplicates.forEach(System.out::println);
	}

	private static List<Integer> findDuplicates(int[] given) {

		Map<Integer, Integer> elements = new HashMap<>();
		
		List<Integer> duplicates = new ArrayList<>();		

		for(int i:given) {

			if(elements.containsKey(i)){
				
				elements.put(i, elements.get(i)+1);
			} else {
	
				elements.put(i, 1);
			}
		}
		
		for(Map.Entry entry: elements.entrySet()) {

			if((Integer)entry.getValue() > 1) {
			
				duplicates.add((Integer)entry.getKey());
			}
		}

		return duplicates;
	}
}

			
