package kr.koreait.mouseListenerTest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseListenerTest01 extends JFrame {
	
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	
	public MouseListenerTest01(){
		setTitle("MouseListenerTest");
		setBounds(800, 50, 300, 400);
		GridLayout grid = new GridLayout(2, 1);
		setLayout(grid);
		add(panel01);
		add(panel02);
		panel02.addMouseListener(new MouseListener() {
			
			@Override
			//mouseReleased() 메소드가 mouseClicked() 메소드보다 먼저 실행된다.
			public void mouseReleased(MouseEvent e) {
				System.out.println("MouseListener가 걸리는 영역에 마우스 버튼을 뗄 때");
				panel01.setBackground(Color.CYAN);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("MouseListener가 걸리는 영역에 마우스 버튼을 누르고 있을 때");
				panel01.setBackground(Color.YELLOW);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("MouseListener가 걸리는 영역에 마우스 포인터가 빠져나갈때 때");
				panel01.setBackground(Color.RED);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("MouseListener가 걸리는 영역에 마우스 포인터가 들어올 때");
				panel01.setBackground(Color.BLUE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("MouseListener가 걸리는 영역에 마우스가 클릭될 때");
				panel01.setBackground(Color.GREEN);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		MouseListenerTest01 frame = new MouseListenerTest01();
	}
}
