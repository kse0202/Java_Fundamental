package java_20191125;

public class CalendarDemo {
	
	private int year;
	private int month;
	private int day;
	private int totalDays;
	private int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public void set(int y, int m, int d){
		year = y;
		month = m;
		day = d;
		getTotalCount();
	
	}
	
	private int getTotalCount(){
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			monthArray[1] = 29;
		}
		//month -> day로 계산
		int monthDays = 0;
		for (int i = 0; i < month - 1; i++) {
			monthDays += monthArray[i];

		}
		totalDays = (year - 1) * 365 + (year / 4 - year / 100 + year / 400)
				+ monthDays + day;
		
		return totalDays;
	}
	public void print(){
		String message = null;
		switch (totalDays){
		case 0:
			message = "일요일";
			break;
		case 1:
			message = "월요일";
			break;
		case 2:
			message = "화요일";
			break;
		case 3:
			message = "수요일";
			break;
		case 4:
			message = "목요일";
			break;
		case 5:
			message = "금요일";
			break;
		case 6:
			message = "토요일";
			break;

		default:
			break;
		}

		System.out.printf("%d년 %d월 %d일 %s 입니다.", year, month, day, message);
	}
	public static void main(String[] args) {
		CalendarDemo c = new CalendarDemo();
		c.set(2019,12,25);
		//c.getTotalCount();
		c.print();
	}

}
