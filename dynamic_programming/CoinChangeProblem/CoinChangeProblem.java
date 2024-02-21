import java.util.*;
import java.util.stream.*;

public class CoinChangeProblem {

	public static void main(String[] args) {

		int amount = 10;

		int[] denoms = {25,10,5,1};

		System.out.println("Given amount -> "+ amount);

		String givenArray = Arrays.stream(denoms).mapToObj(String::valueOf).collect(Collectors.joining(",","{","}"));
		System.out.println("Given array ->" + givenArray);


		int bruteForce = bruteForce(denoms, denoms.length, amount);

		int memoization = memoization(denoms, denoms.length, amount);

		int tabulation = tabulation(denoms, denoms.length, amount);

		System.out.println("bruteForce -> " + bruteForce);
		System.out.println("memoizatin -> " + memoization);
		System.out.println("tabulation -> " + tabulation);
		
	}

	public static int bruteForce(int[] denoms, int denomLength, int amount){


		if(amount==0) return 1;
		if(denomLength <=0 || amount<0) return 0;
		if(denomLength <=0 && amount>0) return 0;

		
		return bruteForce(denoms, denomLength-1, amount) + bruteForce(denoms, denomLength, amount-denoms[denomLength-1]);
	}

	public static int memoization(int[] denmos, int denomLength, int amount) {

		return 0;
	}

	public static int tabulation(int[] denoms, int denomLength, int amount) {

		return 0;
	}
}

