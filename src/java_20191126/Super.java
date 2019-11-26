package java_20191126;

public class Super {
	int money;
	
	public Super(){
		super();
	}// 디폴트 생성자. 상속할 때 자식 클래스에서 생성자 만들면 에러남. 부모 클래스에 디폴트 생성자 말고 다른 생성자가 있어서 디폴트 생성자가 자동으로 안생김 => 컴파일 에러
	public Super(int money){
		this.money = money;
	}
	public void makeMoney(){
		System.out.println("super makeMoney()");
	}
	public void play(String omok){
		System.out.println("super play()");
	}
}
