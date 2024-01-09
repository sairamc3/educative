import java.util.*;
import java.util.stream.*;

public class LinearSearch {

	public static void main(String[] args) {
	
		int[] given = {3,5,21,32,41,100,-21,11,1,3};

		int search = 21;

		int index = linearSearch(given, search);
		
		if(index >=0) {

			System.out.println("Item found at the index " + index);
		}else {
			System.out.println("Item not found in the array " );
		}

	}

	private static int linearSearch(int[] given, int search){
	
		for(int i=0;i<given.length;i++) {

			if(given[i] == search) {
				return i;
			}
		}
		return -1;
	}
}	
