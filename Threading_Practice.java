package JavaLearn;

public class Threading_Practice {
	public static void main(String[]args) {
		ThreadTest obj = new ThreadTest();
		//single threaded
		//System.out.println("Single threaded");
		//obj.printEvenNumbers();
		//obj.printOddNumbers();
		
		/**
		 * Anonymous inner class example
		 * https://www.geeksforgeeks.org/anonymous-inner-class-java/
		 */
		/*interfaceX x = new interfaceX() {
			@Override
			public void y() {
				// TODO Auto-generated method stub
				
			}
		};*/
		
		
		//multi threading
		System.out.println("Multi threading");
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				obj.printEvenNumbers();
			}
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				obj.printOddNumbers();
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Waiting for t1 and t2 to die");
					t1.join();
					System.out.println("t1 dead");
					t2.join();
					System.out.println("t2 dead");
					obj.printOperationComplete();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
	}
	
}

/**
 * Anonymous inner class example
 *
 */
interface interfaceX{
	void y();
}

class ThreadTest {
	public void printEvenNumbers() {
		for(int i = 2; i <= 50; i+=2) {
			/*if(i == 24) {
				System.out.println("Thead will wait");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
			if(i%4==0) {
				Thread.yield();
			}
			System.out.println("printEvenNumbers: "+i);
		}
	}
	
	public void printOddNumbers() {
		for(int i = 1; i <= 49; i+=2) {
			/*if(i == 35) {
				System.out.println("Thead will wait");
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			System.out.println("printOddNumbers: "+i);
		}
	}
	
	public void printOperationComplete() {
		System.out.println("Operation Complete");
	}
}

