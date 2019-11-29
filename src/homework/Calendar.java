package homework;

public class Calendar {
	static int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	
	
	public void printDayOfWeek(int year, int month, int day){
		String message = null;
	
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			monthArray[1] = 29;
		}
	
		int monthDays = 0;
		for (int i = 0; i < month - 1; i++) {
			monthDays += monthArray[i];

		}
		int totalDays = (year - 1) * 365 + (year / 4 - year / 100 + year / 400)
				+ monthDays + day;
		switch (totalDays % 7) {
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
		

	}

}
