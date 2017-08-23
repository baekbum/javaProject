package kr.koreait.mouseWheelListener;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseWheelListenerTest01 extends JFrame{
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	
	JLabel label = new JLabel("힝");
	int siz = 40;
	
	public MouseWheelListenerTest01(){
		setTitle("MouseWheelListenerTest");
		setBounds(800, 50, 300, 400);
		GridLayout grid = new GridLayout(2, 1);
		setLayout(grid);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setFont(new Font("궁서체",Font.BOLD, siz));
		panel01.add(label);
		add(panel01);
		add(panel02);
		
		panel01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// getClickCount() : 마우스 버튼이 클릭된 횟수를 알아낸다.
				//System.out.println(e.getClickCount());
				if(e.getModifiers() == 16 && e.getClickCount() == 2){
					System.out.println("마우스 왼쪽 버튼 더블 클릭");
				}
			}			
		});
		
		panel02.addMouseWheelListener(new MouseWheelListener() {			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// getWheelRotation() : 마우스 휠이 굴러가는 방향을 알아낸다.
				if(e.getWheelRotation() > 0){
					if(siz > 10){
						siz--;
						label.setFont(new Font("궁서체",Font.BOLD, siz));
						System.out.println("마우스 휠을 뒤로 당김");
					}
				}
				else {
					if(siz < 71){
						siz++;
						label.setFont(new Font("궁서체",Font.BOLD, siz));
						System.out.println("마우스 휠을 앞으로 밈");
					}
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MouseWheelListenerTest01 frame = new MouseWheelListenerTest01();
	}
}
