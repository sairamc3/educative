import java.util.*;
import java.util.stream.*;

public class FindMinPlatformReForTrainStation {

	public static void main (String[] args) {

		int[] arrival = {900, 940, 950, 1100, 1500, 1800};
		int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

		int bruteForce = bruteForce(arrival, departure) ;
		int sorting = sorting(arrival, departure);

		System.out.println("Arrival -> " + Arrays.stream(arrival)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(",","{","}"))
							);
		System.out.println("Departure -> " + Arrays.stream(departure)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(",","{","}")));

		System.out.println("BruteForce approach -> " + bruteForce);
		System.out.println("Sorting approach -> " + sorting);
	}

	/**
	 * BruteForce
	 * Time complexity: O(n^2)
	 */
	public static int bruteForce(int[] arrival, int[] departure) {

		// You can as well use departure.length, both should be the same
		int totalTrains = arrival.length;

		// Max no of trains in the station at a point of time
		int maxTrains = 0;

		// No of trains at a point of time
		// Will modified for each interation
		int count = 0;

		// Iterate through the trains 
		// Iterating through the timing of two trains
		for(int trainIndex =0; trainIndex < totalTrains; trainIndex++) {

			count = 0;

			// Since first train starts at index 0, skipping it for the next one
			for(int secondTrainIndex=1; secondTrainIndex< totalTrains ; secondTrainIndex++) {

				// Compring if two trains are in station
				// First train should come before the second train
				if(arrival[trainIndex] <= arrival[secondTrainIndex]
						// First train should leave the station after second train arrives
						// Only then for a brief period, both the trains are present in the station
						&& departure[trainIndex] >= arrival[secondTrainIndex]) {

					count ++;
				}
			}

			// if the no of trains in the station at this moment
			// is more then the previously found max trains
			if(maxTrains < count) maxTrains = count ;
		}

		// return maxTrains, present in the station at a point of time
		return maxTrains;
	}
	
	/**
	 * The idea is to consider all events in sorting order. 
	 * We can trace the no of events at any given time 
	 * and check the trains that have arrived but not departed.
	 * That way we know how many platforms we need at that time. 
	 * Take the max of all such instances.
	 * Time Complexit: O(nlogn)
	 */
	public static int sorting(int[] arrival, int[] departure) {

		// You can take any array for the size for the total trains
		int totalTrains = arrival.length;

		// Sort both the arrays
		Arrays.sort(arrival);
		Arrays.sort(departure);

		// Initialize count and max trains
		int maxTrains = 1;
		int count = 1;

		// first and second train
		int firstTrain=0;
		int secondTrain=1;

		// While the trains are less than the total trains
		while(secondTrain < totalTrains && firstTrain < totalTrains) {

			// If second train arrives before the first train leaves
			if(arrival[secondTrain] < departure[firstTrain]) {

				// Increment the counter
				count += 1;

				// Increment the second train count to compare the first train with another train
				secondTrain += 1;

				// If the count is more than the maxTrain then store the value in maxTrain
				if(count > maxTrains) maxTrains = count;
			} else {

				// Decrement the count
				count -= 1;

				// Increment the first train, since it has left while comparing with the second one
				firstTrain += 1;
			}
		} 

		// return the max trains
		return maxTrains;

	}
}
