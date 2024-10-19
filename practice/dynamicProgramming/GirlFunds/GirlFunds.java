import java.util.*;

public class GirlFunds {

	public static void main(String[] args) {

		int girlNeeds = 7;
		int housesSheCanVisit = 5;

		int ways = ways(girlNeeds, housesSheCanVisit);

		System.out.println("The girl needs " + girlNeeds + " Rupees and houses she can visit is " + housesSheCanVisit);
		System.out.println("No of ways ->" + ways);
		
		int memoizationWays = memoizationWays(girlNeeds, housesSheCanVisit);

		System.out.println("Memoization ways ->" + memoizationWays);


		System.out.println("The girl needs 5 Rupees and houses she can visit is " + housesSheCanVisit);
		int ways2 = ways(5, housesSheCanVisit);

		System.out.println("No of ways ->" + ways2);
		
		int memoizationWays2 = memoizationWays(5, housesSheCanVisit);

		System.out.println("Memoization ways ->" + memoizationWays2);

	}

	private static int ways(int input1, int input2) {

		int noOfWays = 0;
		int previousAmount =input1+1;

		return ways(input1, input2, noOfWays, previousAmount);
	}

	private static int ways(int amountRequired, int housesRemaining, int ways, int prevAmount) {

		if(amountRequired == 0) return ways+1;

		if(housesRemaining == 0 || amountRequired < 0) return ways;

		for(int money=0; money < prevAmount && money <= amountRequired; money++){

			ways= ways(amountRequired-money, housesRemaining-1, ways, money);
		}

		return ways;
	}

	private static int memoizationWays(int input1, int input2) {

		int previousAmount = input1+1;

		int[][] lookuptable = new int[input1+1][input2+1];

		for(int i = 0; i<= input1; i++)
			for(int j=0; j<= input2; j++)
				lookuptable[i][j] = -1;
		int ways = 0;

		return memoizationWays(input1, input2, previousAmount, ways, lookuptable);
	}

	private static int memoizationWays(int amountRequired, int housesRemaining, int prevAmount, int ways, int[][] lookuptable) {

		if(amountRequired == 0) return ways+1;
		if(housesRemaining == 0 || amountRequired < 0) return ways;

		for(int amount=0; amount< prevAmount && amount<= amountRequired; amount++) {

			if(lookuptable[amount][housesRemaining] == -1){

				ways = memoizationWays(amountRequired-amount, housesRemaining-1, amount, ways, lookuptable);
			}
		}

		lookuptable[amountRequired][housesRemaining] = ways;

		return lookuptable[amountRequired] [housesRemaining];
	}
}


