package chapter13.critical;

public class Consumer extends Thread {
	private SinkStack  stack;
	public Consumer(){}
	public Consumer(SinkStack stack, String name){
		super(name);
		this.stack = stack;
	}
	public void run(){
		for (int i = 0; i < 50; i++) {
			synchronized (stack) {
				System.out.println(getName()+":"+stack.pop());
			}
			try {
				sleep((int)(Math.random()*300));
			} catch (Exception e) {
			}
		}
		System.out.println(stack);
	}
}



