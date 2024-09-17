import java.util.*;
import java.util.stream.*;

public class CoinChange {

	public static void main(String[] args) {

		int[] denoms = {25, 10, 5, 1};
		int amount = 10;

		System.out.println("Given denoms -> " + Arrays.toString(denoms));

		System.out.println("Possible ways change can be provided is");

		System.out.println("Bruteforce -> " + bruteforce(denoms, amount));
		System.out.println("Memoization -> " + memoization(denoms, amount));
		System.out.println("Tabulation -> " + tabulation(denoms, amount));
	}

	private static int bruteforce(int[] denoms, int amount) {


		return recursiveBruteforce(denoms, denoms.length, amount);
	}

	private static int recursiveBruteforce(int[] denoms, int denomLength, int amount){

		// when the case met
		if(amount == 0 )  return 1;

		if(amount < 0 || denomLength <=0) return 0;

		if(denoms[denomLength-1] > amount) return 0;

		return recursiveBruteforce(denoms, denomLength-1, amount) 
			+ recursiveBruteforce(denoms, denomLength, amount - denoms[denomLength-1]);
	}

	private static int memoization(int[] denoms, int amount) {

		return 0;
	}

	private static int tabulation(int[] denoms, int amount) {

		return 0;
	}
}
