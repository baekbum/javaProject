package kr.koreait.polymorphismTest;

class Base {
	
	String name;
	public void say() {
		System.out.println(name + "님 안녕하세요.");
	}
}

class Derived extends Base{
	// Base 클래스의 멤버 변수 name과 메소드 say()를 상속 받았다.
	int age;

	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println(name + "님 " + age + "살 이네요");
	}
	
}

public class UpDownCastingTest {
	public static void main(String[] args) {
		
		//부모 클래스 타입에 부모 클래스 객체를 만들어 대입했으므로 사용가능
		Base base = new Base();
		base.name = "홍길동";
		base.say();
		
		Derived derived = new Derived();
		derived.name = "임꺽정";
		derived.age = 35;
		derived.say();
		
		/*
		//부모가 자식을 제어할 수 있지만 자식이 부모를 제어할 수 없다.
		// 부모 클래스 타입에 자식 클래스 객체를 만들어 대입하면 에러가 발생되지 않는다. => UpCasting
		Base b = new Derived();
		//자식 클래스 타입에 부모 클래스 객체를 만들어 대입하면 에러가 발생된다. => DownCasting
		Derived d = new Base();
		*/
		
		//부모 클래스 타입 b에는 자식 클래스의 객체가 생성된 주소가 저장된다.
		Base b = derived;
		//부모 클래스의 say()가 아닌 부모 클래스 타입이 참조하는 자식 클래스 타입의 say()가 실행된다.
		//이것이 하나의 메소드가 다양하게 실행되는 다형성을 구현하는 기초가 된다.
		b.say();
		
		//자식 클래스 타입에 부모 클래스 객체의 주소를 대입하면 에러가 발생된다.
		//부모 클래스 객체의 주소를 자식 클래스 타입으로 형변환 시켜서 대입하면 문법적인 에러는 발생하지 않지만
		//실행 시켰을 때 ClassCastException이 발생된다.
		//instanceof 연산자 : 연산자 앞의 객체가 연산자 뒤에 클래스로 안전하게 형변환이 되는가 판단한다.
		if(base instanceof Derived){
			Derived d = (Derived) base;
		}
		else{
			System.out.println("부모 클래스를 자식 클래스로 형변환 시킬 수 없습니다.");
		}
		
		try{
			Derived d = (Derived) base;
		}
		catch(ClassCastException e){
			System.out.println("부모 클래스를 자식 클래스로 형변환 시킬 수 없습니다.");
		}
		
	}
}
