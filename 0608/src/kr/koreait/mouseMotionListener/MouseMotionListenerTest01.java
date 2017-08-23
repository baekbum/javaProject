package kr.koreait.mouseMotionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseMotionListenerTest01 extends JFrame{
	
	JPanel panel = new JPanel();
	
	public MouseMotionListenerTest01() {
		setTitle("MouseMotionListenerTest");
		setBounds(800, 50, 300, 400);
		add(panel);
		
		panel.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("마우스 좌표 : " + e.getPoint());				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("마우스 좌표 :" + e.getX() + ", " + e.getY());
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		MouseMotionListenerTest01 frame = new MouseMotionListenerTest01();
	}
}
