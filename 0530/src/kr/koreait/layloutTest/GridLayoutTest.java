package kr.koreait.layloutTest;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

// 컨테이너를 격자(바둑판) 모양으로 나누고 컴포넌트를 차례차례 배치하는 레이아웃 매니저이다.
public class GridLayoutTest extends JFrame {
	
	JButton[] buttons = new JButton[16]; // 버튼 배열을 선언만 한 상태, 버튼 객체는 생성되지 않았다.
	String[] number = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
	Random random = new Random();
	
	public GridLayoutTest() {
		this("제목 없는 윈도우");
	}
	
	public GridLayoutTest(String title) {
		setTitle(title);
		setBounds(800, 50, 400, 400);
		
		GridLayout grid = new GridLayout(4, 4, 3, 3);
		// GridLayout에서 컨포넌트 사이에 여백 지정하기
		// GridLayout grid = new GridLayout(4, 4) : 여백 없음
		// GridLayout grid = new GridLayout(4, 4, 3, 3) : 여백 있음		
		setLayout(grid);
		
		for(int i=0; i<10000; i++){
			int r = random.nextInt(15) + 1;
			String temp = number[0];
			number[0] = number[r];
			number[r] = temp;			
		}
		
		for(int i=0; i<buttons.length; i++){
			// 배열로 선언한 컴포넌트는 컨테이너에 추가하기 전에 반드시 객체를 생성해야 한다.
			buttons[i] = new JButton(number[i]);
			buttons[i].setFont(new Font("Dialog", Font.BOLD, 30));
			add(buttons[i]);
			
			// getActionCommand() : 버튼위의 명령(문자열)을 얻어온다.
			if(buttons[i].getActionCommand().equals("16")){
				// setEnabled(false) : 버튼을 비활성화(보이기는 하지만 작동x) 시킨다.
				buttons[i].setEnabled(false);
				// setVisible(false) : 버튼을 안보이게 한다.
				buttons[i].setVisible(false);
			}
		}
		
		// Cursor 클래스를 사용해 마우스 아이콘(커서) 모양 바꾸기
		Cursor cursor1 = new Cursor(Cursor.WAIT_CURSOR); // 마우스 아이콘 모양을 변경한다.
		setCursor(cursor1);
		Cursor cursor2 = new Cursor(Cursor.HAND_CURSOR);
		buttons[5].setCursor(cursor2);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
			
	public static void main(String[] args) {
		GridLayoutTest frame = new GridLayoutTest("GridLayoutTest");
	}
}
