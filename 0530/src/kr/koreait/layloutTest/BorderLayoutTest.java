package kr.koreait.layloutTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;

// 컨테이너를 5개의 영역으로 나누고 컴포넌트를 각각의 영역으로 배치하는 레이아웃 매니저 이다.
public class BorderLayoutTest extends JFrame {

	Label label1 = new Label("Test1");
	Label label2 = new Label("Test2");
	Label label3 = new Label("Test3");
	Label label4 = new Label("Test4");
	Label label5 = new Label("Test5");
	Label label6 = new Label("Test5");
	
	public BorderLayoutTest() {
		this("제목 없는 윈도우");
	}
	
	public BorderLayoutTest(String title) {
		setTitle(title);
		setBounds(800, 50, 400, 400);
		
		BorderLayout border = new BorderLayout();
		setLayout(border);
		
		label1.setBackground(Color.YELLOW);
		label1.setAlignment(Label.CENTER);
		// add(컴포넌트, 방향) 방향이 생략되면 CENTER가 기본값이다.
		add(label1, BorderLayout.NORTH);
		//아래와 같이 배치할 방향을 입력하는 경우 반드시 첫 문자만 대문자로 표기해야 한다.
		//add("West", label1);
		
		label2.setBackground(Color.CYAN);
		label2.setAlignment(Label.CENTER);
		//add(label2, BorderLayout.SOUTH);
		
		label3.setBackground(Color.darkGray);
		label3.setAlignment(Label.CENTER);
		add(label3, BorderLayout.WEST);
		
		label4.setBackground(Color.MAGENTA);
		label4.setAlignment(Label.CENTER);
		add(label4, BorderLayout.EAST);
		
		label5.setBackground(Color.GREEN);
		label5.setAlignment(Label.CENTER);
		add(label5, BorderLayout.CENTER);
		
		label6.setBackground(Color.RED);
		label6.setAlignment(Label.CENTER);
		//add(label6, BorderLayout.SOUTH);
		
		// 한 영역에 두개 이상의 컴포넌트를 넣어야 한다면 패널에 구성하고 패널을 영역에 넣어주면 된다.
		// Panel과 JPanel의 기본 레이아웃 매니저는 FlowLayout이다.
		Panel panel = new Panel(new GridLayout(1, 2));
		panel.setPreferredSize(new Dimension(400, 50));
		panel.add(label2);
		panel.add(label6);
		add(panel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
			
	public static void main(String[] args) {
		BorderLayoutTest frame = new BorderLayoutTest("BorderayoutTest");
	}
}
