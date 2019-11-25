package java_20191125;

public class MemberDemo {
	public static void main(String[] args) {
		Member m = new Member();
		m.setName("문재인");
		m.setZipcode("12390");
		m.setAddress1("서울");
		m.setAddress2("청와대");
		m.setEmail("president@bluehouse.go.kr");
		m.setSsn("123456-1234567");
		m.setAge(60);
		m.setPassword("123");
		m.setHeight(176.45);
		
		System.out.println(m.getName());
		System.out.println(m.getZipcode());
		System.out.println(m.getAddress1());
		System.out.println(m.getAddress2());
		System.out.println(m.getEmail());
		System.out.println(m.getSsn());
		System.out.println(m.getAge());
		System.out.println(m.getHeight());
		
			
		
		

	}
}
