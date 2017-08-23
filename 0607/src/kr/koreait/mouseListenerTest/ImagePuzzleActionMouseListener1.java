package kr.koreait.mouseListenerTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagePuzzleActionMouseListener1 extends JFrame implements MouseListener {

	JButton button = new JButton("섞기");	
	JButton[] btn = new JButton[16];
	String[] number = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
	Random random = new Random();
	JPanel btnPanel = new JPanel(new GridLayout(4, 4, 3, 3));
	Image[] image = new Image[16];
	
	public ImagePuzzleActionMouseListener1() {
		setTitle("PuzzleGame");
		setBounds(800, 50, 400, 450);
		
		String filename = "";
		String[] game = {"인형","도라에몽","미니언즈","숫자","피카츄","호랑이"};
		String menu =(String) JOptionPane.showInputDialog(btnPanel, "원하는 그림을 선택하세요", "그림 선택", JOptionPane.PLAIN_MESSAGE, new ImageIcon("./src/mini/original.jpg"), game, "숫자");
		
		for(int i=0; i<image.length; i++){
			switch(menu){
			case "인형" : filename = String.format("./src/doll/%02d/jpg", i+1); break;
			case "도라에몽" : filename = String.format("./src/hero/%02d/jpg", i+1); break;
			case "미니언즈" : filename = String.format("./src/mini/%02d/jpg", i+1); break;
			case "숫자" : filename = String.format("./src/number/%02d/jpg", i+1); break;
			case "피카츄" : filename = String.format("./src/pika/%02d/jpg", i+1); break;
			case "호랑이" : filename = String.format("./src/tiger/%02d/jpg", i+1); break;
			}			
			image[i] = Toolkit.getDefaultToolkit().getImage(filename);
		}
		
		addImage();
		add(btnPanel);
		
		button.setFont(new Font("Dialog", Font.BOLD, 30));
		button.setPreferredSize(new Dimension(400, 50));
		button.setName("섞기");
		
		add(button, BorderLayout.SOUTH);
		button.addMouseListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addImage() {
		for(int i=0 ; i<btn.length ; i++) {
			btn[i] = new JButton(new ImageIcon(image[i]));
			btn[i].setFont(new Font("Dialog", Font.BOLD, 40));
			btn[i].addMouseListener(this);
			btn[i].setName(number[i]);				// 버튼에 이름을 붙인다.
			btnPanel.add(btn[i]);
			if(btn[i].getName().equals("16")) {
				btn[i].setVisible(false);
			}
		}
	}
	
	public static void main(String[] args) {
		
		ImagePuzzleActionMouseListener1 frame = new ImagePuzzleActionMouseListener1();
		
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
				Image images = image[0];
				image[0] = image[r];
				image[r] = images;
			}
			for(int i=0 ; i<btn.length ; i++) {
				btn[i].setVisible(true);
				btnPanel.remove(btn[i]);
			}
			addImage();
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
				if(btn[i - 1].getName().equals("16")) {
					String temp = number[i];
					number[i] = number[i - 1];
					number[i - 1] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i - 1];
					btn[i - 1] = tempBtn;
					Image images = image[i];
					image[i] = image[i - 1];
					image[i - 1] = images;					
				}
			}
			
			if(i % 4 != 3) {
				if(btn[i + 1].getName().equals("16")) {
					String temp = number[i];
					number[i] = number[i + 1];
					number[i + 1] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i + 1];
					btn[i + 1] = tempBtn;
					Image images = image[i];
					image[i] = image[i + 1];
					image[i + 1] = images;
				}
			}
			
			if(i / 4 != 0) {
				if(btn[i - 4].getName().equals("16")) {
					String temp = number[i];
					number[i] = number[i - 4];
					number[i - 4] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i - 4];
					btn[i - 4] = tempBtn;
					Image images = image[i];
					image[i] = image[i - 4];
					image[i - 4] = images;
				}
			}
			
			if(i / 4 != 3) {
				if(btn[i + 4].getName().equals("16")) {
					String temp = number[i];
					number[i] = number[i + 4];
					number[i + 4] = temp;
					JButton tempBtn = btn[i];
					btn[i] = btn[i + 4];
					btn[i + 4] = tempBtn;
					Image images = image[i];
					image[i] = image[i - 4];
					image[i - 4] = images;
				}
			}			
			
			for(i=0 ; i<btn.length ; i++) {
				btn[i].setVisible(true);
				btnPanel.remove(btn[i]);
			}
			
			for(i=0 ; i<btn.length ; i++) {
				btn[i] = new JButton(new ImageIcon(image[i]));
				btn[i].setFont(new Font("Dialog", Font.BOLD, 40));
				btn[i].addMouseListener(this);
				btn[i].setName(number[i]);				// 버튼에 이름을 붙인다.
				btnPanel.add(btn[i]);
				if(btn[i].getName().equals("16")) {
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










