package kr.koreait.interfaceTest;

interface Repairble {
	
}

//모든 Unit의 조상 클래스 Unit을 만든다.
class Unit {
	//final 변수(상수)는 반드시 선언과 동시에 초기화를 시켜야한다.
	//final 변수를 초기화 시키는 방법은 선언시 "="를 이용해서 하는 방법과 생성자를 통해서 하는 방법
	//그리고 초기화 블록을 사용해서 하는 방법이 있다.
	final int MAX_HP; // 최대 HP
	int hitPoint; // 현재 HP
	
	//최대 HP를 넘겨받는 생성자를 사용해 MAX_HP를 초기화 시킨다.
	Unit(int hp){
		MAX_HP = hp;
	}
}

// Unit 클래스를 상속받아 모든 육상 unit의 조상 클래스 GroundUnit 클래스를 만든다.
class GroundUnit extends Unit{
	GroundUnit(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}
}

//Unit 클래스를 상속받아 모든 공중 unit의 조상 클래스 AirUnit 클래스를 만든다.
class AirUnit extends Unit{
	AirUnit(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}	
}

//GroundUnit 클래스를 상속받아 Tank, Marine, SCV 클래스를 만든다.

class Tank extends GroundUnit implements Repairble {
	Tank() {
		super(120);
		hitPoint = MAX_HP - 30;
	}

	@Override
	public String toString() {
		return "Tank";
	}
}

class Marine extends GroundUnit{
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}	
}

class SCV extends GroundUnit implements Repairble {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}
	//수리하는 메소드는 Unit 별로 따로 만들지 않고 수리 기능을 하는 객체인 이곳에만 만든다.
	//메소드의 인수로 클래스나 인터페이스를 사용하면 사용한 클래스를 상속받거나 인터페이스를 구현받은 모든 객체를
	//인수로 받을 수 있다. => 오퍼랜드 오버로딩
	void repair(Repairble repairble) {
		//인수로 넘겨받은 인터페이스는 아무런 내용이 없으므로 구현될 내용이 있는 클래스로 형변환 시켜 사용한다.
		if(repairble instanceof Unit){
			Unit unit = (Unit) repairble;
			while(unit.hitPoint != unit.MAX_HP){
				unit.hitPoint++;
				System.out.printf("%6.2f%% 수리완료\n", (double)unit.hitPoint / unit.MAX_HP * 100);
				try{
					//sleep() : 괄호 안에 지정된 시간만큼 프로그램을 잠깐 멈춘다. 시간은 밀리초 단위로 입력한다.
					Thread.sleep(200);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println(unit + "수리 완료");
		}		
	}	
}

//AirUnit 클래스를 상속받아 DropShip 클래스를 만든다.

class DropShip extends AirUnit implements Repairble {
	DropShip() {
		super(150);
		// TODO Auto-generated constructor stub
	}	
}

public class MarkerInterfaceTest {
	public static void main(String[] args) {
		
		Tank tank = new Tank();
		Marine marine = new Marine();		
		SCV scv = new SCV();
		DropShip dropShip = new DropShip();
		
		scv.repair(tank);		
	}
}
