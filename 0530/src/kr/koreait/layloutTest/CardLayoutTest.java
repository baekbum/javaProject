package kr.koreait.layloutTest;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 컨테이너에 카드를 여러장 엎어놓은 것처럼 배치하는 레이아웃 매너지 이다.
// CardLayout은 JFrame에서 작동x Frame를 사용해야한다.
public class CardLayoutTest extends Frame implements Runnable {
	
	Label label1 = new Label("1");
	Label label2 = new Label("2");
	Label label3 = new Label("3");
	Label[] labels = {};
	
	public CardLayoutTest() {
		this("제목 없는 윈도우");
	}
	
	public CardLayoutTest(String title) {
		setTitle(title);
		setBounds(800, 50, 400, 400);
	
		CardLayout card = new CardLayout();
		setLayout(card);
		
		Font font = new Font("Dialog", Font.BOLD, 200);
		label1.setBackground(Color.YELLOW);
		label1.setFont(font);
		label1.setAlignment(Label.CENTER);
		
		label2.setBackground(Color.GREEN);
		label2.setFont(font);
		label2.setAlignment(Label.CENTER);
		
		label3.setBackground(Color.CYAN);
		label3.setFont(font);
		label3.setAlignment(Label.CENTER);
		
		// CardLayout에 컴포넌트를 추가할 때는 반드시 카드 이름을 붙여서 추가시켜야 한다.
		// add("카드 이름", 컴포넌트);		
		add("1",label1);
		add("2",label2);
		add("3",label3);
		
		//카드레이아웃이름.show(this, "카드 이름")
		card.show(this, "2");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}			
		});
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
			
	public static void main(String[] args) {
		CardLayoutTest frame = new CardLayoutTest("CardLayoutTest");
		Thread thread = new Thread(frame);
		thread.start();
	}

	@Override
	public void run() {
		for(int i=0; i<20; i++){
			labels[i] = new Label(" + i + ");
			add("+i+", labels[i]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}		
	}
}
