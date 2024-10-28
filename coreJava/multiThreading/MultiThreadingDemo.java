class NewThread3 implements Runnable {

	String threadName;
	Thread t;

	NewThread3(String threadName) {
		this.threadName = threadName;
		 t = new Thread(this, threadName);
		 System.out.println("Child Thread -> " + t);
		 t.start();
	}

	public void run() {

		try{
			for(int i=5; i>0; i--){
				System.out.println(threadName + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {

			System.out.println("The thread has been interrupted");
		}
		System.out.println("The Child thread has ended");
	}

}

public class MultiThreadingDemo {

	public static void main(String[] args) {

		new NewThread3("One Thread");
		new NewThread3("Two Thread");
		new NewThread3("Three Thread");

		try {
			for(int i=5; i>0; i--) {

				System.out.println("Main Thread " + i);
				Thread.sleep(2000);
			}
		} catch(InterruptedException ex) {

			System.out.println("InterruptedException in Main thread");
		}
	}
}

