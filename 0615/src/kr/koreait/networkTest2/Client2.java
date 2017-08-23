package kr.koreait.networkTest2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
	public static void main(String[] args) {
		Socket socket = null;
		Scanner sc = null;			
		Scanner scan = null;
		PrintWriter pw = null;	
		
		try {
			socket = new Socket("192.168.1.59", 1004);
			sc = new Scanner(System.in);
			scan = new Scanner(socket.getInputStream());
			pw = new PrintWriter(socket.getOutputStream());
			
			String msg = "";
			do {
				// 서버로 전송할 내용을 입력한다.
				System.out.print("클라이언트 : ");
				msg = sc.nextLine().trim();
				
				// 입력한 내용을 서버로 전송한다.
				pw.write(msg + "\n");
				pw.flush();
				
				// 키보드로 입력한 내용이 "BYE"면 통신을 종료한다.
				if(msg.toUpperCase().equals("BYE")){
					break;
				}
				
				// 서버로 부터 전송받은 내용을 읽는다.
				msg = scan.nextLine();
				System.out.print("서버 : " + msg);
				
			}while(!msg.toUpperCase().equals("BYE"));		
			
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
