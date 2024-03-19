import java.util.*;
import java.util.stream.*;

/**
 * This is not the optimum solution, This example is to show the approach of greedy algorithm. 
 * The optimum solution for this problem can be obtained using dynamic programming
 */
public class ChangeMachine {

	public static int[] coins = {25, 10, 5, 1};

	public static void main(String[] args) {

		int givenAmount = 50;

		List<Integer> change = getMinCoins(givenAmount);

		System.out.println("Given amount: " +givenAmount);

		System.out.println("Change is : " + change);

		List<Integer> educativeSolution = getMinCoinsEducative(givenAmount);

		System.out.println("Educative solution change is : " + educativeSolution);
	}

	/**
	 * Method implmented without looking at the solution.
	 * Still need to find the optimum solution
	 */
	public static List<Integer> getMinCoins(int givenAmount) {

		List<Integer> change = new ArrayList<>();

		// My idea to implement
		// Start from bigger coin, incriment the coins until it is greater than or equal to given amount
		// if it is equal then we can return the no of coins until there. 
		// If it is greater than then reduce the coin and try with lesser coin.
		
		int sum = 0;
		
		// Iterate through the coin denominations
		for(int i=0; i<coins.length; i++) {

			// Add multiple coins until denomination is less than the difference
			while(sum < givenAmount && coins[i] <= givenAmount-sum) {

				// Add the denomination to the sum 
				sum+=coins[i];
				change.add(coins[i]);
			}

			// If the change is met then stop the process and return the result
			if(sum == givenAmount) return change;
		}

			
		return change;
	}

	/**
	 * Educative solution.
	 * In this solution, instead of using a new varible sum, used the givenAmount, and reduced the amount for every coin
	 * Every other logic is same here
	 */
	public static List<Integer> getMinCoinsEducative(int givenAmount) {

		List<Integer> change = new ArrayList<>();

		for(int i=0; i<coins.length && givenAmount>0; i++) {

			while(coins[i] <= givenAmount) {
			
				givenAmount-=coins[i];
				change.add(coins[i]);
			}
		} 

		return change;
	}
}

