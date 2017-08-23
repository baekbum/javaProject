package kr.koreait.graphicTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 윈도우에 그래픽을 표시하려면 Pannel 또는 JPannel 클래스를 상속받고 paint() 메소드를 override 해서
// 구현한다.
public class GraphicTest01 extends Panel{	
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setBounds(800, 200, 700, 700);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}			
		});		
		
		// 그래픽을 윈도우에 표시하려면 Pannel 또는 JPannel 클래스를 상속받아 그래픽을 구현한 클래스의 객체를
		// 생성하고 생성된 객체를 윈도우에 추가시켜야 한다.
		
		GraphicTest01 graphic = new GraphicTest01();
		frame.add(graphic);
		
		frame.setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// drawString(str, x, y) : str의 문자열을 시작점(x,y)부터  그린다.
		g.drawString("윈도우에 글자 출력하기", 50, 50);
		
		g.setColor(Color.RED);
		// drawLine(x1, y1, x2, y2) : 시작점 (x1,y1) 부터 끝점(x2,y2)까지 직선을 그린다.
		g.drawLine(100, 100, 200, 200);
		
		g.setColor(Color.BLUE);
		// drawRect(x, y, width, height) : 시작점 (x,y)부터 폭, 높이 만큼 사격형을 그린다.
		g.drawRect(100, 100, 100, 100);
		
		g.setColor(Color.GREEN);
		// drawOval(x, y, width, height) : 시작점 (x,y)부터 폭, 높이 만큼 원을 그린다.
		g.drawOval(100, 100, 100, 100);
		
		g.setColor(Color.YELLOW);
		g.fillRect(250, 100, 100, 100); // 색이 채워진 사격형을 그린다.
		g.setColor(new Color(255, 0, 255, 100));
		g.fillOval(300, 100, 100, 100); // 색이 채워진 원을 그린다.
		
		g.setColor(Color.CYAN);
		//fillArc(x, y, width, height, startAngle, arcAngle) : 시작점 (x,y)부터 폭, 높이 만큼의
		//사각형에 내접하고 startAngle부터 반시계 방향으로 arcAngle도 만큼 진행하는 호를 그린다.
		g.fillArc(100, 250, 100, 100, 30, 300);
		
	}	
}
