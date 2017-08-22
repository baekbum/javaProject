package kr.koreait.inheritanceTest3;

import java.util.Date;

public class Time {
	private int hour;
	private int minute;
	private int second;
	public Time() {
		//super();
		Date date = new Date();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
	}
	public Time(int hour, int minute, int second) {
		//super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	@Override
	public String toString() {
		//return hour + ":" + minute + ":" + second;
		return String.format("%02d:%02d:%02d", hour,minute,second);
	}
	
	
	
}
	