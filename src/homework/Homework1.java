package homework;

public class Homework1 {
	public static void main(String[] args) {
		// 달력 만들기
		// 1. 1년 1월 1일은 월요일
		// 2. 1년 365일, 윤년은 366일 -2월 29일
		// 3. 윤년은 4년마다 발생하고 그중에서 100배수는 제외하고 400의 배수는 제외하지 않는다.
		// 4. 2019년 12월 25일은 무슨요일일까요?

		int year = 2020;
		int month = 2;
		int day = 29;
		String message = null;
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// coding
		//윤달
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			monthArray[1] = 29;
		}
		//month -> day로 계산
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

}
