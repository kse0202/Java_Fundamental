package java_20191120;

public class ForDemo {
	public static void main(String args[]) {
		String str = "hello";
		int a1 = 10;
		int a2 = 20;
		double d1 = 12.4567;

		System.out.printf("%10s, %10d, %10d, %.2f %n", str, a1, a2, d1);

		int sum = 0;
		for (int i = 0; i <= 100; i += 2) {
			sum += i;
		}

		System.out.printf("1부터 100까지 합은 %d 입니다.%n", sum);
		long now = System.currentTimeMillis();

		System.out.printf("현재 시각 : %d", now);

		for (int i = 1; i <= 9; i++) {
			System.out.printf("2 * %d = %d %n", i, 2 * i);

		}

		for (int first = 2; first <= 9; first++) {
			for (int second = 1; second <= 9; second++) {
				System.out.printf("%d * %d = %d %n", first, second, first
						* second);

			}
			System.out.println("---------");

		}
		System.out.println("******************************");
		for (int first = 9; first >= 2; first--) {
			for (int second = 9; second >= 1; second--) {
				System.out.printf("%d * %d = %d %n", first, second, first
						* second);

			}
			System.out.println("---------");
		}
		for (int i = 0; i <= 5; i++) {
			for (int j = 1; j < i + 1; j++) {
				System.out.print("*");

			}
			System.out.println();
		}
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");

			}
			System.out.println();
		}
		

	}

}
