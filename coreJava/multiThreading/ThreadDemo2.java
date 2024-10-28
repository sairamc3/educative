class NewThread2 extends Thread {

	NewThread2(){

		super("My own Thread");
		System.out.println("Child thread created");
		start();
	}

	@Override
	public void run() {

		try{
			for(int i=5; i>0; i--) {
				System.out.println("Child thread " +i);
				Thread.sleep(500);
			}
		} catch(InterruptedException ex) {

			System.out.println("InterruptedException");
		}

		System.out.println("Child Thread has ended");
	
	}
}

public class ThreadDemo2 {

	public static void main(String[] args) {

		new NewThread2();

		try{
			for(int i=5; i>0; i--) {
				System.out.println("Main Thread " +i);
				Thread.sleep(1000);
			}
		} catch(InterruptedException ex) {

			System.out.println("InterruptedException in main thread");
		}
	}
}



