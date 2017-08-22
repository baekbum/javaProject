package kr.koreait.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileRead {
	public static void main(String[] args) {
		Scanner sc = null; // 파일에서 읽어들이는 스캐너
		
		String filename = "C:/Users/Administrator/workspace/0523/src/kr/koreait/fileio/data.txt";
		// 파일에서 입력받는 객체를 만든다.
		// 파일에서 읽어오는 스캐너를 만드려면 읽어올 파일의 객체를 Scanner의 생성자로 넘겨줘야 한다.
		try{
			sc = new Scanner(new File(filename));
			//파일의 끝까지 반복하며 파일의 내용을 읽어온다.
			//hasNextLine() : 스캐너로 읽어들일 다음 줄이 있으면 true 없으면 false를 리턴한다.
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			
		}
		catch (FileNotFoundException e){
			System.out.println("파일이 없습니다.");			
		}
		finally{
			if(sc != null){
				try{
					sc.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}				
			}			
		}
		
	}
}
