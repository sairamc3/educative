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

		int optimizedTabulation = optimizedTabulation(denoms, denoms.length, amount);

		System.out.println("bruteForce -> " + bruteForce);
		System.out.println("memoizatin -> " + memoization);
		System.out.println("tabulation -> " + tabulation);
		System.out.println("OptimizedTabulation -> " + optimizedTabulation);
		
	}

	public static int bruteForce(int[] denoms, int denomLength, int amount){


		if(amount==0) return 1;
		if(denomLength <=0 || amount<0) return 0;
		if(denomLength <=0 && amount>0) return 0;

		
		return bruteForce(denoms, denomLength-1, amount) + bruteForce(denoms, denomLength, amount-denoms[denomLength-1]);
	}

	public static int memoization(int[] denmos, int denomLength, int amount) {

		int[][] lookupTable = new int[denomLength][amount+1];

		for(int i=0; i< denomLength ; i++) 
			for(int j=0; j<amount+1; j++)
				lookupTable[i][j] = 0;

		return memoization(lookupTable, denmos, denomLength, amount) ;
	}

	private static int memoization(int[][] lookupTable, int[] denoms, int denomLength, int amount){

		// This is where the Change matches with the exact amount
		if(amount==0) return 1;
		if(denomLength <=0 || amount <0) return 0;
		if(lookupTable[denomLength-1][amount] != 0) return lookupTable[denomLength-1][amount];
		
		lookupTable[denomLength-1][amount] = memoization(lookupTable, denoms, denomLength-1, amount) + memoization(lookupTable, denoms, denomLength, amount - denoms[denomLength-1]);
		
		return lookupTable[denomLength-1][amount];
	}

	public static int tabulation(int[] denoms, int denomLength, int amount) {

		int x,y;		

		// Edge Case
		if(amount <=0 || denomLength <=0) return 0;
		
		// Lookup Table
		int[][] lookupTable = new int[amount+1][denomLength];

		// initialize the first row
		for(int i=0; i<denomLength; i++) lookupTable[0][i]=1;

		// Fill the remaining entries 
		// bottom up manner
		for(int i=1; i<amount+1; i++) {
			for(int j=0; j<denomLength; j++) {
				
				x=(i-denoms[j] >=0)? lookupTable[i-denoms[j]][j]:0;
				y=(j>=1)? lookupTable[i][j-1]:0;
				lookupTable[i][j]=x+y;
			}
		}

		return lookupTable[amount][denomLength-1];
	}

	public static int optimizedTabulation(int[] denoms, int denomLength, int amount) {

		if(amount <= 0 || denomLength <= 0) return 0;

		int[] lookupTable = new int[amount+1];

		for(int eachElement: lookupTable) eachElement=0;

		lookupTable[0] =1;

		System.out.println(Arrays.stream(lookupTable).mapToObj(String::valueOf).collect(Collectors.joining(",","{","}")));

		for(int i=0; i<denomLength; i++) {
		
			System.out.println("i ->" +i);
			for(int j=denoms[i]; j<=amount; j++) {

				System.out.println("\t j ->" +j);
				lookupTable[j] += lookupTable[j-denoms[i]];

				System.out.println(Arrays.stream(lookupTable).mapToObj(String::valueOf).collect(Collectors.joining(",","{","}")));
			}
		}
		return lookupTable[amount];
	}
}

