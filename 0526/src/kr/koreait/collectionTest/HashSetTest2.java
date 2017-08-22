package kr.koreait.collectionTest;

import java.util.HashSet;

public class HashSetTest2 {
	public static void main(String[] args) {
		
		HashSet<Person> hs = new HashSet<>();
		
		Person person1 = new Person("이성계", 58);
		hs.add(person1);
		System.out.println(hs.size() + " : " + hs);
		
		// new를 사용해 객체를 생성하면 같은 내용의 객체가 이미 생성되어있나 확인하는 절차없이 객체를 만들고
		// new를 사용해 객체를 생성하면 새로운 HashCode가 부여된다. => 같은 객체 인가 다른 객체인가 비교를
		// HashCode를 사용해서 비교하므로 내용이 같더라도 다른 HashCode가 부여되면 다른 객체로 취급한게 된다.
		// new를 사용해 생성한 객체가 내용이 같으면 같은 hashCode를 가지게 하면 이와 같이 내용이 같더라도 처리 가능
		
		Person person2 = new Person("이성계", 58);
		hs.add(person2);
		System.out.println(hs.size() + " : " + hs);
		
		Person person3 = new Person("이성계", 78);
		hs.add(person3);
		System.out.println(hs.size() + " : " + hs);
		
		Person person4 = new Person("이성계", 35);
		hs.add(person4);
		System.out.println(hs.size() + " : " + hs);
		
		Person person5 = new Person("이성계", 35);
		hs.add(person5);
		System.out.println(hs.size() + " : " + hs);
	}
}
