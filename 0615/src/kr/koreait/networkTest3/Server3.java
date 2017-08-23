package kr.koreait.networkTest3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server3 extends JFrame implements ActionListener, Runnable{
	
	JTextArea textArea;		// 채팅 내용이 출력될 영역
	JTextField textField;	// 전송할 내용을 입력할 텍스트 필드
	JButton sendBtn;		// 텍스트 필드에 입력한 내용을 전송할 버튼
	JPanel panel;			// textField와 sendBtn이 올라갈 패널
	
	ServerSocket serverSocket;
	Socket socket;
	Scanner sc;
	PrintWriter pw;
	String msg = ""; 		// textArea에 표시할 문자열을 저장한다.
	
	public Server3(){
		setTitle("server");
		setBounds(800, 50, 500, 600);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// 채팅 창이 닫힐 때 상대방에게 나간다고 알려준다.
				if(pw != null){
					pw.write("나감\n");
					pw.flush();					
				}
				// 채팅 창이 종료될 때 사용한 자원을 닫는다.
				try {
					if(serverSocket != null){
						serverSocket.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				try {
					if(socket != null){
						socket.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				try {
					if(sc != null){
						sc.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				try {
					if(pw != null){
						pw.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				dispose();
			}

			@Override
			// 윈도우가 열릴 때 자동으로 실행되는 메소드
			public void windowActivated(WindowEvent e) {
				textField.requestFocus();
			}			
		});

		// 채팅창 만들기		
		textArea = new JTextArea(10, 50);
		textArea.setBackground(Color.LIGHT_GRAY); // 채팅창의 배경색을 변경한다.
		textArea.setEditable(false); // 채팅 내용을 편집할 수 없게 한다.
		add(textArea); // 채팅 창을 윈도우에 추가한다.
		
		panel = new JPanel(); // 텍스트 필드와 전송 버튼이 올라갈 패널 객체를 생성한다.
		textField = new JTextField(37); // 채팅 내용을 입력할 텍스트 필드 객체를 생성한다.
		panel.add(textField); // 텍스트 필드를 패널에 추가한다.
		sendBtn = new JButton("전송"); // 전송 버튼을 만든다. 
		panel.add(sendBtn); // 전송 버튼을 패널에 추가한다.		
		add(panel, BorderLayout.SOUTH); // 패널을 윈도우에 추가한다.
		
		// textField와 sendBtn에 ActionListener를 구현한다.
		textField.addActionListener(this);
		sendBtn.addActionListener(this);		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Server3 server = new Server3();
		
		try {
			server.msg = "192.168.1.59 서버 1004번 포트로 서버 시작\n클라이언트가 접속하기를 기다립니다\n";
			server.serverSocket = new ServerSocket(1004);
			server.textArea.setText(server.msg + server.textArea.getText());
			
			// 클라이언트가 접속하기 전에는 textField, sendBtn을 비활성화 시킨다.
			server.textField.setEnabled(false);
			server.sendBtn.setEnabled(false);
			
			server.socket = server.serverSocket.accept();
			server.textArea.setText(server.socket +"접속 성공\n" + server.msg);
			
			server.textField.setEnabled(true);
			server.sendBtn.setEnabled(true);
			server.textField.requestFocus();
			
			// 클라이언트가 접속했으므로 통신하기 위해서 Scanner, PrintWriter 객체를 생성한다.
			server.sc = new Scanner(server.socket.getInputStream());
			server.pw = new PrintWriter(server.socket.getOutputStream());
			
			// 클라이언트에서 전송되는 내용을 받는 스레드를 실행한다.
			Thread thread = new Thread(server);
			thread.setDaemon(true);
			thread.start();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String str = "";
		// 클라이언트에서 전송되는 내용을 접속이 종료되기 전까지 무한 반복하며 받는다.
		while(socket != null){				// 소켓이 끊길 때까지 반복
			str = sc.nextLine().trim();		// 클라이언트에서 넘어오는 메시지를 읽는다.
			if(str.length() > 0){
				msg = str + "\n" + msg;
				textArea.setText("Client : " + msg + "\n");
				// 클라이언트 "bye"가 넘어오면 수신을 중지한다.
				if(str.toLowerCase().equals("bye"));{
					break;
				}
			}
		}
		// 클라이언트 창이 닫혔으므로 메시지를 전송할 수 없도록 textField, sendBtn을 비활성화 시킨다.
		textField.setEnabled(false);
		sendBtn.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// textField에서 Enter 키를 누르거나 sendBtn에서 마우스가 클릭되면 클라이언트로 메시지를 전송한다.
		String str = textField.getText().trim();	// textField에 입력된 내용을 받는다.
		if(str.length() > 0){						// textField에 내용이 입력되었나? 확인
			msg =  "server : " + str + "\n" + msg;
			// 서버에서 작성한 메시지를 서버 textArea에 보여준다.
			textArea.setText(msg);
			textField.setText("");		// 다음 메시지를 입력하기 위해 textField를 초기화
			textField.requestFocus();	// 다음 메시지를 입력하기 위해 포커스 이동
			// textField에 입력된 내용을 클라이언트로 전송한다.
			if(pw != null){
				pw.write(str + "\n");
				pw.flush();
			}			
		}
	}
}
