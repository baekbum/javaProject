package kr.koreait.abstractClassTest;

// 자바는 원칙적으로 java 파일 하나에 하나의 클래스를 선언하지만 필요에 따라서 하나의 파일에 두개 이상의 
// 클래스를 선언할 수 있다.
// 클래스 선언시 public은 반드시 파일의 이름과 같은 이름을 가지는 클래스에만 붙여줘야 한다.
// 한 파일에 여러개의 클래스를 만들어도 컴파일은 독립적으로 이루어져서 클래스 각각의 이름을 가지는 *.class
// 파일이 생성된다.

// 추상 클래스 : 추상 메소드를 한 개 이상 포함하는 클래스
// 추상 클래스는 상속을 목적으로 만드는 불완전한 클래스로 객체를 만들어 사용할 수 없다.
// 추상 클래스를 상속받아 작성된 클래스는 추상 클래스로 부터 상속받은 추상 메소드를 반드시 override 시켜서
// 사용해야한다.
// 다형성을 구현하기 위해 주로 사용된다. -> 인터페이스를 더 많이 사용한다.
abstract class Product {
	//public void draw()  아무런 일도 하지 않는 일반 메소드
	//추상 메소드 : 아무런 일도 하지 않는 메소드의 몸체 {} 블록을 가지지 않는 메소드
	// abstract 예약어를 사용해 선언하며 추상 메소드가 포함된 클래스를 상속받는 자식 클래스에서 상속받은 
	// 추상 메소드를 반드시 override 시켜서 사용해야 함을 프로그래머에게 알려준다.
	public abstract void draw();	
		
}
// Product 클래스를 상속받아 Camera 클래스를 만든다.
class Camera extends Product {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}

class CamCoder extends Product {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}	
}

public class AbstractClassTest{
	public static void main(String[] args) {
		// 추상 클래스는 객체를 생성해 사용할 수 없으므로 에러가 발생된다.
		
		Product product;
	}	
}
