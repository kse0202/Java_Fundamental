package java_20191127.step5;


//1. 실제 비지니스 로직을 해당 클래스에 추가하자
//2. 클래스들의 공통 요소가 있으면 부모 클래스로 만들어 보자

public class StopWatchDemo {
	public void execute(StopWatch s){
		s.run();
	}

	
	public static void main(String[] args) {
		StopWatchDemo swd = new StopWatchDemo();
		//execute메서드가 인스턴스 메서드 여서 객체를 생성해야지만 호출가능. 클래스 메서드(Static)이었다면 바로 호출 가능.
		
		StopNanoWatch s = new StopNanoWatch();
		swd.execute(s); //추상 클래스인 StopWatch를 상속받은 클래스의 객체를 넣어준다. 윗줄에서 객체 생성. 추상 클래스는 객체 생성이 안된다. 
		swd.execute(new StopNanoWatch()); //객체를 만들어서 바로 넣어도 된다.
		
		
		StopMilliWatch s1 = new StopMilliWatch();
		swd.execute(s1);
		
		StopMicroWatch s2 = new StopMicroWatch();
		swd.execute(s2);
	}
}
