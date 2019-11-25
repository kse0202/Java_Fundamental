package java_20191122.bb;

import java_20191122.aa.Notice;
//서로 다른 패키지의 클래스를사용하기 위해서는 반드시 import 해줘야 한다. Notice class를 임포트 한 상태. Notice 클래스는 public이어야 함/


public class NoticeDemo2 extends Notice{
	
	public static void main(String[] args) {
		
		//서로 다른 패키지에서는 public지정된 매개변수만 쓸 수 있다.
		Notice n = new Notice();
		n.number = 10;
		//n.title = "title";
		//n.hit = 100;
		//n.regdate = "2019-11-22";
		
		NoticeDemo2 nc = new NoticeDemo2();
		nc.number = 10;
		nc.title = "title";
		//NoticeDemo2는 Notice를 상속받음. 상속받은 클래스로 객체를 만들면 protected 된 매개변수 사용 가능. 

	}

}
