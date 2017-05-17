package chapter13.critical;

import java.util.*;

public class SinkStack {
	private ArrayList<Character> stack = new ArrayList<Character>(100);

	public char pop() {
		char data = 0;
//		try {
		while(stack.size() == 0){
			try{ wait(); } catch(InterruptedException e){}
		}
		data = stack.remove(stack.size() - 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return data;
	}

	public void push(char data) {
		notify();
		stack.add(data);
	}

	public synchronized String toString(){ return stack.toString(); }
}
