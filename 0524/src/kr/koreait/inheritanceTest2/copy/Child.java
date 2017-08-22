package kr.koreait.inheritanceTest2.copy;


public class Child extends Parent{
	
	private int age;
	private String nickName;
	
	public Child() {
		this("무명씨", false, 0, "없음");
	}
	
	//부모 클래스로부터 상속받은 멤버의 접근 권한이 protected일 경우 자식 클래스에서 접근할 수 있으므로 부모
	//클래스의 생성자나 setter를 사용하지 않고 this를 이용해 초기화 시킬 수 있다.
	public Child(String name, boolean gender, int age, String nickName) {
		
		this.name = name;
		this.gender = gender;		
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
		return name + "(" + (gender ? "남" : "여") + ") - " + age + ", " + nickName;
	}
}
