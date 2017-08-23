package kr.korea.actionListenerTest;

import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionListenerTest06 extends JFrame implements ActionListener{
	
	Label headerLabel; 	// 윈도우 상단의 라벨
	Panel comboPanel; 	// 콤보 상자, 보기 버튼, 삭제 버튼이 올라갈 패널
	Choice combo;		// 콤보 상자
	JButton showBtn;	// 보기 버튼
	JButton deleteBtn; 	// 삭제 버튼
	Panel addPanel; 	// 텍스트 필드, 추가 버튼이 올라갈 패널
	TextField field; 	// 텍스트 필드
	JButton addBtn;		// 추가 버튼
	Label bottomLabel; 	// 윈도우 하단의 라벨
	
	public ActionListenerTest06() {
		setTitle("ActionListenerTest");
		setBounds(800, 50, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 1));
		
		// 윈도우 상단의 라벨 세팅
		headerLabel = new Label("콤보 상자 테스트");
		headerLabel.setFont(new Font("Dialog", Font.BOLD, 35));
		headerLabel.setAlignment(Label.CENTER);
		add(headerLabel);
		
		// 프레임 중단의 콤보 상자와 보기 버튼 삭제 버튼 세팅
		comboPanel = new Panel();		
		combo = new Choice();
		combo.add("짜장면"); // 콤보 상자에 목록을 추가한다.
		combo.add("짬뽕");
		combo.add("군만두");
		combo.add("볶음밥");
		combo.add("기스면");
		combo.add("베리베리베리베리");
		comboPanel.add(combo);
		showBtn = new JButton("보기");
		comboPanel.add(showBtn);
		deleteBtn = new JButton("삭제");
		comboPanel.add(deleteBtn);		
		add(comboPanel);
		
		//윈도우 중단의 텍스트 필드와 추가 버튼 세팅
		addPanel = new Panel();
		field = new TextField(20);
		addPanel.add(field);
		addBtn = new JButton("추가");
		addPanel.add(addBtn);
		add(addPanel);
		
		//윈도우 하단의 라벨 세팅
		bottomLabel = new Label("이 곳에 작업 결과가 표시됩니다");
		bottomLabel.setAlignment(Label.CENTER);
		add(bottomLabel);
		
		//버튼에 ActionListener 지정
		showBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		addBtn.addActionListener(this);
		
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		ActionListenerTest06 frame = new ActionListenerTest06();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("보기")){
			// combo.getSelectedIndex() : 콤보 상자에서 몇 번째 아이템이 선택되었나 얻어온다.
			// combo.getItem() : 콤보 상자에서 index 번째 아이템 레이블을 얻어온다.
			// combo.getSelectedItem() : 콤보 상자에서 선택 된 아이템 레이블을 얻어온다.
			bottomLabel.setText(combo.getSelectedItem());			
		}
		
		if(e.getActionCommand().equals("삭제")){
			if(JOptionPane.showConfirmDialog(this, "정말 삭제 하시겠습니까?", "삭제확인!?", JOptionPane.YES_NO_OPTION) == 0){				
				combo.remove(combo.getSelectedItem());
			}			
		}
		
		if(e.getActionCommand().equals("추가")){
			if(!field.getText().trim().equals("") ){
				combo.add(field.getText());
				// combo.getItemCount() : 콤보 상자의 아이템 목록의 개수를 가져온다.
				combo.select(combo.getItemCount());
			}
			else{
				JOptionPane.showMessageDialog(this, "입력된 내용이 없습니다.");
				field.setText("");
				field.requestFocus();
			}
		}
	}
}
