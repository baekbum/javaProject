package kr.koreait.keyListenerTest;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemListenerTest01 extends JFrame implements ItemListener{
	
	// Checkbox 클래스는 체크 상자나 라디오 상자를 만든다.
	JCheckBox football, baseball, handball; // JCheckBox는 한글이 깨지지 않는다.
	
	JPanel ControlPanel = new JPanel();
	JLabel label = new JLabel("이 곳에 선택한 목록이 나옵니다.");
	
	public ItemListenerTest01(){
		setTitle("ItemListenerTest");
		setBounds(500, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		football = new JCheckBox("축구");
		baseball = new JCheckBox("야구");
		handball = new JCheckBox("핸드볼");
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
		ItemListenerTest01 frame = new ItemListenerTest01();
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
