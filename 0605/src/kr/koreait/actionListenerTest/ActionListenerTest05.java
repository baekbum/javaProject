package kr.koreait.actionListenerTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionListenerTest05 extends JFrame implements ActionListener, Runnable{
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	JButton startBtn = new JButton("시작");
	JButton pauseBtn = new JButton("일시정지");
	JButton stopBtn = new JButton("초기화");
	boolean flag = true;
	boolean clear = false;
	static ActionListenerTest05 frame;
	long start, end;
	
	public ActionListenerTest05() {
		this("기본");		
	}
	
	public ActionListenerTest05(String title) {
		setTitle(title);
		setBounds(800, 50, 300, 400);
				
		GridLayout grid = new GridLayout(3, 1);
		setLayout(grid);
		add(startBtn);
		add(pauseBtn);
		add(stopBtn);
		
		startBtn.addActionListener(this);
		pauseBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		stopBtn.setEnabled(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		frame = new ActionListenerTest05();
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getActionCommand().equals("시작")){	
			Thread thread = new Thread(frame);
			thread.start();
			flag = true;
			stopBtn.setEnabled(false);			
		}
		else if(e.getActionCommand().equals("일시정지")){
			flag = false;
			stopBtn.setEnabled(true);
		}
		else if(e.getActionCommand().equals("초기화")){
			start = 0;
			flag = true;
			setTitle(sdf.format(-32400000));
		}
	}

	@Override
	public void run() {		
		if(start == 0){
			start = System.currentTimeMillis();
			end = start;
		}		
		while(flag){
			long time = end++ - start - 32400000; 
			setTitle(sdf.format(time));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}
