package java_20191122;

public class CustomerDemo {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.name ="성영한";
		c1.email ="syh@hbilab.org";
		
		System.out.println(c1.name+", "+ c1.email);
		
		Customer c2 = new Customer();
		c2.name ="손정의";
		c2.email ="son@naver.com";
		
		System.out.println(c2.name+", "+ c2.email);
	
		Customer c3 = new Customer();
		c3.name ="바보";
		c3.email ="qkqh@naver.com";
		
		System.out.println(c3.name+", "+ c3.email);
		
		Customer c4 = c3;
		c4.name = "잡스";
		
		System.out.println(c4.name+", "+ c4.email);
	
		Customer c5 = new Customer();
		c5.name = "손정의";
		c5.email ="son@naver.com";
		
		System.out.println(c2 == c5);
		
		//static 변수는 reference variable로 접근 가능하나 일반적으로 클래스 이름으로 접근한다.
		c1.interestRate = 10.2;
		System.out.println(c3.interestRate);
		
		Customer.interestRate =12.2;
		System.out.println(Customer.interestRate);
		
		//Customer.BANKNAME = "국민은행"; //final 변수는 수정 불가능 
	}
}
