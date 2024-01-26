import java.util.*;
import java.util.stream.*;

public class KnapckSack {

	public static void main(String[] args) {

		System.out.println("SnapSack Problem");
		
		int[] profit = {60,100,120};
		int[] weight = {10,20,30};
		int capacity = 50;

		int max = knapsack(profit, profit.length, weight, weight.length, capacity);

		System.out.println("Max he can take -> "+ max);
 
	}

	private static int knapsack(int[] profits, int profitsLength,  int[] weights, int weightsLength, int capacity) {

		// Implementation
		

		return -1;
	}

}
