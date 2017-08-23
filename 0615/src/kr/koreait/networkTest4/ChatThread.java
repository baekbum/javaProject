package kr.koreait.networkTest4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatThread extends Thread {
	
	// 모든 접속자의 목록을 가지고 있어야 입력한 내용을 모든 클라이언트로 전송할 수 있다.
	// 모든 접속자 목록은 모든 사용자가 공유해야 하므로 정적 멤버로 만들어야 한다.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket = null;
	PrintWriter pw = null;
	
	public ChatThread() {}
	public ChatThread(Socket socket) {
		this.socket = socket;
		try {
			pw = new PrintWriter(socket.getOutputStream()); // 출력 스트림을 만든다.
			list.add(pw);									// 출력 스트림을 리스트에 저장한다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
		String name = ""; // 대화명을 저장해둘 변수
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			name = reader.readLine(); // 첫 줄을 읽어서 대화명으로 사용한다.
			
			// 접속자 정보를 모든 클라이언트로 전송한다.
			for(PrintWriter writer : list){
				writer.println("#" + name + "님이 접속하셨습니다.");
				writer.flush();
			}
			// 두 번째 줄부터는 채팅 메시지이므로 접속이 종료될 때까지 반복하며 출력시켜준다.
			while(true){
				String str = reader.readLine();
				if(str == null){
					break;
				}
				for(PrintWriter writer : list){
					writer.println(name + " >> " + str);
					writer.flush();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 채팅 창을 닫았으므로 채팅 목록에서 제거한다.
			list.remove(pw);
			for(PrintWriter writer : list){
				writer.println("#" + name + "님이 나가셨습니다.");
				writer.flush();
			}
			// 채팅 창을 닫았으므로 통신 소켓을 제거한다.
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
