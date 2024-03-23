import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;

public class FractionalKnapsack {

	public static void main(String[] args) {

		double[] weights = {2, 1, 6, 0.5, 0.25, 7};
		double[] values = {50, 70, 100, 50, 30, 99};

		int capacity = 10;

		double maxValue = getMaxValue(weights, values, capacity);

		System.out.println("Weights: " + Arrays.stream(weights)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(",", "{", "}")));

		System.out.println("Values: " + Arrays.stream(values)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(",", "{", "}")));

		// We need only two decimal places to print
		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		System.out.println("Result: " + decimalFormat.format(maxValue));
	}

	/**
	 * It is optimum solution for the problem.
	 * Idea is to sort the values of value/weight ratio
	 * and arrange in descending order
	 * So that the item with max value will be on top
	 * Iterate through the items
	 * Check if the complete item can be included in the knapsack
	 * if it is add it
	 * if not divide capacity by the current items wight and 
	 * add the same fractional amount to the snapsak to 
	 * make it full
	 * Time Complexity: O(n * log(n))
	 */
	public static double getMaxValue(double[] weights, double[] values, double capacity) {


		// Initialize the result
		double totalValue = 0;

		int length = weights.length;

		// Create Item Array
		Item[] items = new Item[length];

		// Initialize the items array by creating the Item objecs
		// with the available info of weights and values
		for(int i=0; i<length; i++) {

			items[i] = new Item(weights[i], values[i]);
		}

		// Sort the items based on the calculated cost
		Arrays.sort(items, (item1, item2) -> item2.cost.compareTo(item1.cost));

		// Iterate through the items
		for(Item item:items) {

			// Check if the item can be completly added to the snapsack
			if(item.weight <= capacity) {

				// add the value of the added item to the totalValue
				totalValue+= item.value;

				// Reduce the capcity, since the added item reduces the empty space
				capacity-=item.weight;

			} else { // Here the item cannot be added completly

				// Find the fraction of the item that can be added 
				// to meet the available capacity
				double fraction = capacity/item.weight;

				// Add only fraction of item value
				totalValue+= (item.value * fraction);

				// This one would result in zero
				// making the snapsack completly full
				capacity-= (item.weight * fraction);

				// Since the snapsack is complety full
				// We cannot add any more items
				// Hence, stopping the flow
				break;
			}
		}

		return totalValue;
	}

	// Creating a object structure for ease
	static class Item {

		// Given values
		double weight, value;

		// Calculated Value
		Double cost;

		// Constructor
		public Item(double weight, double value) {

			this.weight = weight;
			this.value = value;

			this.cost = value/weight;
		}
	}
		
}

