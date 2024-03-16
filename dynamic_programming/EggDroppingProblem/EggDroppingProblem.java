import java.util.*;
import java.util.stream.*;

public class EggDroppingProblem {

	public static void main(String[] args) {

		int floors = 10;
		int eggs = 2;

		int bruteForce = bruteForce(floors, eggs);
		int memoization = memoization(floors, eggs);
		int tabulation = tabulation(floors, eggs);

		System.out.println("Given floors -> " +floors + ", eggs -> " +eggs);

		System.out.println("Floors from which eggs can be dropped with out breaking. The minimum no of trials in worst case is as below:");

		System.out.println("bruteForce -> " +bruteForce);
		System.out.println("memoization -> " +memoization);
		System.out.println("tabulation -> " + tabulation);

	}

	/** 
	* If the eggs drops from floor 'x', then there are two possibliites
	* 	1. Egg Breakes
	* 	2. Egg does not break
	* Case 1: Egg breaks
	* 	We only need to check the floors below x, to find the floor where the egg would not break
	*	So the problem becomes (floor-1) and eggs (egg -1), since we have already used one. 
	* Case 2: Egg does not break
	* 	We need to check the floor higher than x, to find a floor where the egg breaks
	* 	So the problm reduces to (topfloor - floor) and egg, since the egg did not break we can still use it.
	* Since we need to minimize the number of trials in worst case, we take max from both the cases. 
	*/
	public static int bruteForce(int floors, int eggs) {

		// If there are no eggs, then there can't be any trials
		if(eggs == 0) return 0;

		//If there are no floors, no trials needed
		//If there is one floor, only one trial is needed
		if(floors == 0 || floors ==1) return floors;

		// We need k trials from one egg and K floors
		if(eggs ==1) return floors;

		int min = Integer.MAX_VALUE;

		for(int floor=1; floor<=floors; floor++) {

			int res = Math.max(bruteForce(floor-1, eggs-1), bruteForce(floors-floor, eggs));

			if(res < min) min = res;
		}

		return min + 1;
	}

	public static int memoization(int floors, int eggs) {

		int[][] lookupTable = new int[eggs+1][floors+1];

		for(int i=0; i<=eggs; i++) {

			for(int j=0; j<=floors; j++) {
				lookupTable[i][j] = 0;
			}
		}

		return memoization(lookupTable, floors, eggs);
		
	}
	
	private static int memoization(int[][] lookupTable, int floors, int eggs) {

		if(eggs <=0) return 0;
	
		if(floors ==0 || floors ==1) return floors;

		if(eggs == 1) return floors;

		lookupTable[eggs][floors] = Integer.MAX_VALUE;

		for(int floor=1; floor <=floors; floor++) {

			int res = 1+ Math.max(memoization(lookupTable, floor-1, eggs-1), memoization(lookupTable, floors-floor, eggs));
			if (res < lookupTable[eggs][floors]) lookupTable[eggs][floors] = res;

		}
		return lookupTable[eggs][floors];
	}	

	public static int tabulation(int floors, int eggs) {

		if(eggs <=0) return 0;
		
		if(floors ==0 || floors ==1) return floors;

		if(eggs ==1) return floors;

		int[][] lookupTable = new int[eggs+1][floors+1];

		//We always need one trial for one floor and zero trail for zero floors
		for(int egg=1; egg<=eggs; egg++) {

			lookupTable[egg][0] = 0;
			lookupTable[egg][1] = 1;
		}

		//We always need trials equal to no of floors when the eggs are one
		for(int floor=1; floor<=floors; floor++) {

			lookupTable[1][floor] = floor;
		}

		for(int egg=2; egg<=eggs; egg++) {

			for(int floor=2; floor<=floors; floor++) {

				lookupTable[egg][floor] = Integer.MAX_VALUE;
				
				for(int fl=1; fl<=floor; fl++) {

				
					int res = 1 + Math.max(tabulation(fl-1, egg-1),
							tabulation(floors-fl, egg));
					if(res < lookupTable[egg][floor]) lookupTable[egg][floor] = res;
				}
			}
		}


		return lookupTable[eggs][floors];
	}
}
