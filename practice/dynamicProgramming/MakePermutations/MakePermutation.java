import java.util.*;

public class MakePermutation {

	public static void main(String[] args) {

		String given = "Sairam";

		Set<String> unique = new HashSet<>();

		findPermutations(given, 0, given.length(), unique);

		System.out.println("Given String is -> " +given);

		System.out.println(unique);
	}

	private static void findPermutations(String given, int start, int end, Set<String> unique) {

		System.out.println("findPermutations: given -> " + given + ", start -> " + start + ", end " + end );
		if(start == end-1){

			unique.add(given + " ");
		} else {
			for(int i=start; i<end; i++) {

				given = swap(given, start, i);
				findPermutations(given, start+1, end, unique);
				given = swap(given, start, i);
			}
		}
	}

	private static String swap(String given, int i, int j) {

		char[] c = given.toCharArray();

		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;

		return String.valueOf(c);
	}

}

