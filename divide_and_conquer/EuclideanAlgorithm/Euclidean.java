import java.util.*;
import java.util.stream.*;

public class Euclidean {

	public static void main(String[] args) {

		int a = 15, b = 75;

		int gcd = findGCD(a,b);

		System.out.println("Given numbers: a -> " + a + ", b -> " + b);

		System.out.println("GCD of the given numbers : " +gcd);

		Random random = new Random();
		int x = random.nextInt(50);
		int y = a * random.nextInt(10) + random.nextInt(35);

		System.out.println("Random a ->" + x + ",b->" + y + ". GCD -> " + findGCD(x,y));

	}

	private static int findGCD(int a, int b) {

		if(a == 0) return b;
		else return findGCD(b%a, a);
	}
}
