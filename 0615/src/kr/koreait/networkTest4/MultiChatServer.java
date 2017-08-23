package kr.koreait.networkTest4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiChatServer{
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(1004);
			
			// 서버가 실행된 상태에서 접속되는 모든 접속을 받아줘야 하므로 무한 루프를 돌린다.
			
			while(true){
				Socket socket = serverSocket.accept();
				// 클라이언트가 접속하면 접속한 클라이언트 한 개마다 각각의 스레드를 실행한다.
				// 실제 한 클라이언트로부터 받은 내용을 다른 모든 클라이언트로 보내는 일은 스레드가 처리한다.
				// 스레드를 실행할 때 클라이언트가 접속할 때 마다 생성되는 소켓을 생성자로 넘겨서 생성한다.
				Thread thread = new ChatThread(socket);
				thread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}