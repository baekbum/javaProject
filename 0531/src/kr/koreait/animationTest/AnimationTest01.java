package kr.koreait.animationTest;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

public class AnimationTest01 extends JPanel{
	
	Image img, bg; // 이미지 파일을 저장할 변수
	int w = 245, h = 239; // 이미지의 폭과 높이를 저장해둔다.
	
	public AnimationTest01() {
		String filename = "C:/Users/Administrator/workspace/0531/src/Image/fb.gif";
		img = Toolkit.getDefaultToolkit().getImage(filename);
		//bg = Toolkit.getDefaultToolkit().getImage("./src/images/GIF.gif");
	}	
	
	public static void main(String[] args) {
		Frame frame = new Frame("AnimationTest");		
		frame.setBounds(700, 50, 613, 329);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}			
		});
				
		AnimationTest01 Animation = new AnimationTest01();
		frame.add(Animation);
		
		frame.setVisible(true);	
	}

	@Override
	public void paint(Graphics g) {
		// drawImage(img, x, y, observer)
				// img : 윈도우에 표시할 이미지가 저장된 변수
				// x, y : 윈도우에 이미지가 표시될 시작 좌표
				// observer : 이미지가 표시될 윈도우
				g.drawImage(img, 0, 0, this);
				//drawImage(bg, 0, 0, this);
				// drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer) : 원본 이미지를 변형시켜 윈도우에
				// 표시할 떄 사용한다.
				// dx1, dy1 : 윈도우에 이미지가 표시될 시작 좌표
				// dx2, dy2 : 윈도우에 이미지가 표시될 끝 좌표
				// sx1, sy1 : 읽기 시작할 원본 이미지의 시작 좌표
				// sx2, sy2 : 읽기 시작할 원본 이미지의 끝 좌표
				g.drawImage(img, w*1, h*0, w*2, h*1, 0, 0, w, h, this); // 원래 모양
				g.drawImage(img, w*2, h*0, w*3, h*1, w, 0, 0, h, this); // 좌우 대칭
				g.drawImage(img, w*3, h*0, w*4, h*1, 0, h, w, 0, this); // 상하 대칭
				g.drawImage(img, w*4, h*0, w*5, h*1, w, h, 0, 0, this); // 상하좌우 대칭
				g.drawImage(img, w*5, h*0, w*7, h*2, 0, 0, w, h, this); // 4배 확대
				g.drawImage(img, w*7, h*0, w*7+w/2, h/2, 0, 0, w, h, this); // 1/4 축소
	}	
	
}
