package kr.koreait.actionListenerTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GraphTest extends JPanel implements Runnable{
	
	static JPanel panel = new JPanel();
	static JLabel label1, label2, label3;
	static JTextField field1, field2, field3;
	static TextField field4;
	static JPasswordField field5;
	static JButton button = new JButton("그래프");
	static int java, jsp, spring;
	
	public static void main(String[] args) {
		GraphTest graph = new GraphTest();
		BorderLayout border = new BorderLayout();
		JFrame frame = new JFrame("제목없음");		
		frame.setLayout(border);
		frame.setBounds(700, 50, 400, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(graph);
		
		label1 = new JLabel("JAVA");
		label2 = new JLabel("JSP");
		label3 = new JLabel("SPRING");
		field1 = new JTextField(3);
		field2 = new JTextField(3);
		field3 = new JTextField(3);
		//field4.setEchoChar('*'); // 텍스트 필드 문자를 **로 표기 되도록 한다
		//field5 = new JPasswordField(); // 텍스트 필드 문자를 비밀번호 표시 문자로 바꿔준다.
		
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(button);		
		frame.add(panel, BorderLayout.SOUTH);
		
		button.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 텍스트 필드에 입력된 값을 각 과목의 점수를 기억하는 변수에 저장시킨다.
				java = Integer.parseInt(field1.getText());
				jsp = Integer.parseInt(field2.getText());
				spring = Integer.parseInt(field3.getText());
				
				Thread thread = new Thread(graph);
				thread.start();
			}
		});		
		
		frame.setVisible(true);
		
	}

	@Override
	public void paint(Graphics g) {
		// 잔상이 남지 않도록 전체를 흰색 사각형으로 덮어준다.
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 400, 350);
		// 그래프를 표시하기 위한 선을 그린다.
		g.setColor(Color.BLACK);
		g.drawString("JAVA", 90, 270);
		g.drawString("JSP", 180, 270);
		g.drawString("SPRING", 270, 270);
		g.drawLine(50, 30, 50, 250); // y축(세로선)
		// 11번 반복하며 가로선을 그린다.
		for(int i=0; i<11; i++){
			g.drawString(i*10 + "", 20, 255 - i * 20); // y축 레이블 
			g.drawLine(50, 250 - i * 20, 350, 250 - i * 20); // x축(가로선)
		}
		
		//각 과목에 점수에 따른 막대 그래프를 출력한다.
		g.setColor(Color.RED);
		g.fillRect(95, 250 - java * 2, 20, java * 2);
		g.fillRect(180, 250 - jsp * 2, 20, jsp * 2);
		g.fillRect(270, 250 - spring * 2, 20, spring * 2);
	}

	@Override
	public void run() {
		// 다 같이 위로 올라가는 그래프를 그린다
		for(int i=0; i<=100; i++){			
			java = jsp = spring = i;
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			repaint();
		}
		
		//각 과목의 점수만큼 내려가는 그래프를 그린다.
		boolean javaFlag = false, jspFlag = false, springFlag = false;
		while(true){
			//각 과목의 점수만큼 그래프를 표시하고 그래프를 다 표시한 과목의 flag를 true로 변경한다.
			if(java != Integer.parseInt(field1.getText())){
				java --;				
			}
			else{
				javaFlag = true;
			}
			
			if(jsp != Integer.parseInt(field2.getText())){
				jsp --;				
			}
			else{
				jspFlag = true;
			}
			
			if(spring != Integer.parseInt(field3.getText())){
				spring--;
			}
			else{
				springFlag = true;
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
			// 모든 과목의 그래프 출력이 완료되면 반복을 탈출한다.
			if(javaFlag && jspFlag && springFlag){
				break;
			}
			repaint();			
		}		

		// 다음 점수를 처리하기 위해 텍스트 필드에 입력된 내용을 지우고 java 점수를 입력하는 텍스트 필드로
		// 커서를 이동시킨다.
		field1.setText("");
		field2.setText("");
		field3.setText("");
		field1.requestFocus(); // 텍스트 필드에 커서를 넣어준다.
		
	}
	
}
