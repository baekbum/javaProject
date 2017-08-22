package kr.koreait.collectionTest;

import java.util.TreeSet;

public class TreeSetTest2 {
	public static void main(String[] args) {
		
		TreeSet<Person> ts = new TreeSet<>();
		
		Person person1 = new Person("이성계", 58);
		ts.add(person1);
		System.out.println(ts.size() + " : " + ts);
		
		// new를 사용해 객체를 생성하면 같은 내용의 객체가 이미 생성되어있나 확인하는 절차없이 객체를 만들고
		// new를 사용해 객체를 생성하면 새로운 HashCode가 부여된다. => 같은 객체 인가 다른 객체인가 비교를
		// HashCode를 사용해서 비교하므로 내용이 같더라도 다른 HashCode가 부여되면 다른 객체로 취급한게 된다.
		// new를 사용해 생성한 객체가 내용이 같으면 같은 hashCode를 가지게 하면 이와 같이 내용이 같더라도 다른
		// 객체로 취급하는 현상이 해결된다. => hashCode(), equals()를 override 시킨다.
		
		// TreeSet은 Hash과 달리 저장되는 내용을 정렬시켜야 하므로 저장할 클래스에 Comparable 인터페이스를
		// 구현하고 compareTo() 메소드를 override 시켜서 정렬한다.
		
		Person person2 = new Person("이성계", 58);
		ts.add(person2);
		System.out.println(ts.size() + " : " + ts);
		
		Person person3 = new Person("이성계", 78);
		ts.add(person3);
		System.out.println(ts.size() + " : " + ts);
		
		Person person4 = new Person("이방원", 35);
		ts.add(person4);
		System.out.println(ts.size() + " : " + ts);
		
		Person person5 = new Person("고주몽", 38);
		ts.add(person5);
		System.out.println(ts.size() + " : " + ts);
		
		Person person6 = new Person("김선덕", 20);
		ts.add(person6);
		System.out.println(ts.size() + " : " + ts);
	}
}
