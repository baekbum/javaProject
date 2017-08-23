package kr.koreait.graphicTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JPanel;

// 윈도우에 그래픽을 표시하려면 Pannel 또는 JPannel 클래스를 상속받고 paint() 메소드를 override 해서
// 구현한다.
public class GraphicTest03 extends JPanel implements Runnable{
	
	int xpos = 50, ypos = 50;
	Random random = new Random();
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setBounds(800, 200, 500, 600);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}			
		});
		
		GraphicTest03 graphic = new GraphicTest03();
		frame.add(graphic);
		
		frame.setVisible(true);
		
		Thread thread = new Thread(graphic);
		thread.start();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 600);
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		g.setColor(new Color(red, green, blue));
		g.fillOval(xpos, ypos, 50, 50);
		
	}

	@Override
	public void run() {
		int xsw = 1, ysw = 1;
		while(true){
			xpos += xsw;
			if(xpos >= 435 || xpos <=0){
				xsw *= -1;
			}
			ypos += ysw;
			if(ypos >= 515 || ypos <= 0){
				ysw *= -1;
			}		
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			//도형이 화면에 표시되는 자표를 변경했으면 반드시 도형을 다시 그려줘야 한다.
			//즉, paint() 메소드를 다시 실행시켜야 한다.
			//JPanel 클래스를 상속받아 작성한 paint() 메소드를 다시 실행하면 화면을 지우고 다시 그리지 않는다.
			repaint();			
		}
		
	}	
}
