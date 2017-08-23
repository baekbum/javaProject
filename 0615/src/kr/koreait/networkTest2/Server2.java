package kr.koreait.networkTest2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		Scanner sc = null;			// 키보드로 입력한 내용을 읽는 스캐너
		Scanner scan = null;		// 전송받은 내용을 읽는 스캐너
		PrintWriter pw = null;		
		
		try {
			server = new ServerSocket(1004);
			System.out.println("server start " + server);
			
			System.out.println("클라이언트의 접속을 기다립니다.");
			socket = server.accept();
			
			// 통신에 사용할 나머지 객체를 선언한다.
			sc = new Scanner(System.in);
			scan = new Scanner(socket.getInputStream());
			pw = new PrintWriter(socket.getOutputStream());
			
			String msg = "";
			// 키보드로 입력한 내용이 "BYE"이거나 서버로부터 전송받은 내용이 "BYE"면 통신을 끝낸다.
			do {
				// 클라이언트로부터 전송받은 내용을 읽는다.
				msg = scan.nextLine();
				System.out.print("클라이언트 : " + msg);
				
				// 클라이언트로 전송할 내용을 입력한다.				
				System.out.print("서버 : ");
				msg = sc.nextLine().trim();
				
				// 키보드로 입력한 내용이 "BYE"면 통신을 종료한다.
				if(msg.toUpperCase().equals("BYE")){
					break;
				}
				
				// 입력한 내용을 클라이언트로 전송한다.
				pw.write(msg + "\n");
				pw.flush();
				
				
			}while(!msg.toUpperCase().equals("BYE"));			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(server != null){
					server.close();
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
		}
	}
}
