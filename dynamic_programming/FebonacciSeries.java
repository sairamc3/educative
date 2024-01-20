
/**
* Febinocci number is the sum of the previous two numbers in the series. 
* It starts with first two numbers as 0 and 1, from then on we keep on adding the last two numbers to find the next number. 
* To find the n'th Febinocci number, we should sum the previous 2 numbers in the febinocci series
*/
public class FebnocciSeries {

	public static void main (String[] args) {

		int key = 8;
		System.out.println("Finding the " + key + "th Febinocci Number");

		// Regular approach 
		int regularResult = findFebinocci(key);
		int memoizeApproach = memoizeApproach(key);
		int tabulationApproach = tabulationApproach(key);

		System.out.println("Regular approach -> " + regularResult);
		System.out.println("Memoize approach -> " + memoizeApproach);
		System.out.println("Tabulation approach -> " + tabulationApproach);
	}
	
	/**
	* This is the most common way to find the n'th febinocci number
	* After lot of caluculations, the complexity of the logic is O(2^n) - Exponential time which is not good
	* There are redundant calculations in this approch, same febinocci number is calculated multiple times 
	*/
	private static int findFebinocci(int key) {

		if(key <=1 ) return key;
			
		return findFebinocci(key-1) + findFebinocci(key-2);
	}

	/**
	* <h1> Dynamic Programming </h1> 
	* <h2> Memoize approach </h2>
	* This is the approach in which you store the febinocci number you found in the array making the febinocci series.
	* If you again have to do the same calculation, you check the array, if we have already done it and if we did then use the info 
	* stored in the array, rather than doing the caluculation again
	* The complexity in this approach is O(n), which is a good improvement
	*/
	public static int memoizeApproach(int key) {

		int[] lookupTable = new int[key+1];
		
		for(int i=0; i< lookupTable.length; i++) {

			//Initialize each element in the array
			lookupTable[i] = -1;
		}

		return findFebinocci(key, lookupTable);
	}

	private static int findFebinocci(int key, int[] lookupTable) {
		
		// Check the array if it has the febinocci value
		if(lookupTable[key] == -1) {

			// since it does not have the value, calculate the store in the array

			if(key <= 1) lookupTable[key]=key;
			else lookupTable[key] = findFebinocci(key-1, lookupTable) + findFebinocci(key-2, lookupTable);
		}
		
		// return the value from the array
		return lookupTable[key];
	}


	/**
	* Dynamic Programming - Tabulation approach
	* In this approach we are not storing the previous information. We are storing last and secondLast feb number, since those are only 
	* required for calculating the required febinocci number.
	* The complexity stays the same O(n)
	* Here the memory utiliztion is better
	*/
	public static int tabulationApproach(int key) {

		if(key <= 1) return key;

		int last = 1;
		int secondLast = 0;
		int current=1;

		for(int i=2; i<= key; i++) {

			current = last+secondLast;
			secondLast = last;
			last = current;
		} 
		
		return current;

	}	
	
	


}

