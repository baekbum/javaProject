package kr.koreait.inheritanceTest3;

//자바는 다중 상속을 지원하지 않는다.
//public class Now extends Date, Time <- 에러

public class Now {
	//자바는 다중 상속을 지원하지 않기 때문에 다중 상속 효과를 내기 위해 클래스 포함 기능을 사용한다.
	//클래스 포함은 클래스가 다른 클래스를 멤버로 가지는 것을 말한다.
	private Date date;	//클래스 포함
	private Time time;
	
	public Now() {
		date = new Date();
		time = new Time();
	}
	
	public Now(int year, int month, int day, int hour, int minute, int second) {
		date = new Date(year,month,day);
		time = new Time(hour,minute,second);
	}
	
	public Now(Date date, Time time) {
		this.date = date;
		this.time = time;
	}
	@Override
	public String toString() {
		return "지금은 " + date + " " + time + "입니다.";
	}
	
}
