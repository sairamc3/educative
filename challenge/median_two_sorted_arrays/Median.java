import java.util.*;
import java.util.stream.*;

public class Median {

	public static void main (String[] args) {

		int[] a = {100};
		int[] b = {1, 5, 8, 10, 20};

		System.out.println("Given: ");

		System.out.println("A -> " + Arrays.stream(a)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(", ", "{", "}")));

		System.out.println("B -> " + Arrays.stream(b)
							.mapToObj(String::valueOf)
							.collect(Collectors.joining(", ", "{", "}")));

		double median = findMedian(a,b);

		System.out.println("Median -> " + median);
	}

	private static double findMedian(int[] a, int[] b) {
	
		double median = 0.0;
		int cLength = a.length + b.length;

		int[] c = new int[cLength];
	
		int a_index =0;
		int b_index =0;

		for(int i=0; i< c.length; i++) {

			if(a_index == a.length) {
				c[i]=b[b_index];
				b_index++;
				continue;
			} else if(b_index == b.length) {
				c[i]=a[a_index];
				a_index++;
				continue;
			}
				

			if(a[a_index] <= b[b_index]) {

				c[i] = a[a_index];
				a_index++;
			} else {

				c[i] = b[b_index];
				b_index++;
			}
		}

		if(cLength%2 == 0) {

			median = (c[(cLength/2)-1] + c[cLength/2])/2.0;
		} else {
			
			median = c[cLength/2];
		}
		return median;
	}
}


