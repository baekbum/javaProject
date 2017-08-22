package kr.koreait.inheritanceTest;

//자식(하위, 서브, 파생) 클래스
//Parent 클래스를 상속받아 Child 클래스를 만든다
//extends 예약어를 사용해 상속시킨다.
public class Child extends Parent{
	
	//Parent 클래스를 상속받았으므로 멤버 변수 name, gender와 getter & setter 및 toString() 메소드를
	//포함하고 있다.
	private int age;
	private String nickName;
	
	public Child() {
		this("무명씨", false, 0, "없음");
	}
	//부모 클래스로부터 상속받은 멤버 변수의 접근 권한이 private일 경우 자식 클래스에서도 접근할 수 있다.
	//부모 클래스로부터 상속받은 멤버 변수의 접근 권한이 private일 경우 상속 받은 멤버는 부모 클래스의 생성자를
	//실행해서 초기화 시켜야한다.
	public Child(String name, boolean gender, int age, String nickName) {
		//부모 클래스의 생성자 public Parent(String name, boolean gender)를 호출한다.
		super(name, gender);
		//부모 클래스로부터 상속받은 멤버 변수의 접근 권한이 private일 경우 부모 클래스에 setter 메소드가 정의 되어
		//있다면 setter 메소드를 이용해 초기화 시킬 수 있다.
		//setName(name);
		//setGender(gender);
		this.age = age;
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		//return getName() + "(" + (isGender() ? "남" : "여") + ") - " + age + ", " + nickName;
		return super.toString() + " - " + age + ", " + nickName;
	}
}
