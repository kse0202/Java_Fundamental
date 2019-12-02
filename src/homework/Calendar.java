package homework;

public class Calendar {
	int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeafYear(int year){
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		}else{
			return false;
		}
	}
	public int getTotalDays(int year, int month, int day){
		//윤달인가?
		if ( isLeafYear(year) == true) {
			monthArray[1] = 29;
		}
		
		//month의 이전 달까지의 일수
		int monthDays = 0;
		for (int i = 0; i < month - 1; i++) {
			monthDays += monthArray[i];

		}
		return (year - 1) * 365 + (year / 4 - year / 100 + year / 400)
				+ monthDays + day;
	}
	
	public String getDayOfWeek(int getTotalDays){
		String message = null;
		switch (getTotalDays % 7) {
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

		return message;
		
	}
	public void getBlank(int totalDays){
		if (totalDays % 7 == 0) {
			System.out.printf("\t\t\t\t\t\t");
		} else if (totalDays % 7 == 1) {
			System.out.printf("");
		} else if (totalDays % 7 == 2) {
			System.out.printf("\t");
		} else if (totalDays % 7 == 3) {
			System.out.printf("\t\t");
		} else if (totalDays % 7 == 4) {
			System.out.printf("\t\t\t");
		} else if (totalDays % 7 == 5) {
			System.out.printf("\t\t\t\t");
		} else if (totalDays % 7 == 6) {
			System.out.printf("\t\t\t\t\t");
		}
		
	}
	public static void main(String[] args) {
	

	}

}
