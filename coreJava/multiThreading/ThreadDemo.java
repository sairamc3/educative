class NewThread implements Runnable {

	Thread t;

	NewThread() {
		 t = new Thread(this, "Demo Thread");
		 System.out.println("Child Thread -> " + t);
		 t.start();
	}

	public void run() {

		try{
			for(int i=5; i>0; i--){
				System.out.println("Child Thread " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {

			System.out.println("The thread has been interrupted");
		}
		System.out.println("The Child thread has ended");
	}

}

public class ThreadDemo {

	public static void main(String[] args) {

		new NewThread();

		try {
			for(int i=5; i>0; i--) {

				System.out.println("Main Thread " + i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException ex) {

			System.out.println("InterruptedException in Main thread");
		}
	}
}

