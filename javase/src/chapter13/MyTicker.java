package chapter13;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTicker extends Thread {
	private String msg = "Hello~~~~~Java_!";
	private Label msgL;

	private Button start, stop, suspend, resume, state, exit;

	public void run() {
		while (true) {
			msg = msg.substring(1) + msg.charAt(0);
			msgL.setText(msg);
			try {Thread.sleep(100);} catch (InterruptedException e) {}
		}
	}
	
	public MyTicker(){
		Frame frame = new Frame("Thread 예제");
		
		start = new Button("start");
		stop = new Button("stop");
		suspend = new Button("suspend");
		resume = new Button("resume");
		state = new Button("state");
		exit = new Button("exit");
		
		msgL = new Label(msg, Label.CENTER);
		
		frame.add(msgL, "Center");
		Panel pan = new Panel();
		pan.add(start);		pan.add(stop);		pan.add(suspend);
		pan.add(resume);	pan.add(state);		pan.add(exit);
		
		ActionListener handler = new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o == start) { //start 버튼이 클릭된 경우
					start();	//Thread start
					
				// suspend, resume, stop 은 문제를 일으킬 소지가 있는 코드
				// 권고사항으로 쓰지 않게 되어있음
				// LockFlag 반납 과정에서 DeadLock 에 빠짐
					// 싱크로 나이즈드 상황
					// 멀티 쓰레드에서 데이터를 공유하는 상황
					// 객체에만 사용 가능
				}else if(o == suspend){ //suspend 버튼이 클릭된 경우
					suspend();		//Thread suspend
					// 싱크로 나이즈 상황 : wait()으로 대체해서 써라
				}else if(o == resume){ //resume 버튼이 클릭된 경우
					resume();		//Thread resume
					// 싱크로 나이즈 상황 : notify(), notifyAll()로 대체해서 써라
				}else if(o == stop){ //stop 버튼이 클릭된 경우
					stop();		//Thread stop
				}else if(o == exit){ //exit 버튼이 클릭된 경우
					System.exit(0);		//Thread exit
				}
				System.out.println("Thread 상태 : " + getState());
			}
		};
		
		start.addActionListener(handler);
		stop.addActionListener(handler);
		suspend.addActionListener(handler);
		resume.addActionListener(handler);
		state.addActionListener(handler);
		exit.addActionListener(handler);
		
		
		frame.add(pan, "South");
		frame.setVisible(true);
		frame.setSize(400, 350);
	}
	
	public static void main(String[] args){
		new MyTicker();
	}
	
}
