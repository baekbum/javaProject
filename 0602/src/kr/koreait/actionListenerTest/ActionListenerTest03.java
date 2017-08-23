package kr.koreait.actionListenerTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionListenerTest03 extends JFrame{
	
	JButton button = new JButton("1");
	JPanel panel = new JPanel();
	boolean bool = true;
	
	public ActionListenerTest03() {
		this("기본");		
	}
	
	public ActionListenerTest03(String title) {
		GridLayout gridLay = new GridLayout(2, 1);
		setTitle(title);
		setBounds(800, 50, 300, 400);
		setLayout(gridLay);
		
		add(button);
		add(panel);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(bool){
					remove(button);
					remove(panel);
					add(panel);
					add(button);
					bool = false;
				}
				else{
					remove(panel);
					remove(button);
					add(button);
					add(panel);
					bool = true;					
				}								
				// 컨테이너에 배치된 컴포넌트의 위치가 변경되면 변경된 좌표를 재계산해서 다시 표시해야 한다.
				// revalidate() 메소드를 실행해 좌표를 다시 계산해서 표시한다.
				revalidate();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public static void main(String[] args) {
		ActionListenerTest03 frame = new ActionListenerTest03();		
	}
}
