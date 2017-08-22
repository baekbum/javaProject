package kr.koreait.collectionTest;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Random;

public class TreeSetTest1 {
	public static void main(String[] args) {
		// TreeSet은 중복되는 데이터의 입력을 허용하지 않는다.
		// 입력되는 데이터 순서와 실제 저장되는 데이터 순서가 일치하지 않는다
		TreeSet<String> ts = new TreeSet<>();
		
		// add(value) : TreeSet에 데이터를 추가한다. 몇 번째 위치에 들어갈지 모른다.
		ts.add("홍길동");
		// size() : TreeSet에 저장된 데이터 개수를 알아온다.
		System.out.println(ts.size() + " : " + ts);
		ts.add("임꺽정");
		System.out.println(ts.size() + " : " + ts);
		ts.add("장길산");
		System.out.println(ts.size() + " : " + ts);
		ts.add("일지매");	
		System.out.println(ts.size() + " : " + ts);
		ts.add("홍길동"); // 중복되는 데이터의 입력을 허용하지 않는다.
		System.out.println(ts.size() + " : " + ts);
		
		// 입력하는 순서와 실제 저장되는 순서가 다르기 때문에 set(), get() 메소드가 없다.
		
		// remove(value) : 괄호 안의 데이터를 TreeSet에서 제거한다.
		ts.remove("장길산");
		System.out.println(ts.size() + " : " + ts);
		
		// iterator() : TreeSet, TreeSet 객체의 데이터를 분리시킨다. 
		Iterator<String> it = ts.iterator();
		ArrayList<String> list = new ArrayList<>();
		// hasNext() : iterator 인터페이스 객체에 다음 데이터가 있으면 true, 없으면 false를 반환
		while(it.hasNext()){
			//System.out.println(it.next());
			list.add(it.next());
		}
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}		
		
		// clear() : TreeSet 객체에 저장된 모든 데이터를 제거한다.
		ts.clear();
		System.out.println(ts.size() + " : " + ts);
		
		// TreeSet를 이용한 로또 번호 생성기
		TreeSet<Integer> lotto = new TreeSet<>();
		Random random = new Random();
		
		do{
			lotto.add(random.nextInt(45) + 1);
		}while(lotto.size() != 6);
		
		System.out.println("1등 번호 " + lotto);		
		
	}
}
