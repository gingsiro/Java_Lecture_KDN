package chapter13.critical;

public class SinkTest {
	public static void main(String[] args) {
		SinkStack  stack = new SinkStack();
		
		Consumer  c1 = new Consumer(stack, "c1");
		Consumer  c2 = new Consumer(stack, "c1");
		
		Producer  p1 = new Producer(stack, "p1");
		Producer  p2 = new Producer(stack, "p2");
		
		c1.start();
		c2.start();
		p1.start();
		p2.start();
		
	}
}
