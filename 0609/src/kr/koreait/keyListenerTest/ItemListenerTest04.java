package kr.koreait.keyListenerTest;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ItemListenerTest04 extends JFrame implements ItemListener{
	
	// Checkbox 클래스는 체크 상자나 라디오 상자를 만든다.
	JRadioButton football, baseball, handball; // JCheckBox는 한글이 깨지지 않는다.
	// JRadioButton 클래스로 생성한 라디오 버튼을 ButtonGroup 클래스의 객체를 이용해 그룹화 시켜야 한다.
	ButtonGroup group = new ButtonGroup();
	JPanel ControlPanel = new JPanel();
	JLabel label = new JLabel("이 곳에 선택한 목록이 나옵니다.");
	
	public ItemListenerTest04(){
		setTitle("ItemListenerTest");
		setBounds(500, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// JRadioButton 클래스 생성자의 2번째 인수에 true를 여러개 사용하면 맨 처음 사용된 JRadioButton 클래스
		// 객체가 기본 선택된다.		
		football = new JRadioButton("축구");
		baseball = new JRadioButton("야구", true);
		handball = new JRadioButton("핸드볼", true);
		
		// ButtonGroup 클래스 객체에 JRadioButton 클래스 객체를 추가해서 그룹으로 묶는다.
		group.add(football);
		group.add(baseball);
		group.add(handball);
		
		
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
		ItemListenerTest04 frame = new ItemListenerTest04();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		JRadioButton item = (JRadioButton)obj;
		// isSelected() : 체크 상자가 선택된 상태면 true, 해제된 상태면 false를 리턴한다.
		label.setText(item.getText() + (item.isSelected() ? "선택" : "해체"));
		
	}
}
