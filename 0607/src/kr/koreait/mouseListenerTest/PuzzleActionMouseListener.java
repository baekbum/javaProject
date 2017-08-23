package kr.koreait.mouseListenerTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PuzzleActionMouseListener extends JFrame implements MouseListener {

	JButton button = new JButton("섞기");
	JButton[] btn = new JButton[16];
	String[] number = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
	Random random = new Random();
	JPanel btnPanel = new JPanel(new GridLayout(4, 4, 3, 3));
	
	public PuzzleActionMouseListener() {
		setTitle("PuzzleGame");
		setBounds(800, 50, 400, 450);
		
		for(int i=0 ; i<btn.length ; i++) {
			btn[i] = new JButton(number[i]);
			btn[i].setFont(new Font("Dialog", Font.BOLD, 40));
			btn[i].addMouseListener(this);
			btn[i].setName(number[i]);				// 버튼에 이름을 붙인다.
			btnPanel.add(btn[i]);
			if(btn[i].getActionCommand().equals("16")) {
				btn[i].setVisible(false);
			}
		}
		add(btnPanel);
		
		button.setFont(new Font("Dialog", Font.BOLD, 30));
		button.setPreferredSize(new Dimension(400, 50));
		button.setName("섞기");
		add(button, BorderLayout.SOUTH);
		button.addMouseListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		PuzzleActionMouseListener frame = new PuzzleActionMouseListener();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		Object obj = e.getSource();
		if(((JButton)obj).getName().equals("섞기")) {
			for(int i=0 ; i<1000000 ; i++) {
				int r = random.nextInt(15) + 1;
				String temp = number[0];
				number[0] = number[r];
				number[r] = temp;
			}
			for(int i=0 ; i<btn.length ; i++) {
				btn[i].setVisible(true);
				btnPanel.remove(btn[i]);
			}
			for(int i=0 ; i<btn.length ; i++) {
				btn[i] = new JButton(number[i]);
				btn[i].setFont(new Font("Dialog", Font.BOLD, 40));
				btn[i].addMouseListener(this);
				btn[i].setName(number[i]);				// 버튼에 이름을 붙인다.
				btnPanel.add(btn[i]);
				if(btn[i].getActionCommand().equals("16")) {
					btn[i].setVisible(false);
				}
			}
			add(btnPanel);
			revalidate();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		Object obj = e.getSource();
		if(!((JButton)obj).getName().equals("섞기")) {
			int i;
			for(i=0 ; i<btn.length ; i++) {
				if(((JButton)obj).getName().equals(btn[i].getName())) {
					break;
				}
			}
			System.out.println(i);

			if(i % 4 != 0) {
				if(btn[i - 1].getActionCommand().equals("16")) {
					String temp = number[i];
					number[i] = number[i - 1];
					number[i - 1] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i - 1];
					btn[i - 1] = tempBtn;
				}
			}
			
			if(i % 4 != 3) {
				if(btn[i + 1].getActionCommand().equals("16")) {
					String temp = number[i];
					number[i] = number[i + 1];
					number[i + 1] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i + 1];
					btn[i + 1] = tempBtn;
				}
			}
			
			if(i / 4 != 0) {
				if(btn[i - 4].getActionCommand().equals("16")) {
					String temp = number[i];
					number[i] = number[i - 4];
					number[i - 4] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i - 4];
					btn[i - 4] = tempBtn;
				}
			}
			
			if(i / 4 != 3) {
				if(btn[i + 4].getActionCommand().equals("16")) {
					String temp = number[i];
					number[i] = number[i + 4];
					number[i + 4] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i + 4];
					btn[i + 4] = tempBtn;
				}
			}			
			
			for(i=0 ; i<btn.length ; i++) {
				btn[i].setVisible(true);
				btnPanel.remove(btn[i]);
			}
			
			for(i=0 ; i<btn.length ; i++) {
				btn[i] = new JButton(number[i]);
				btn[i].setFont(new Font("Dialog", Font.BOLD, 40));
				btn[i].addMouseListener(this);
				btn[i].setName(number[i]);				// 버튼에 이름을 붙인다.
				btnPanel.add(btn[i]);
				if(btn[i].getActionCommand().equals("16")) {
					btn[i].setVisible(false);
				}
			}
			add(btnPanel);
			
			revalidate();
			
			int count = 0;
			for(i=0 ; i<btn.length ; i++) {
				if(btn[i].getActionCommand().equals(i + 1 + "")) {
					count++;
				}
			}
			if(count == 16) {
				JOptionPane.showMessageDialog(btnPanel, "맞췄다");
				count = 0;
			}
			
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) { }
	@Override
	public void mousePressed(MouseEvent e) { }
	@Override
	public void mouseReleased(MouseEvent e) { }

}










