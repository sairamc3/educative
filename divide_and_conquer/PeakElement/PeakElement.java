import java.util.*;
import java.util.stream.*;

public class PeakElement {

	public static void main(String[] args) {

		int[] given = {13,27,54,31,99,11};

		int peakElementIndex = findAPeakElement(given);

		System.out.println("Given array: " + Arrays.stream(given)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(",","{","}")));
		
		System.out.println("Peak element: " + peakElementIndex);
	}

	/** 
	 * Own implementation
	 */
	private static int findAPeakElement(int[] given) {

		for(int i=0; i<given.length; i++ ) {

			int index, preIndex, postIndex;
			index = i;

			if(i == 0 ) {
		
				postIndex = index +1;

				if(given[index] > given[postIndex]) return index;
			
			}else if(i == (given.length -1)){
				preIndex = index -1;

				if(given[index] > given[preIndex]) return index;

			}else {

				preIndex = index -1;
				postIndex = index +1;

				if(given[index] > given[preIndex] && given[index] > given[postIndex]) return index;
			}
		}
			
		return -1;
	}
}

