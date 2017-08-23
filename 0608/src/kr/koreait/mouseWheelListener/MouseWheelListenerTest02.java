package kr.koreait.mouseWheelListener;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseWheelListenerTest02 extends JFrame{
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	JPanel panel03 = new JPanel();
	JPanel panel04 = new JPanel();
	JPanel panel05 = new JPanel();
	
	JLabel label01 = new JLabel();
	JLabel label02 = new JLabel();
	JLabel label03 = new JLabel();
	int RC = 127, GC = 127, BC = 127;
	
	public MouseWheelListenerTest02(){
		setTitle("MouseWheelListenerTest");
		setBounds(800, 50, 300, 400);
		GridLayout grid01 = new GridLayout(2, 1);
		GridLayout grid02 = new GridLayout(1, 3);
		setLayout(grid01);
		panel01.setBackground(Color.GRAY);
		panel02.setLayout(grid02);
		
		add(panel01);		
		add(panel02);	
		
		panel02.add(panel03);
		panel03.setBackground(Color.RED);
		panel03.add(label01);
		label01.setText(RC + "");
		label01.setForeground(Color.YELLOW);
		
		panel02.add(panel04);
		panel04.setBackground(Color.GREEN);
		panel04.add(label02);
		label02.setForeground(Color.YELLOW);
		label02.setText(GC + "");
		
		panel02.add(panel05);
		panel05.setBackground(Color.BLUE);
		panel05.add(label03);
		label03.setForeground(Color.YELLOW);
		label03.setText(BC + "");
		
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
		
		panel03.addMouseWheelListener(new MouseWheelListener() {			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getWheelRotation() > 0){
					if(RC != 255){
						label01.setText(RC + "");
						RC++;
						panel01.setBackground(new Color(RC, GC, BC));
					}
				}
				else {
					if(RC != -1 ){
						label01.setText(RC + "");
						RC--;
						panel01.setBackground(new Color(RC, GC, BC));
					}
				}				
			}
		});
		
		panel04.addMouseWheelListener(new MouseWheelListener() {			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getWheelRotation() > 0){
					if( GC != 255){
						label02.setText(GC + "");
						GC++;
						panel01.setBackground(new Color(RC, GC, BC));
					}					
				}
				else {
					if(GC != -1 ){
						label02.setText(GC + "");
						GC--;
						panel01.setBackground(new Color(RC, GC, BC));
					}
				}
			}
		});
		
		panel05.addMouseWheelListener(new MouseWheelListener() {			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getWheelRotation() > 0){
					if(BC != 255){
						label03.setText(BC + "");
						BC++;
						panel01.setBackground(new Color(RC, GC, BC));
					}
				}
				else {
					if(BC != -1){
						label03.setText(BC + "");
						BC--;
						panel01.setBackground(new Color(RC, GC, BC));
					}
				}			
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MouseWheelListenerTest02 frame = new MouseWheelListenerTest02();
	}
}
