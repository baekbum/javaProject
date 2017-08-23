package kr.koreait.mouseListenerTest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseWheelListenerTest01 extends JFrame {
	
	JPanel panel01 = new JPanel();
	JPanel panel02 = new JPanel();
	
	public MouseWheelListenerTest01(){
		setTitle("MouseWheelListenerTest");
		setBounds(800, 50, 300, 400);
		GridLayout grid = new GridLayout(2, 1);
		setLayout(grid);
		add(panel01);
		add(panel02);
		
		// new MouseListener()로 MouseListener로 구현하면 인터페이스이기 떄문에 5개의 메소드가 자동으로 오버라이드
		// 되고 사용하지 않을 메소드도 그냥 둬야 한다.
		// 필요한 메소드만 사용하려면 new MouseAdapter()로 구현하고 사용할 메소드만 오버라이드 시켜서 사용하면 된다.
		panel02.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.println(e.getButton());
				// getButton() : 어떤 마우스 버튼이 클리되었나 얻어온다. 왼쪽(1), 오른쪽(3), 휠(2)
				
				/*switch(e.getButton()){
				case 1: //case MouseEvent.BUTTON1 : <- 옛날 방식
					System.out.println("왼쪽");
					break;
				case 2:
					System.out.println("휠");
					break;
				case 3:
					System.out.println("오른쪽");
					break;
				}*/
				
				//getModifiers() : 어떤 마우스 버튼이 클리되었나 얻어온다. 왼쪽(16), 오른쪽(4), 휠(8)
				
				/*switch(e.getModifiers()){
				case 16: //case MouseEvent.BUTTON1_MASK :
					System.out.println("왼쪽");
					break;
				case 8: // case MouseEvent.BUTTON2_MASK :
					System.out.println("휠");
					break;
				case 4: // case MouseEvent.BUTTON3_MASK :
					System.out.println("오른쪽");
					break;
				}*/
				
				/*System.out.println(e.getModifiersEx());
				switch(e.getModifiersEx()){
				case 64:
					System.out.println("shift + 클릭");
					break;
				case 128:
					System.out.println("ctrl + 클릭");
					break;
				case 512: 
					System.out.println("alt + 클릭");
					break;
				case 192: 
					System.out.println("shift + ctrl + 클릭");
					break;
				case 576: 
					System.out.println("shift + alt + 클릭");
					break;
				case 640: 
					System.out.println("alt + ctrl + 클릭");
					break;
				case 704: 
					System.out.println("shift +alt + ctrl + 클릭");
					break;
				case 1024: // == case MouseEvent.BUTTON1_DOWN_MASK :
					System.out.println("왼쪽 버튼 + 나머지 버튼 클릭");
					break;
				case 2048: // == case MouseEvent.BUTTON2_DOWN_MASK :
					System.out.println("휠 버튼 + 나머지 버튼 클릭");
					break;
				case 4096: // == case MouseEvent.BUTTON3_DOWN_MASK :
					System.out.println("오른쪽 버튼 + 나머지 버튼 클릭");
					break;					
				}*/
				
				// 마우스 왼쪽 버튼과 오른쪽 버튼이 동시에 클릭
				if((e.getModifiersEx() == 1024 && e.getModifiers() == 4) || (e.getModifiersEx() == 4096 && e.getModifiers() == 16) ){
					System.out.println("zzzz");
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
