package homework;

import java.util.Scanner;

public class CalendarDemo extends Calendar{
	int year =1;
	int month=1;
	int day=1;
	
	public String console(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	public void printCalendar(int year, int month, int day) {
		int totalDays = getTotalDays(year, month, day);
		String dayOfWeek = getDayOfWeek(totalDays);
		System.out.printf("%d년 %d월 %d일 %s입니다.", year, month, day, dayOfWeek);
	}

	public void printCalendar(int year, int month) {
		System.out.println();
		System.out.printf("%d년 %d월\n", year, month);
		System.out.printf("\t월\t화\t수\t목\t금\t토\t일\n");
		int totalDays = getTotalDays(year, month, day);
		getBlank(totalDays);
		for (int i = 1; i <= monthArray[month - 1]; i++) {
			System.out.printf("\t %d", i);
			for (int j = 0; j < monthArray[month - 1] / 7; j++) {
				if ((i + totalDays % 7 - 1) % 7 == 0) {
					System.out.println();
				}
			}

		}

	}

	public void printCalendar(int year) {
		for (int k = 1; k <= 12; k++) {
			System.out.println();
			System.out.printf("%d년 %d월\n", year, k);
			System.out.printf("월\t화\t수\t목\t금\t토\t일\n");
			int totalDays = getTotalDays(year, k, day);
			getBlank(totalDays);
			for (int i = 1; i <= monthArray[k-1]; i++) {
				System.out.printf("%d\t", i);
				for (int j = 0; j < monthArray[k-1] / 7; j++) {
					if ((i + totalDays % 7 - 1) % 7 == 0) {
						System.out.println();
					}
				}

			}
			System.out.println();
		}

	}
	

	public int getCharNumber(String date, char t){
        int count = 0;
        for(int i=0;i<date.length();i++)
        {
            if(date.charAt(i) == t)
                count++;
        }
        return count;
    }
	public void printCalendar(String date){
		CalendarDemo cd = new CalendarDemo();
		char t = 45;
		if(cd.getCharNumber(date, t)==2){
			year = Integer.parseInt(date.split("-")[0]);
			month = Integer.parseInt(date.split("-")[1]);
			day = Integer.parseInt(date.split("-")[2]);
			cd.printCalendar(year, month, day);
		}else if(cd.getCharNumber(date, t) ==1){
			year = Integer.parseInt(date.split("-")[0]);
			month = Integer.parseInt(date.split("-")[1]);
			cd.printCalendar(year, month);
		}else if(cd.getCharNumber(date, t) ==0){
			year = Integer.parseInt(date.split("-")[0]);
			cd.printCalendar(year);
	
		}
	}
	
	public static void main(String[] args) {
		CalendarDemo cd = new CalendarDemo();
		String date = cd.console("날짜를 입력하세요(년월일은 -로 구분)>");
		cd.printCalendar(date);
	}

}
