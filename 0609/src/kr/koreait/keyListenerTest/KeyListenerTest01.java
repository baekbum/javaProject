package kr.koreait.keyListenerTest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class KeyListenerTest01 extends JFrame{
	
	public KeyListenerTest01() {
		setTitle("KeyListenerTest");
		setBounds(500, 50, 600, 400);
		
		addKeyListener(new KeyListener() {
			
			@Override
			// keyTyped() 메소드가 keyReleased() 메소드 보다 먼저 실행된다.
			public void keyTyped(KeyEvent e) {
				//System.out.println(e.getKeyChar() + "키가 타이핑 됨");
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println(e.getKeyChar() + "키에서 손을 땜");
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println(e.isShiftDown());
				//System.out.println(e.isActionKey());
				
				// getKeyChar() : 문자가 입력되는 키보드를 누른 경우 키보드에 해당되는 문자를 얻어온다.
				// 아무런 내용도 입력되지 않으면 아무것도 얻어오지 않는다.
				//System.out.println(e.getKeyChar());
				
				// getKeyCode() : 입력한 키보드의 코드값을 얻어온다.
				//System.out.println(e.getKeyCode());
				//System.out.println(e.getKeyChar() + "키가 눌림");
				System.out.println(e.getKeyCode());
				switch(e.getKeyCode()){
				case 37: case KeyEvent.VK_A : System.out.println("왼쪽으로 이동"); break;
				case 38: case KeyEvent.VK_W : System.out.println("위쪽으로 이동"); break;
				case 39: case KeyEvent.VK_S :System.out.println("오른쪽으로 이동"); break;
				case 40: case KeyEvent.VK_D : System.out.println("아래쪽으로 이동"); break;
				case 32: /*case KeyEvent.VK_SPACE :*/ System.out.println("점프"); break;
				
				}
				
				if(e.getModifiersEx() == 128 && e.getKeyCode() == KeyEvent.VK_S){
					System.out.println("저장");					
				}
				
				if(e.getModifiersEx() == 128 && e.getKeyCode() == KeyEvent.VK_O){
					System.out.println("열기");					
				}
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		KeyListenerTest01 frame = new KeyListenerTest01();
	}
}
