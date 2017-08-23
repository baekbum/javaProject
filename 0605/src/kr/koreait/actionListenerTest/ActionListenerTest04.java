package kr.koreait.actionListenerTest;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionListenerTest04 extends JFrame implements ActionListener, Runnable{
	
	JButton startBtn = new JButton("시작");
	JButton stopBtn = new JButton("종료");
	boolean flag = true;
	static ActionListenerTest04 frame;
	
	public ActionListenerTest04() {
		this("기본");		
	}
	
	public ActionListenerTest04(String title) {
		setTitle(title);
		setBounds(800, 50, 300, 400);
				
		GridLayout grid = new GridLayout(1, 2);
		setLayout(grid);
		add(startBtn);
		add(stopBtn);
		
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		frame = new ActionListenerTest04();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread thread = new Thread(frame);
		if(e.getActionCommand().equals("시작")){	
			flag = true;
			thread.start();
		}
		else if(e.getActionCommand().equals("종료")){
			flag = false;
		}
	}

	@Override
	public void run() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
		while(flag){
			long start = System.currentTimeMillis();
			setTitle(sdf.format(start));
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}		
	}
}
