public class CurrentThreadDemo {

	public static void main(String[] args) {

		Thread t = Thread.currentThread();

		System.out.println("Current Thread: " + t);

		t.setName("My Own Thread");

		System.out.println("After name change: " +t);

	}
}
