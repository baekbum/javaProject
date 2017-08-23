package kr.koreait.actionListenerTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListenerTest02 extends JFrame implements ActionListener {
	
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	 
	public ActionListenerTest02() {
		this("이름 없음");
	}
	
	public ActionListenerTest02(String title) {
		setTitle(title);
		setBounds(800, 50, 300, 400);
		
		GridLayout grid = new GridLayout(3, 1);
		setLayout(grid);
		
		add(button1);
		add(button2);
		add(button3);
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼이 클릭되면 actionPerformed() 메소드의 내용이 실행된다.
				//JOptionPane.showMessageDialog(parentComponent, message)
				//parentComponent : 지정된 컴포넌트 위에 메세지 상자가 표시된다.
				//JOptionPane.showMessageDialog(button1, "종료");
				
				//JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
				// title : 메시지 상자 제목 표시줄에 표시될 문자열
				// messageType : 메시지 앞에 표시되는 아이콘을 지정한다.
				//JOptionPane.showMessageDialog(button1, "종료", "핫!", JOptionPane.ERROR_MESSAGE);
				
				//JOptionPane.showMessageDialog(parentComponent, message, title, messageType, icon);
				// icon : messageType 대신 표시할 이미지 파일을 지정한다.
				JOptionPane.showMessageDialog(button1, "종료", "핫!", JOptionPane.ERROR_MESSAGE,new ImageIcon("C:/Users/Administrator/workspace/0602/src/Image/fb.gif"));
				
				System.exit(0);
			}
		});
		
		// ActionListener 인터페이스를 구현받아 ActionListener를 구현하려면 ActionListener를 구현할 객체에
		// addActionListener(this)를 실행한다.
			button2.addActionListener(this);
			button3.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		ActionListenerTest02 action01 = new ActionListenerTest02();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ActionListener가 실행되는 객체의 정보가 ActionEvent 변수 e로 넘어온다.
		
		// 클래스에 ActionListener 인터페이스를 구현해서 구현한 ActionListener는 맨 처음에 어떤 컴포넌트 에서
		// ActionListener가 실행되었나를 판단해야한다.
		// getActionCommand() : 버튼 위의 text를 가져온다.
		//System.out.println(e.getActionCommand());
		switch(e.getActionCommand()){
		case "2" :
			System.out.println("2222"); 
			break;
		case "3" :
			System.out.println("3333");
			break;
		}
		
		//getSource() : ActionListener가 실행된 객체의 정보를 얻어온다.
		Object obj = e.getSource();
		if((JButton)obj == button2){
			// JOptionPane.showConfirmDialog(parentComponent, message) : 어떤 행동을 확인하는 윈도우 창을 띄운다.
			// 클릭한 버튼에 따른 출력이 숫자로 나온다, 예,확인(0), 아니오(1), 취소(2)
			//int result = JOptionPane.showConfirmDialog(button2, "프로그램을 종료하겠습니까?");
			
			
			// optionType : 대화 상자에 표시되는 버튼의 종류를 지정한다.
			//int result = JOptionPane.showConfirmDialog(button2,"프로그램을 종료하겠습니까?", "종료", JOptionPane.YES_NO_CANCEL_OPTION);
			
			//JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType)
			//int result = JOptionPane.showConfirmDialog(button2,"프로그램을 종료하겠습니까?", "종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);

			//JOptionPane.showConfirmDialog(parentComponent, message, title, optionType, messageType, icon)
			int result = JOptionPane.showConfirmDialog(button2,"프로그램을 종료하겠습니까?", "종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("C:/Users/Administrator/workspace/0602/src/Image/fb.gif"));
			
			if(result == 0){
				System.exit(0);
			}
		}
		else if((JButton)obj == button3) {
			//JOptionPane.showInputDialog(message)
			//String name = JOptionPane.showInputDialog("이름??");
			
			//JOptionPane.showInputDialog(parentComponent, message)
			//String name = JOptionPane.showInputDialog(button3, "이름??");
			
			//JOptionPane.showInputDialog(message, initialSelectionValue)
			//initialSelectionValue : InputDialog의 안내 메시지를 출력한다. placeholder랑 비슷함(기본값 설정)
			//String name = JOptionPane.showInputDialog("이름", "ex)홍길동");
			
			//JOptionPane.showInputDialog(parentComponent, message, initialSelectionValue)
			//String name = JOptionPane.showInputDialog(button3, "이름??", "ex)홍길동");
			
			//JOptionPane.showInputDialog(parentComponent, message, title, messageType)
			//String name = JOptionPane.showInputDialog(button3, "이름??", "이름", JOptionPane.QUESTION_MESSAGE);
			
			//입력할 내용을 키보드로 입력하지 않고 콤보 상자에서 선택한다.
			//JOptionPane.showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue)
			//selectionValues : 콤보 상자에 표시할 문자열이 저장된 배열
			String[] menu = {"햄버거","피자","치킨","짜장면","초코파이"};
			//initialSelectionValue : 배열에 입력된 내용중 콤보 상자에 기본값으로 표시할 문자열
			
			String name = (String) JOptionPane.showInputDialog(button3, "뭐 먹을래??", "음식", JOptionPane.QUESTION_MESSAGE, new ImageIcon("C:/Users/Administrator/workspace/0602/src/Image/fb.gif"), menu, "피자");
			
			
			JOptionPane.showMessageDialog(button3, name + "님 안녕하세요");
		}
	}
}
