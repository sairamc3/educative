import java.util.concurrent.*;

class CallableDemo {

	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(3);

		Future<Integer> f1 ;
		Future<Double> f2;
		Future<Integer> f3;

		System.out.println("Starting");

		f1 = es.submit(new Sum(10));
		f2 = es.submit(new HyPot(3,4));
		f3 = es.submit(new Factorial(5));

		try{

			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
		} catch(InterruptedException ex) {

			System.out.println(ex);
		} catch(ExecutionException ex) {

			System.out.println(ex);
		}
		es.shutdown();
		System.out.println("Done");
	}
}

class Sum implements Callable<Integer> {

	int stop;

	Sum(int v) {
		stop = v;
	}

	public Integer call() {

		int sum =0;
		
		for(int i=1; i<=stop; i++) {

			sum +=i;
		}

		return sum;
	}
}

class HyPot implements Callable<Double> {

	double side1, side2;

	HyPot(double side1, double side2) {

		this.side1 = side1;
		this.side2 = side2;
	}


	public Double call() {

		return Math.sqrt((side1 * side1) + (side2 * side2));
	}
}

class Factorial implements Callable<Integer> {

	int stop;

	Factorial(int v) { stop = v; }

	public Integer call() {

		int fact = 1;

		for(int i=2; i<=stop; i++) {

			fact *= i;
		}
		return fact;
	}
}

