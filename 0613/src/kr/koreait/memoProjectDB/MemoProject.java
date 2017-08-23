package kr.koreait.memoProjectDB;

import java.util.Scanner;

public class MemoProject {
	public static void main(String[] args) {
		int menu = 0;
		Scanner sc = new Scanner(System.in);	
		
		while(menu != 5){
			do{
				System.out.println("=================================");
				System.out.println("1.쓰기 2.보기 3.수정. 4.삭제 5.종료 ");
				System.out.println("=================================");
				System.out.println("원하는 메뉴를 선택하세요 : ");
				menu = sc.nextInt();
				
				switch(menu){
				case 1:
					MemoDAO.insert();
					break;
				case 2:
					MemoDAO.select();
					break;
				case 3:
					MemoDAO.update();
					break;
				case 4:
					MemoDAO.delete();
					break;
					
				}
			} while(menu < 1 && menu > 5);
		}
		
		
	}
}
