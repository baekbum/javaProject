package kr.koreait.inheritanceTest3;

public class InheritanceTest3 {
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println(date1);
		Date date2 = new Date(2017,9,28);
		System.out.println(date2);
		
		Time time1 = new Time();
		System.out.println(time1);
		Time time2 = new Time(21, 50 , 01);
		System.out.println(time2);
		
		Now now1 = new Now();
		System.out.println(now1);
		
		Now now2 = new Now(date2, time2);
		System.out.println(now2);
		
		Now now3 = new Now(2017, 9 ,28 ,21 ,50 ,1);
		System.out.println(now3);
	}
}
