package chapter13;
import java.awt.*; 
import java.awt.event.*; 
class ScrollMsg extends Panel implements Runnable{ 
	String msg = " hi~~~~~~~~~~~ *^^*"; 
	ScrollMsg(){ 
		setFont(new Font("Serif" , Font.BOLD , 20)); 
		setSize(300, 400); 
		show(); 
	} 
	public void paint(Graphics g) 
	{g.drawString(msg, 60, 50);} 
	public void run(){ 
		while(true){ 
			try{ 
				msg = msg.substring(1,msg.length()) + msg.substring(0, 1); 
				Thread.sleep(100); //0.1초 잠자기
			}catch(Exception e){} 
			repaint(); 
		} 
	} // run method ended 
}
class MainScroll extends Frame implements ActionListener { 
	Button start, stop;  //Thread�� control�ϴ� ��ư
	Panel pSouth;					//��ư���� ��� Panel
	ScrollMsg pCenter; //Thread�� ������ �ڵ� and Data
	Thread t1;									
	MainScroll(){ 
		start = new Button("����"); 		stop = new Button("����"); 
		pCenter = new ScrollMsg();		pSouth = new Panel();
		t1 = new Thread(pCenter);	 		t1.start();
		pSouth.add(start);												pSouth.add(stop); 
		add(pCenter, "Center");							add(pSouth, "South");
		stop.addActionListener(this);		start.addActionListener(this); 
		setSize(300, 300);												setVisible(true); 
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
			{				System.exit(0);			}
		});
	} 
	public void actionPerformed(ActionEvent e){ 
		String s = e.getActionCommand(); 
		if(s=="����"){ 
			try{ 	t1.resume(); 
			}catch(Exception e2) { 	System.out.println(e2); } 
		}else if( s=="����"){ 
			try { 
					System.out.println(s); 
					t1.suspend(); 
				}catch(Exception e1){ System.out.println(e1); } 
		} 
	} 
	public static void main(String args []){ 
		MainScroll ms= new MainScroll(); 
		ThreadGroup help, tg;
		for( help = tg = Thread.currentThread().getThreadGroup(); 
		help != null; tg = help, help = help.getParent())
		;
		tg.list();
		} 
} 







