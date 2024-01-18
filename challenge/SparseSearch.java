import java.util.*;
import java.util.stream.*;

/**
 * Do not know why.. the solution did not work
 * Understood the coneept behind.
 * For time being skipping it for now
 */
public class SparseSearch {

	public static void main(String[] args) {
	
		String[] given = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};

		String key = "educative";

		System.out.println("Given String -> " + Arrays.stream(given)
								.collect(Collectors.joining(", ", "{", "}")));

		System.out.println("Key: " + key);

		int index = sparseSearch(given, key, 0, given.length-1);

		System.out.println("String found at index " + index);
	}

	private static int sparseSearch(String[] given, String key, int low, int high) {


		int mid = (low+high)/2;

		if(low > high) return -1;

		/** 
		if(given[mid] == ""){
		
			int i = mid-1;
			int j= mid+1;
			
			while(true) {
		
				if(i<low && j>high) return -1;

				if(i>=low && given[i] != "") {
					mid=i;
					break;
				} else if(j<=high && given[j] != "") {
					mid=j;
					break;
				}
				i--;
				j++;
			}
		}
		*/
		

		if(given[mid].equals(key)){
			 return mid;
		}else if(given[mid].compareTo(key)>0){
			sparseSearch(given, key, low, mid-1);
			
		} else {
			sparseSearch(given, key, mid+1, high);
		}
		
		return -1;
 	}
}
		
		

