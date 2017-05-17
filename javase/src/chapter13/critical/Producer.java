package chapter13.critical;

public class Producer extends Thread {
	private SinkStack  stack;
	public Producer(){}
	public Producer(SinkStack stack, String name){
		super(name);
		this.stack = stack;
	}
	public void run(){
		for (int i = 0; i < 50; i++) {
			char data = (char)(Math.random()*26 +'A');
			synchronized (stack) {
				System.out.println(getName()+":"+data);
				stack.push(data);				
			}
			try {
				sleep((int)(Math.random()*300));
			} catch (Exception e) {
			}
		}
	}
}



