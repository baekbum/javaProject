package kr.koreait.mouseMotionListener;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseMotionListenerTest02 extends Panel{
	
	static int xpos = 150, ypos = 100;
	
	public static void main(String[] args) {
		Frame frame = new Frame("MouseMotionListenerTest");
		frame.setBounds(600, 50, 500, 600);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
		
		MouseMotionListenerTest02 graphic = new MouseMotionListenerTest02();
		frame.add(graphic);
		
		graphic.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				xpos = e.getX() - 25;
				ypos = e.getY() - 25;
				graphic.repaint();
			}			
		});
		
		frame.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(xpos, ypos, 50, 50);
	}	
}
