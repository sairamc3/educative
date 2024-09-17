import java.util.*;
import java.util.stream.*;

public class EggDroppingProblem {

	public static void main(String[] args) {

		int eggs = 2, floors = 10;

		System.out.println("Min no of tries in worst case is:");
		System.out.println("BruteForce -> " + bruteForce(eggs, floors));
		System.out.println("Memoization -> " + memoization(eggs, floors));
		System.out.println("Tabulation -> " + tabulation(eggs, floors));
	}

	public static int bruteForce(int eggs, int floors) {

		// base case 
		if(eggs == 0) return 0;

		if(floors == 0 || floors == 1) return floors;

		if(eggs == 1) return floors;
		
		int floor, result;
		
		int min = Integer.MAX_VALUE;

		for(floor = 1; floor <= floors; floor++) { 
			result = 1 + Math.max(bruteForce(eggs-1, floor-1), bruteForce(eggs, floors - floor));

			if(result < min) min = result;
		}

		return min;

	}
	public static int memoization(int eggs, int floors) {

		int[][] lookuptable = new int[eggs+1][floors+1];

		for(int egg=0; egg<= eggs; egg++) 
			for(int floor=0; floor<=floors; floor++)
				lookuptable[egg][floor] = 0;

		return recursiveMemoization(lookuptable, eggs, floors);
	}

	private static int recursiveMemoization(int[][] lookuptable, int eggs, int floors) {

		if(eggs == 0) return 0;

		if(floors ==0 || floors == 1) return floors;

		if(eggs == 1) return floors;

		int result;
		int min = Integer.MAX_VALUE;

		if(lookuptable[eggs][floors] == 0) {
			for(int floor = 1; floor <= floors; floor++) {

				result = 1 + Math.max(recursiveMemoization(lookuptable, eggs-1, floor-1), 
						recursiveMemoization(lookuptable, eggs, floors - floor));
				if(result < min) min = result;

				lookuptable[eggs][floors] = min;
			}
		}

		return lookuptable[eggs][floors];
	}


	public static int tabulation(int eggs, int floors) {


		if(eggs == 0) return 0;
		
		if(floors == 0 || floors == 1) return floors;

		if(eggs == 1) return floors;

		int[][] lookuptable = new int[eggs+1][floors+1];

		int result;

		int egg,floor,x;

		for(egg=1; egg <= eggs; egg++){
			lookuptable[egg][0] = 0;
			lookuptable[egg][1] = 1;
		}
		for(floor=1; floor<=floors; floor++) {
			lookuptable[1][floor] = floor;
		}

		for(egg=2; egg<=eggs; egg++) {
			for(floor=2; floor<=floors; floor++) {

				lookuptable[egg][floor] = Integer.MAX_VALUE;

				for(x = 1; x <= floor; x++) {

					result = 1 + Math.max(lookuptable[egg-1][x-1], lookuptable[egg][floor - x]);

					if(result < lookuptable[egg][floor]) lookuptable[egg][floor] = result;
				}
			}
		}

		return lookuptable[eggs][floors];
	}
}



	


