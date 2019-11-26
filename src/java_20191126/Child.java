package java_20191126;

public class Child extends Parent {
	double height = 170.23;
	
	//overriding : 부모의 메서드를 재정의
	//1. 메서드 이름, 매개변수, 반환형 일치
	//2. 접근 한정자는 부모보다 자식이 상위거나 같으면 됨
	public void work(){
		//super.work(); //부모의 메서드를 호출해서 수정해서 사용할 때 super. 으로 불러와서 이용한다
		
		System.out.println("Child work()");
	}
	public void playGame(){
		System.out.println("Child playGame()");
	}
}
