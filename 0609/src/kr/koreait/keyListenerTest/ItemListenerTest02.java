package kr.koreait.keyListenerTest;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemListenerTest02 extends JFrame implements ItemListener{
	
	// Checkbox 클래스는 체크 상자나 라디오 상자를 만든다.
	Checkbox football, baseball, handball;
	// Checkbox 클래스로 라디오 상자를 만드려면 CheckboxGroup 클래스의 객체를 만들어서 Checkbox 클래스
	// 생성자의 3번째 인수로 넘겨줘야 한다.
	CheckboxGroup hobby = new CheckboxGroup();
	JPanel ControlPanel = new JPanel();
	JLabel label = new JLabel("이 곳에 선택한 목록이 나옵니다.");
	
	public ItemListenerTest02(){
		setTitle("ItemListenerTest");
		setBounds(500, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// new Checkbox("레이블")
		// new Checkbox("레이블", 선택여부, 그룹) : 선택 여부는 기본값이 false이다.
		// 그룹은 3번째 인수로 CheckboxGroup 클래스 객체를 넘겨주면 라디오 상자가 만들어 진다. (2번째 인수는 생략 할 수 없다.)
		// 2번째 인수에 true를 여러번 사용하면 맨 마지막의 true만 기능을 발휘하고 나머지는 무시된다.
		football = new Checkbox("축구", false, hobby);
		baseball = new Checkbox("야구", true, hobby);
		handball = new Checkbox("핸드볼", true, hobby);
		ControlPanel.add(football);
		ControlPanel.add(baseball);
		ControlPanel.add(handball);
		
		add(ControlPanel, BorderLayout.NORTH);
		
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label, BorderLayout.SOUTH);
		
		football.addItemListener(this);
		baseball.addItemListener(this);
		handball.addItemListener(this);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		ItemListenerTest02 frame = new ItemListenerTest02();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		// getItem() : 체크 상자나 라디오 상자에서 선택된 항목의 레이블을 얻어온다.
		//label.setText(e.getItem() + "");
		//label.setText(e.getItem().toString());
		
		// getStateChange() : 체크 상자가 선택되면 1, 해제되면 2를 얻어온다.
		label.setText(e.getItem().toString() + (e.getStateChange() == 1 ? "선택" : "해제" ));
		
		// getState() : 체크 상자 선택되면 true를 해제되면 false를 얻어온다.
		//System.out.println(football.getState());
		
	}
}
