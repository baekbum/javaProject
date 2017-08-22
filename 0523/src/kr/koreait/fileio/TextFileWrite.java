package kr.koreait.fileio;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileWrite {
	public static void main(String[] args) {
		
		PrintWriter pw = null;
		Scanner sc = new Scanner(System.in);
		//경로 지정 방법
		//절대 경로 : 파필이 위치한 디스크 드라이브의 root 디렉토리부터 파일이 위치한 디렉토리까지의 경로
		//상대 경로 : 현재 프로젝트 이름의 디렉토리부터 파일이 위치한 디렉토리까지의 경로 ./src/kr/koreait/fileio/data.txt
		String filename = "C:/Users/Administrator/workspace/0523/src/kr/koreait/fileio/data.txt";
				
		try {
			//파일로 출력하는 객체를 만든다.
			//PrintWriter 클래스 객체는 작업이 완료되면 반드시 close를 시켜줘야 한다.
			pw = new PrintWriter(filename);
			while(true){
				System.out.print("> ");
				String str = sc.nextLine().trim();
				if(str.toLowerCase().equals("quit")){
					break;
				}
				//입력받은 내용을 파일에 저장한다.
				// /r : carriage return 커서를 줄의 맨 앞으로 보낸다.
				pw.write(str + "\r\n");
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			e.printStackTrace();
		}
		finally{
			//PrintWriter 클래스 객체가 생성되었으면 닫아준다.
			if(pw != null){
				try{
					pw.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}				
			}			
		}
	}
}
