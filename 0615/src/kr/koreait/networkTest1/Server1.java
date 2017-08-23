package kr.koreait.networkTest1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
	public static void main(String[] args) {
		ServerSocket server = null; 		// 서버 소켓
		Socket socket = null; 				// 통신 소켓
		Scanner sc = null; 					// 전송 받은 데이터를 읽기 위한 스캐너
		PrintWriter pw = null;				// 데이터를 전송하기 위한 PrintWriter
		
		try {
			// 1004 포트를 열어서 서버 소켓을 생성한다. 서버를 만든다.'
			server = new ServerSocket(1004);
			System.out.println("서버 시작 : " + server);
			System.out.println("클라이언트가 접속할 때까지 기다립니다.");

			// accept() : 클라이언트가 접속할 때까지 무한 대기한다.
			socket = server.accept();
			System.out.println("클라이언트 접속 성공 : " + socket);
			
			// 클라이언트에서 전송한 내용을 읽는다.
			sc = new Scanner(socket.getInputStream());	// 수신된 내용을 읽을 준비
			System.out.println(sc.nextLine());
			
			// 클라이언트로 전송한다.
			pw = new PrintWriter(socket.getOutputStream());
			pw.write("ㅎㅇㅎㅇ");
			pw.flush();
			
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
