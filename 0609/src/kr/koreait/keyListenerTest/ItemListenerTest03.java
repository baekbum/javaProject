package kr.koreait.keyListenerTest;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemListenerTest03 extends JFrame implements ItemListener{
	
	// Checkbox 클래스는 체크 상자나 라디오 상자를 만든다.
	JCheckBox football, baseball, handball; // JCheckBox는 한글이 깨지지 않는다.	
	JPanel ControlPanel = new JPanel();
	JLabel label = new JLabel("이 곳에 선택한 목록이 나옵니다.");
	
	public ItemListenerTest03(){
		setTitle("ItemListenerTest");
		setBounds(500, 50, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		football = new JCheckBox("축구");
		baseball = new JCheckBox("야구", true);
		handball = new JCheckBox("핸드볼", true);
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
		ItemListenerTest03 frame = new ItemListenerTest03();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		JCheckBox item = (JCheckBox)obj;
		// isSelected() : 체크 상자가 선택된 상태면 true, 해제된 상태면 false를 리턴한다.
		label.setText(item.getText() + (item.isSelected() ? "선택" : "해체"));
		
	}
}
