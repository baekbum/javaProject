package kr.koreait.graphicTest;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class countDown extends Frame implements Runnable {

	Label[] labels = new Label[10];
	Random random = new Random();
	CardLayout card = new CardLayout();
	
	public countDown() {
		this("제목 없는 윈도우");
	}
	
	public countDown(String title) {
		setTitle(title);
		setBounds(800, 50, 400, 400);
			
		setLayout(card);
		
		for(int i = 0; i<labels.length; i++){
			String str = 9 - i + "";
			labels[i] = new Label(str);
			labels[i].setAlignment(Label.CENTER);
			labels[i].setFont(new Font("Dialog", Font.BOLD, 300));
			add(str, labels[i]);			
		}
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}			
		});
		setVisible(true);
	}
			
	public static void main(String[] args) {
		countDown frame = new countDown("CardLayoutTest");
		Thread thread = new Thread(frame);
		thread.start();
	}

	@Override
	public void run() {
		while(true){
			for(int i=labels.length-1; i>=0; i--){
				int r = random.nextInt(256);
				int g = random.nextInt(256);
				int b = random.nextInt(256);
				labels[i].setBackground(new Color(r, g, b));
				card.show(this, i + "");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}			
			
		}
	}	
}
