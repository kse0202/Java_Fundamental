package java_20191119;

public class CharacterLiterallDemo {
	public static void main(String[] args) {
		//1. 유니코드 표현법 = '\u0000'
		
		char c1 = '\uAD8C';
		char c2 = '\uC528';
		
		System.out.println(c1);
		System.out.println(c2);
		
		//2. 아스키코드 표현법 = 숫자
		// 48~57 = 0~9
		// 65~90 = A~Z
		// 97~122 = a~z
		
		char c3 = 48;
		char c4 = 65;
		char c5 = 97;
		
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		
		//3. 문자 표현법 = ''
		char c6 = '+';
		System.out.println(c6);
		
		//escape char
		// \n => line feed
		// \t => tap
		// \\ => \
		// \' => '
		// \" => "
		
		System.out.println("hello\n" + "world");
		System.out.println("hello\t" + "world");
		
		String path = "C:\\\"dev\"";
		System.out.println(path);
				
	}
	

}
