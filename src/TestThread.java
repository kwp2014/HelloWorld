
public class TestThread implements Runnable {

	private static int num = 0;
	
	
	public void run(){
		for(;num<1000;num++){
			System.out.print(Thread.currentThread().toString());
			System.out.println(": " + num);
		}
	}
	
	public static void main(String[] args) {
		TestThread testThread = new TestThread();
		Thread test1 = new Thread(testThread);
		Thread test2 = new Thread(testThread);
		Thread test3 = new Thread(testThread);
		test1.start();
		test2.start();
		test3.start();

	}

}
