import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CountGame extends JFrame implements Runnable, ActionListener {

	static btnFunc btnfunc = new btnFunc();
	static int boom = 5000; // 스레드를 통해 숫자가 0되면 다음 눌러야할 숫자가 빨간색으로 변한다
	static int shit = 7000; // 스레드를 통해 4라운드 이후부터 숫자가 0이되면 클리어를 방해한다.

	static int cho = 0; // 찬스 혹은 잘못된 숫자를 클릭했을때 rTime Lable 색상이 변하는 시간을 결정하는 변수
	static int flag = 1; // 색상을 결정하는 변수 1=검정, 2=분홍, 3=파랑
	static double point = 0.0; // 점수 합

	static double pointBonus = 1.0; // 버튼을 연속적으로 맞출경우 쌓이는 누계점수
	static long bonus; // 보너스 시간 변수
	static int size = 3;

	static JButton[] btn;
	static JPanel centerP, LlowP, RlowP, timeP, BotP, bigBotP;
	static GraphP energeP;
	static JButton startBtn = new JButton("시작");
	static JButton chanceBtn = new JButton("찬스");
	static JButton rankBtn = new JButton("랭킹");
	static JLabel timela = new JLabel("남은시간   : ");
	JLabel inputNick = new JLabel("닉네임 : ");
	static JLabel rTime = new JLabel("");
	static JLabel chancela = new JLabel("     찬스 : ");
	static JLabel chanceNum = new JLabel("3");
	static int countCheck;
	static long start = 0;
	static long end = 0;
	static boolean count;
	static Thread thread;
	Random random = new Random();
	static CountGame frame;
	static long time;
	static int round = 0;
	static int chance = 3; // 찬스 변수

	static int combo = 0; // 콤보10이면 찬스추가

	static JButton nameBtn = new JButton(new ImageIcon("./src/입력버튼.png"));
	static JTextField nickField = new JTextField(17);
	static JPanel textP;
	static JPanel p;
	static JPanel p2;
	static boolean checkflag = false;

	static GridBagConstraints con;
	static GridBagLayout gridbag = new GridBagLayout();
	ImageIcon background = new ImageIcon("./src/숫자_테스트.png");

	ResultSet rs;
	static String nickName = "";

	public CountGame(int size) {
		this.size = size;
		setTitle("Count Game");
		setBounds(800, 50, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		textP = new JPanel(gridbag) {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), -8, -18, null);
			}
		};

		con = new GridBagConstraints();
		con.fill = GridBagConstraints.BOTH;
		con.weightx = 1.0;
		con.weighty = 1.0;

		/*
		 * gridbag.setConstraints(inputNick, con);
		 * gridbag.setConstraints(nickField, con);
		 * gridbag.setConstraints(nameBtn, con);
		 */

		nameBtn.setName("inputButton");
		nameBtn.setBorderPainted(false);
		nameBtn.setContentAreaFilled(false);
		// nameBtn.setFocusPainted(false);

		addCom(inputNick, 0, 0, 2, 1);
		addCom(nickField, 2, 0, 2, 1);
		addCom(nameBtn, 4, 0, 1, 1);

		nickField.setFont(new Font("Dialog", Font.PLAIN, 20));
		nickField.setHorizontalAlignment(JTextField.CENTER);
		inputNick.setFont(new Font("한컴", Font.BOLD, 15));
		inputNick.setHorizontalAlignment(JLabel.CENTER);

		add(textP);
		nameBtn.addActionListener(this);
		setVisible(true);
	}

	public void addCom(Component c, int x, int y, int w, int h) {
		con.gridx = x;
		con.gridy = y;
		con.gridwidth = w;
		con.gridheight = h;
		textP.add(c);
	}

	public static void main(String[] args) {

		frame = new CountGame(size);
	}

	boolean error = false;

	@Override
	public void run() {

		SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");

		if (start == 0) { // run()이 처음 호출 됐을 때
			start = System.currentTimeMillis(); // 현재 시간을 넣어준다.
			end = start;
		}

		while (count) {
			threadFunc.threadF();

			GraphP.xPos = (int) Double.parseDouble(rTime.getText());
			if (time <= -32400000 / 2) {
				threadFunc.threadexit();
				start = 0;
				break;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			energeP.repaint();
		}
	}

	// 버튼에 숫자 올리기 메소드
	public void setBtn(int size) {
		btnfunc.btnSet(size);
		for (int i = 0; i < size * size; i++) {
			btn[i].addActionListener(this);
		}
	}

	// 버튼 섞기 메소드
	public static void mixBtn() {
		btnfunc.btnMix();
	}

	// 버튼 윈도우에 올리기 메소드
	public void addBtn(int size) {
		btnfunc.btnAdd(size);
		add(centerP, BorderLayout.CENTER);
	}

	static boolean black;

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton btn2 = (JButton) obj;

		if (obj.equals(nameBtn)) {
			if (!nickField.getText().trim().equals("")) {
				nickName = nickField.getText().trim();
				nickName = nickNameInput.nickCheck(nickName, startBtn);

				if (checkflag) {
					remove(textP);
					setBounds(800, 50, 700, 700);
					btn = new JButton[size * size];
					centerP = new JPanel(new GridLayout(size, size));
					setBtn(size); // 버튼에 숫자 올리기 메소드
					addBtn(size); // 버튼 윈도우에 올리기 메소드

					inputFunc.convert(size);

					add(centerP, BorderLayout.CENTER);
					add(bigBotP, BorderLayout.SOUTH);

					startBtn.setEnabled(true);

					startBtn.addActionListener(this);
					chanceBtn.addActionListener(this);
					rankBtn.addActionListener(this);

					setVisible(true);
				}
			} else {
				JOptionPane.showMessageDialog(this, "닉네임 공백!");
				nickField.requestFocus();
			}
		}

		if (e.getActionCommand().equals("시작")) {
			startFunc.start1();

			mixBtn();
			addBtn(size);

			startFunc.start2();
			flag = 1;
			thread = new Thread(frame);
			count = true;
			thread.start();
		}

		if (e.getActionCommand().equals("찬스")) {
			chanceFunc.chance();
		}

		if (e.getActionCommand().equals("랭킹")) {
			rankFunc.rank();
		}

		if (e.getActionCommand().equals(String.valueOf(countCheck + 1))) {
			btn2.setEnabled(false);
			btn2.setVisible(false);
			btnEqual.Equal1();

			if (countCheck == btn.length) {
				btnEqual.Equal2();
				setBtn(size);
				mixBtn();
				addBtn(size);
				; // 버튼 윈도우에 올리기 메소드

			}

			// if(countCheck!=0&&countCheck%10==0){
			if (combo != 0 && combo % 10 == 0) {
				combo = 0;
				if (chance < 3) {
					chance++;
					chanceBtn.setEnabled(true);
					chanceNum.setText(String.valueOf(chance));
				}
			}

		} else {
			combo = 0;
			// 틀리면 시간 2초 감소
			if (!(e.getActionCommand().equals("시작")) && !(e.getActionCommand().equals("찬스"))) {
				cho = 700;
				flag = 2;
				end -= 2000;
			}
			pointBonus -= pointBonus > 1.9 ? 1.0 : 0.0;
		}
	}
}