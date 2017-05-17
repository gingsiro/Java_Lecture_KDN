package chapter13;

public class MyRunnable implements Runnable {
	int i;
	
	/** Thread에 의해 병행 처리 될 코드 */
	@Override
	public void run() {
		for (i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}

}
