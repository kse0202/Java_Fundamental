package homework;

public class Homework2 {
	public static void main(String[] args) {
		// 문자 reverse 하기
		// 1. input "abcd" => "dcba"
		// 2. input "abcde" => "edcbe"

		String input = "abcde"; // "abcde"
		char[] ch = input.toCharArray();
		for (int i = 0; i < ch.length/2; i++) {
			char temp ;
			
			temp = ch[i];
			ch[i] = ch[ch.length-1-i] ;
			ch[ch.length-1-i] = temp;
		
		}
		for (char c : ch) {
			System.out.print(c);
		}
		
		
		System.out.println();

		// 1-100까지 소수를 구하시오
		// 로또 만든거 활용하긔

		for (int i = 2; i <= 100; i++) {
			int count = 0;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					count ++;
					break;
				}
				
			}
			if(count ==0){
			System.out.printf("%d ,",i);
			}
		}
	}

}
