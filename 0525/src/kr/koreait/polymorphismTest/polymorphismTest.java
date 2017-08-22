package kr.koreait.polymorphismTest;

import java.util.Scanner;

//다형성을 구현하기 위해서는
//다형성을 구현할 메소드가 포함된 모든 클래스는 같은 부모 클래스를 가져야하고
//부모 클래스와 자식 클래스에 동일한 메소드가 존재해야하며
//반드시 자식 클래스에서 부모 클래스로부터 상속받은 메소드를 override 시켜서 사용해야 한다.
//부모 클래스 타입에 자식 클래스 객체가 생성된 주소를 대입시켜 메소드를 실행시킨다.

abstract class Shape{
	public abstract void draw();
	
}

// Shape 클래스를 상속받아 Point 클래스를 만든다.
class Point extends Shape{
	@Override
	public void draw() {
		System.out.println("점을 찍는다.");		
	}
}

//Shape 클래스를 상속받아 Line 클래스를 만든다.
class Line extends Shape{
	@Override
	public void draw() {
		System.out.println("선을 그린다.");		
	}
}

//Shape 클래스를 상속받아 Circle 클래스를 만든다.
class Circle extends Shape{
	@Override
	public void draw() {
		System.out.println("원을 그린다.");		
	}
}

//Shape 클래스를 상속받아 Rect 클래스를 만든다.
class Rect extends Shape{
	@Override
	public void draw() {
		System.out.println("사각형을 그린다.");		
	}
}

//Shape 클래스를 상속받아 TryAngle 클래스를 만든다.
class TryAngle extends Shape{
	@Override
	public void draw() {
		System.out.println("삼각형을 그린다.");		
	}
}

public class polymorphismTest {
	public static void main(String[] args) {
		Shape[] shapes = {new Point(), new Line(), new Circle(), new Rect(), new TryAngle()};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("원하는 작업을 선택하세요.");
		int menu = sc.nextInt();
		shapes[menu].draw();		
	}
}
