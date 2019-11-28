package java_20191128;

public class StringDemo {
	public static void main(String[] args) {
		String str = "abcdefg";
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		str = str.concat("123"); // str+"123"이랑 같은 뜻 . StringBuffer사용해라
		System.out.println(str);
		
		String fileName = "abc.zip";
		if(fileName.endsWith("zip")){
			System.out.println("zip 파일입니다.");
		}else if(fileName.endsWith("ppt")){
			System.out.println("ppt 파일입니다.");
		}
		
		String uri = "artist/index.jsp";
		if(uri.startsWith("artist")){
			System.out.println("작가 메인페이지 입니당.");
		}else if(uri.startsWith("exhibition")){
			System.out.println("전시 페이지 입니당.");
		}
		
		System.out.println("abc".equalsIgnoreCase("aBC")); //대소문자를 구분하지 앟고 문자열을 비교한다
		
		String s1 = "김";
		String s2;
		System.out.println(s1.getBytes().length);
		
		String ssn = "111111-1111118";
		System.out.println(ssn.indexOf("-"));
		
		fileName = "abc.bde.fafb.asdf.ppt";
		System.out.println(fileName.lastIndexOf("."));
		String firstSnn = ssn.substring(0,6);
		System.out.println(firstSnn);
		String secondSnn = ssn.substring(7);
		System.out.println(secondSnn);
		
		String content = "abc\nabc\nabc";
		System.out.println(content.replaceAll("\n", "<br>"));
		
		s1 = "abc";
		s2 = "abc ";
		System.out.println(s1.length());
		System.out.println(s2.length());
		System.out.println(s1.trim().equals(s2.trim())); //앞뒤 공백 제거
		
		s1 = String.valueOf(100); 
		//valueof 는 프리미티브 8가지를 모두 오버로딩 해놓은
		//8가지 프리미티브 형을 String으로 바꿔주는 메서드
		
		String phone = "010-3024-1703";
		String[] temp = phone.split("-"); // - 는 구분자, 010, 3024,1703 은 token 이라고 한다
		for (String string : temp) {
			System.out.println(string);
		}
		str = String.format("%3$,10d%n %2$,10d%n %1$,10d%n", 100000, 200000, 300000);
		System.out.println(str);
		
		StringBuffer str1 = new StringBuffer();
		str1.append("abcde");
		str1.reverse();
		str1.toString();
		System.out.println(str1);
				
	}

}
