package kr.koreait.inheritanceTest3;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date() {
		/*
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		*/
		java.util.Date date = new java.util.Date();
		year = date.getYear() + 1900;
		month = date.getMonth() + 1;
		day = date.getDate();
	}
	
	public Date(int year, int month, int day) {
		//super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		//return year + "년 " + month + "월 " + day + "일";
		return String.format("%d년 %02d월 %02d일", year,month,day);
	}
	
	
}
