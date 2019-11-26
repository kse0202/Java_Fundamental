package java_20191126;

public class Sub extends Super{
	String chicken;
	public Sub(){
		super(); //부모 클래스의 디폴트 생성자를 호출한다. 
	}
	public void gotoSchool(){
		System.out.println("sub gotoSchool()");
	}

}
