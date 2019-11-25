package java_20191120;

public class ContinueDemo {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (i == 6)
				continue;
			sum += i;

		}
		System.out.println(sum);
		//continue;
	}
}
