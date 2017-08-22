package kr.koreait.collectionTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class HashSetTest1 {
	public static void main(String[] args) {
		// HashSet은 중복되는 데이터의 입력을 허용하지 않는다.
		// 입력되는 데이터 순서와 실제 저장되는 데이터 순서가 일치하지 않는다
		HashSet<String> hs = new HashSet<>();
		
		// add(value) : HashSet에 데이터를 추가한다. 몇 번째 위치에 들어갈지 모른다.
		hs.add("홍길동");
		// size() : HashSet에 저장된 데이터 개수를 알아온다.
		System.out.println(hs.size() + " : " + hs);
		hs.add("임꺽정");
		System.out.println(hs.size() + " : " + hs);
		hs.add("장길산");
		System.out.println(hs.size() + " : " + hs);
		hs.add("일지매");	
		System.out.println(hs.size() + " : " + hs);
		hs.add("홍길동"); // 중복되는 데이터의 입력을 허용하지 않는다.
		System.out.println(hs.size() + " : " + hs);
		
		// 입력하는 순서와 실제 저장되는 순서가 다르기 때문에 set(), get() 메소드가 없다.
		
		// remove(value) : 괄호 안의 데이터를 HashSet에서 제거한다.
		hs.remove("장길산");
		System.out.println(hs.size() + " : " + hs);
		
		// iterator() : HashSet, TreeSet 객체의 데이터를 분리시킨다. 
		Iterator<String> it = hs.iterator();
		ArrayList<String> list = new ArrayList<>();
		// hasNext() : iterator 인터페이스 객체에 다음 데이터가 있으면 true, 없으면 false를 반환
		while(it.hasNext()){
			//System.out.println(it.next());
			list.add(it.next());
		}
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}		
		
		// clear() : HashSet 객체에 저장된 모든 데이터를 제거한다.
		hs.clear();
		System.out.println(hs.size() + " : " + hs);
		
		// HashSet를 이용한 로또 번호 생성기
		HashSet<Integer> lotto = new HashSet<>();
		Random random = new Random();
		
		do{
			lotto.add(random.nextInt(45) + 1);
		}while(lotto.size() != 6);
		
		System.out.println("1등 번호 " + lotto);		
		
	}
}
