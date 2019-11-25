package java_20191120;

public class BreakDemo {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {

			sum += i;
			if (i == 5)
				break;
		}
		System.out.println(sum);
		
		outter : for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(i==4 &&j==9) break outter;
				System.out.printf("%d*%d =%d %n", i, j, i * j);
			}
		}
	}

}
