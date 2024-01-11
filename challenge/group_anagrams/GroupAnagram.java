import java.util.*;
import java.util.stream.*;

public class GroupAnagram {

	public static void main(String[] args) {

		String[] given = { "cat", "dog", "tac", "god", "act",  "tom marvolo riddle ","abc", "def",  "cab", "fed", "clint eastwood ", "i am lord voldemort", "elvis", "old west action",  "lives" };
	
		String givenString = Arrays.stream(given).collect(Collectors.joining(",","{","}"));
		System.out.println(givenString);

		findAnagrams(given);

	}

	private static void findAnagrams(String[] given) {
	
		Map<String, List<String>> anagrams = new HashMap<>();

		for(String word: given) {
			
			char[] orderedArray = word.toCharArray();
			Arrays.sort(orderedArray);
			String newWord = new String(orderedArray);
			
			if(anagrams.containsKey(newWord)) {

				anagrams.get(newWord).add(word);
			} else {

				List<String> newList = new ArrayList<>();
				newList.add(word);
				anagrams.put(newWord, newList);
			}

		}
		
		System.out.println("The below are the anagrams:");

		for(String key: anagrams.keySet()) {
	
			if(anagrams.get(key).size() > 1) {

				String eachAnagram = anagrams.get(key).stream()
									.collect(Collectors.joining(",","{","}"));

				System.out.println(eachAnagram);
			}
		}
	}
					
			
}
