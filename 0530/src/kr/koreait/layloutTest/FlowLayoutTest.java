package kr.koreait.layloutTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;

// 컨테이너에 컴포넌트를 원래의 크기대로 차례차례 배치하는 레이아웃 매니저이다.
// Frame과 JFrame의 기본 레이아웃 매너지는 BorderLayout 이다.
public class FlowLayoutTest extends JFrame {
	
	Label label1 = new Label("TEST1");
	Label label2 = new Label("TEST2");
	Label label3 = new Label("TEST3");
	JLabel label4 = new JLabel("테스트4");
	
	public FlowLayoutTest() {
		this("제목 없는 윈도우");
	}
	
	public FlowLayoutTest(String title) {
		setTitle(title);
		setBounds(0, 0, 400, 300);
		
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT); // FlowLayout 객체 생성
		// FlowLayout의 컴포넌트 정렬 방법
		// new FlowLayout(FlowLayout.LEFT) 왼쪽
		// new FlowLayout(FlowLayout.CENTER) 가운데 (기본값)
		// new FlowLayout(FlowLayout.RIGHT 오른쪽
		
		setLayout(flow); // 윈도우에 FlowLayout을 적용한다.
		label1.setBackground(Color.MAGENTA); // Label의 배경색을 변경한다.
		label1.setForeground(Color.BLACK); // Label의 전경(글자)색을 변경한다.
		label1.setAlignment(Label.RIGHT); // Label의 글자 정렬 방식을 변경한다.
		
		label2.setBackground(Color.MAGENTA);
		label2.setForeground(Color.BLACK); 
		label2.setAlignment(Label.RIGHT); 
		
		label3.setBackground(Color.MAGENTA);
		label3.setForeground(Color.BLACK); 
		label3.setAlignment(Label.RIGHT);
				
		label4.setOpaque(true); // JLabel에 배경색을 넣으려면 해줘야 한다.
		label4.setBackground(Color.BLACK);
		label4.setForeground(Color.CYAN);
		// setPreferredSize(new Dimension(가로, 세로)) : JLabel의 크기를 변경한다.
		label4.setPreferredSize(new Dimension(200, 150));
		// setHorizontalAlignment() : JLabel의 수평 정렬 방식을 변경한다.
		label4.setHorizontalAlignment(JLabel.CENTER);
		// setVerticalAlignment() : JLabel의 수직 정렬 방식을 변경한다.
		label4.setVerticalAlignment(JLabel.CENTER);
		
		
		// Font 클래스를 사용해 글꼴, 글자 모양, 글자 크기를 변경하는 방법
		// new Font(name, style, size)
		// name : 글꼴 이름, serif, sansSerif, Monospaced, Dialog, DialogInput만 사용할 수 있다.
		// JLabel을 사용하면 한글 이름을 가지는 글꼴도 사용할 수 있다.
		// style : Font.BOLD(굵게), Font.ITALIC(기울임꼴), Font.PLAIN(보통 모양)
		// size : 글자 크기, 단위는 point
		Font font = new Font("Dialog", Font.ITALIC, 50);
		label1.setFont(font); // Label의 글꼴을 변경한다.
		label2.setFont(new Font("serif", Font.BOLD, 30));
		label3.setFont(new Font("Monospaced", Font.PLAIN, 40));
		label4.setFont(new Font("궁서체", Font.BOLD, 40));
		
		label3.setText("테스트");
		
		add(label1); // Label을 윈도우에 추가시킨다.
		add(label2);
		add(label3);
		add(label4);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}	
	
	public static void main(String[] args) {
		FlowLayoutTest frame = new FlowLayoutTest("FlowLayoutTest");
	}
}
