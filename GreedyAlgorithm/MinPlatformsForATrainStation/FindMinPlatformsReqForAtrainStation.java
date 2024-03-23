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

	public static int sorting(int[] arrival, int[] departure) {

		return 0;

	}
}
