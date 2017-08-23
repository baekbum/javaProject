package kr.koreait.actionListenerTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PuzzleActionListener extends JFrame implements ActionListener{
	
	JButton[] button = new JButton[16];
	//String[] number = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
	JButton mix = new JButton("섞기");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	Random random = new Random();
	
	public PuzzleActionListener() {
		this("퍼즐");
	}
	
	public PuzzleActionListener(String title) {		
		BorderLayout border = new BorderLayout();
		GridLayout Puzzle = new GridLayout(4, 4);
		GridLayout mixpanel = new GridLayout(1, 1);
		setTitle(title);
		setBounds(800, 50, 400, 500);
		setLayout(border);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//버튼 값 넣고 패널1에 버튼 추가
		for(int i=1; i<=button.length; i++){
			String str = i + "";
			button[i-1] = new JButton(str);
			button[i-1].addActionListener(this);
			panel1.add(button[i-1]);
		}
		// 인덱스 15번째 버튼 안보이게
		button[15].setVisible(false);
		
		// 패널1 크기 조절 및 프레임에 추가
		panel1.setPreferredSize(new Dimension(400, 400));
		panel1.setLayout(Puzzle);		
		
		// 패널1 크기 조절 및 프레임 및 버튼 추가
		panel2.setPreferredSize(new Dimension(400, 63));
		panel2.setLayout(mixpanel);		
		panel2.add(mix);
		
		// 섞기 버튼 클릭시 이벤트
		mix.addActionListener(this);
		
		// 패널 1, 2를 지정한 레이아웃 위치에 추가
		add(panel1, BorderLayout.NORTH);
		add(panel2,  BorderLayout.SOUTH);
		
		setVisible(true);
	}	
	
	public static void main(String[] args) {
		PuzzleActionListener frame = new PuzzleActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getActionCommand();
		
		if(obj.equals("섞기")){
			// 기존 패널에 있던 컴포넌트 모두 삭제
			panel1.removeAll();
			
			// 버튼 위치 변경
			for(int i=0; i<1000; i++){					
				int r = random.nextInt(15)+1;
				JButton temp = button[0];
				button[0] = button[r];
				button[r] = temp;
			}
			// 바뀐 버튼 다시 패널에 추가
			for(int i=0; i<button.length; i++){
				panel1.add(button[i]);
			}
			// 좌표 계산 후 다시 표시
			revalidate();
		}
		
		// 몇 번째 버튼이 클릭되었나 알아낸다.
		
			
		if(!obj.equals("섞기")){
			int i = 0;
			for(i=1; i<button.length; i++){
				if(obj.equals(button[i].getActionCommand())){
					break;
				}
			}
			
			//System.out.println(button[15].getActionCommand());
			//System.out.println(i +"+"+ button[i].getActionCommand());
			
			// 현재 클릭된 버튼 왼쪽이 비어있나 검사해서 비어있으면 자리를 바꾼다
			if(i % 4 != 0){
				if(button[i-1].getActionCommand().equals("16")){
					
					JButton temp = button[i];
					button[i] = button[i-1];
					button[i-1] = temp;
					
					panel1.removeAll();
					for(int j=0; i<button.length; j++){
						panel1.add(button[j]);
					}
						
					revalidate();
				}			
			}
			
			// 현재 클릭된 버튼 오른쪽이 비어있나 검사해서 비어있으면 자리를 바꾼다
			if(i % 4 != 3){
				if(button[i+1].getActionCommand().equals("16")){
					
					JButton temp = button[i];
					button[i] = button[i+1];
					button[i+1] = temp;
					
					panel1.removeAll();
					for(int j=0; i<button.length; j++){
						panel1.add(button[j]);
					}
						
					revalidate();
				}			
			}
			
			// 현재 클릭된 버튼 위쪽이 비어있나 검사해서 비어있으면 자리를 바꾼다
			if(i / 4 != 0){
				if(button[i-4].getActionCommand().equals("16")){
					
					JButton temp = button[i];
					button[i] = button[i-4];
					button[i-4] = temp;
					
					panel1.removeAll();
					for(int j=0; i<button.length; j++){
						panel1.add(button[j]);
					}
						
					revalidate();
				}			
			}
			
			// 현재 클릭된 버튼 아래쪽이 비어있나 검사해서 비어있으면 자리를 바꾼다
			if(i / 4 != 3){
				if(button[i+4].getActionCommand().equals("16")){
					
					JButton temp = button[i];
					button[i] = button[i+4];
					button[i+4] = temp;
					
					panel1.removeAll();
					for(int j=0; i<button.length; j++){
						panel1.add(button[j]);
					}
						
					revalidate();
				}				
			}
			
			//퍼즐이 맞춰졌나 검사한다.
			int count = 0;
			for(int j=0; j<button.length; j++){
				if(button[j].getActionCommand().equals((j+1)+"")){
					count++;
				}
			}
			
			if(count == 16){
				JOptionPane.showMessageDialog(panel1, "맞췄다.");
			}
		}		
	}
}
