package chapter13;

public class ThreadTest2 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		Thread t3 = new Thread(new MyRunnable());
		
//		MyRunnable job = new MyRunnable();
//		Thread t1 = new Thread(job);
//		Thread t2 = new Thread(job);
//		Thread t3 = new Thread(job);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main end___");
	}
}
