package kr.koreait.interfaceTest;

class Point {
	int x,y;
	public void move() {}
}

class Shape {
	//멤버 변수 앞에 final이 붙으면 그 변수는 프로그램에서 값을 변경할 수 없다. => 상수
	public static final double PI = 3.141592; 
	public void draw() {}
	public void erase() {}
}

//자바는 다중 상속을 지원하지 않는다.
//인터페이스는 stasic(정적) 멤버 변수와 추상 메소드로만 구성된 클래스의 특별한 형태이다.
//자바는 다중 상속이 불가능하므로 다중 상속을 피해서 여러 개의 클래스를 상속받는 효과를 내기위해 인터페이스를
//사용하고 인터페이스도 부모로 인정받기 때문에 다형성을 구현할 수 있다.
interface Draw {
	public static final double PI = 3.14159265;
	//멤버 변수 선언 시 아래와 같이 앞의 내용을 생략하면 자동으로 public static final를 붙여준다.
	int LiMIT = 1000;
	public abstract void move1();
	//인터페이스는 메소드 선언 시 아래와 같이 앞의 내용을 생략하면 public abstract를 붙여준다.
	void erase();
}

interface Graphic {
	void rotate();
	void resize();
}

//인터페이스는 클래스의 특별한 형태이므로 클래스와 마찬가지로 extexds 예약어를 사용해 상속을 시킬 수 있다.
//class Line extends Draw {} // 클래스는 인터페이스를 상속 받을 수 없으므로 에러가 발생된다.
//interface Graphics extends Point {} // 인터페이스는 클래스를 상속받을 수 없으므로 에러가 발생된다.
//클래스는 클래스끼리 인터페이스는 인터페이스끼리 상속을 시켜야 하고 인터페이스는 다중 상속이 지원된다.
interface Graphics extends Draw, Graphic {
	//아무 내용도 가지지 않는 인터페이스를 marker(표시) 인터페이스라 부른다.
}

//클래스는 extends 예약어를 사용해 상속받아 사용하고 인터페이스는 implements 예약어를 사용해 구현받아 사용한다.
//Line 클래스는 Point 클래스를 상속받고 Draw, Graphic 인터페이스를 구현받아 만든다.
class Line extends Point implements Draw, Graphic {
		
	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move1() {
		// TODO Auto-generated method stub
		
	}
	
}

public class interfaceTest1 {
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Shape.PI);
		System.out.println(Draw.PI);
		
	}
}
