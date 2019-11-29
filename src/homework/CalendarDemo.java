package homework;

import java.util.Scanner;

public class CalendarDemo {
	
	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	public CalendarDemo(){
		
	}
	public CalendarDemo(int year, int month, int day){
		
	}
	public CalendarDemo(int year, int month){
		
	}
	public CalendarDemo(int year){
		
	}
	public static void main(String[] args) {
		CalendarDemo cd = new CalendarDemo();
		cd.console("날짜를 입력하세요>");
		Calendar c = new Calendar();
		c.printDayOfWeek(year, month, day);
	}

}
