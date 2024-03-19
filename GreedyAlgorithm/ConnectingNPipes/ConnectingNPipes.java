import java.util.*;
import java.util.stream.*;

/**
 * Find the min cost to connect the pipes
 */
public class ConnectingNPipse {

	public static void main(String[] args) {

		int[] pipes = {4, 2, 3, 7};

		
		int minCost = calculateMinCost(pipes);

		System.out.println("sorted pipes" + Arrays.stream(pipes).mapToObj(String::valueOf).collect(Collectors.joining(",","{","}")));

		System.out.println("Min Cost: " + minCost);

	}

	/**
	 * Own implmentation
	 * Sorted the array first using Array library
	 * Starting with the first pipe, keep on adding the pipes, and keeping track of cost associated with it.
	 */
	public static int calculateMinCost(int[] pipes) {

		// Sort the array
		Arrays.sort(pipes);

		// Keeping track of the cost
		int cost = 0;

		// Starting with the first pipe after sorting
		int currentPipeLength = pipes[0];

		// Adding the remaining pipes to make a single pipe
		for(int i =1; i<pipes.length; i++) {

			// Keeping track of the pipe length for calculating the cost for the adding the pipes
			currentPipeLength += pipes[i];

			// adding the cost to the total cost 
			cost += currentPipeLength;

			// this if for debug.. to identify in each step.. what is happening
			System.out.println("Total Cost: " + cost + ", currentPipeLength: " + currentPipeLength);
		}

		// return the total cost
		return cost;
	}
}

