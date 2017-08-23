package kr.koreait.networkTest1;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client1 {
	public static void main(String[] args) {
		
		Socket socket = null; 
		Scanner sc = null;
		PrintWriter pw = null;
		
		
		try {
			System.out.println("192.168.1.59 서버의 1004번 포트로 접속 시도");
			// socket(host, port) : host -> 서버의 ip주소, port : 서버의 포트 번호
			socket = new Socket("192.168.1.59", 1004);
			System.out.println("접속 성공 : " + socket);
			
			// 서버로 전송한다.
			pw = new PrintWriter(socket.getOutputStream()); // 전송 준비
			pw.write("안녕하세요\n");						// 서버로 전송한다.
			
			// flush() : 출력 버퍼가 가득차지 않았더라도 출력 버퍼의 내용을 전송한다.
			pw.flush();
			
			// 서버에서 전송한 내용을 읽는다.
			sc = new Scanner(socket.getInputStream());
			System.out.println(sc.nextLine());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {			
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
