package kr.koreait.collectionTest;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest {
	public static void main(String[] args) {
		
		//Key값에 value를 저장한다.
		HashMap<Integer, String> hmap = new HashMap<>();
		
		//put(key, value) : key에 value를 저장한다.
		hmap.put(1, "홍길동");		
		System.out.println(hmap.size() + " : " + hmap);
		hmap.put(9, "임꺽정");		
		System.out.println(hmap.size() + " : " + hmap);
		hmap.put(5, "장길산");		
		System.out.println(hmap.size() + " : " + hmap);
		hmap.put(2, "일지매");		
		System.out.println(hmap.size() + " : " + hmap);
		
		//이미 존재하는 key에 put 메소드를 실행하면 기존에 저장된 값이 변경된다.
		hmap.put(5, "성춘향");		
		System.out.println(hmap.size() + " : " + hmap);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("키 입력 : ");
		int key = sc.nextInt();
		
		if(hmap.get(key) != null){
			//get(key) : key에 해당되는 value를 얻어온다.
			System.out.println(hmap.get(key));
		}
		else{
			System.out.println("키 없음");
		}
		
		hmap.remove(5);
		System.out.println(hmap.size() + " : " + hmap);
		hmap.clear();
		System.out.println(hmap.size() + " : " + hmap);
	}	
}
