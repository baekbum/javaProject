package kr.koreait.mouseMotionListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MouseMotionListenerTest03 extends JPanel implements Runnable{
	
	static int xpos = 150, ypos = 100;
	static int xp = 200;
	static Dimension dimension;
	static Frame frame = new Frame("MouseMotionListenerTest");
	
	public static void main(String[] args) {		
		frame.setBounds(600, 50, 500, 600);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
		
		MouseMotionListenerTest03 graphic = new MouseMotionListenerTest03();
		frame.add(graphic);
		
		graphic.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(e.getX() >= 44 && e.getX() <= dimension.width - 63){
					xp = e.getX() - 50;
				}				
			}			
		});
		
		Thread thread = new Thread(graphic);
		thread.start();
		
		frame.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 500, 600);
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, 50, 50);
		g.setColor(Color.black);
		g.fillRect(xp, 530, 100, 20);
	}

	@Override
	public void run() {
		int xsw = 1, ysw = 1;		
		while(true){			
			dimension = frame.getSize();
			int pos = xpos -25;
			xpos += xsw;			
			if(xpos >= dimension.width - 65 || xpos <=0){
				xsw *= -1;
			}
			ypos += ysw;
			if(pos >= xp-25 && pos <= xp+25 && ypos == 480 || ypos <= 0){
				ysw *= -1;
			}
			
			if(ypos > 530){
				JOptionPane.showMessageDialog(this, "게임 끝");
				xpos = 150; 
				ypos = 100;
			}
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			repaint();			
		}
		
	}	
}
