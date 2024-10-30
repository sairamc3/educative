import java.util.*;

public class FloorAndCeiling {

	public static void main(String[] args) {

		int[] given = {1,2,3,5,7, 13, 17, 24, 32, 63, 72, 100};

		int[] elements = { -1, 1, 3, 12, 62, 100, 101};

		for(int x: elements) {

			System.out.println("Given array -> " +Arrays.toString(given));
			System.out.println("Find the Floor and ceiling for " + x);

			int[] result = findFloorAndCeiling(given, x);

			System.out.println("Floor ->" + result[0]);
			System.out.println("Ceiling ->" + result[1]);
			System.out.println("-----------------------");
		}
	}

	private static int[] findFloorAndCeiling(int[] given, int x) {

		int[] result = new int[2];
		result[0] = -1;
		result[1] = -1;

		if(given[0] > x) {
			result[0] = -1;
			result[1] = given[0];

			return result;
		}

		if(given[given.length-1] < x) {
			result[0] = given[given.length-1];
			result[1] = -1;

			return result;
		}

		find(given, x, 0, given.length-1, result);

		return result;
	}

	private static void find(int[] given, int x, int start, int end, int[] result) {

		int mid = (start+end)/2;

		if(given[mid] == x) {
			for(int i=mid-1; i>=0; i--) {
				if(given[i] < x) {
					result[0] = given[i];
					break;
				} else {
					result[0] = -1;
				}
			}
			for(int i=mid+1; i< given.length; i++) {
				if(given[i] > x) {
					result[1] = given[i];
					break;
				} else {
					result[1] = -1;
				}
			}
			return ;
		}

		if(mid !=0 && given[mid] > x && given[mid-1] < x) {
			result[0] = given[mid-1];
			result[1] = given[mid];

			return;
		}

		if(mid != (given.length -1) && given[mid] < x && given[mid+1] >x) {
			result[0] = given[mid];
			result[1] = given[mid+1];

			return;
		}

		if(given[mid] > x) find(given, x, 0, mid, result);
		else find(given, x, mid+1, given.length-1, result);
	}			

}

