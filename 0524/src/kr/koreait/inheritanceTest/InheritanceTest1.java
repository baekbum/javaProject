package kr.koreait.inheritanceTest;

public class InheritanceTest1 {
	public static void main(String[] args) {
		Parent parent1 = new Parent();
		System.out.println(parent1);
		Parent parent2 = new Parent("홍길동", true);
		System.out.println(parent2);
		
		Child child1 = new Child();
		System.out.println(child1);
		Child child2 = new Child("성춘향", false, 16, "이쁜이");
		System.out.println(child2);
	}	
}
