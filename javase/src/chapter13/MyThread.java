package chapter13;

public class MyThread extends Thread {
	int i;
	public void run(){
		for (i = 1; i <= 100; i++) {
			//Thread.currentThread() : 현 코드를 동작시켜주는 Thread를 추출
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
	}
}
