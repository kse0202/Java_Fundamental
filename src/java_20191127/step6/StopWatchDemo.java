package java_20191127.step6;


//1. 모든 클래스의 encapsulation
//2. 메인 클래스의 Java Reflection 추가

public class StopWatchDemo {
	public void execute(StopWatch s){
		s.run();
	}

	
	public static void main(String[] args) throws Exception{
		String input = args[0];
		String className = "java_20191127.step6."+input;
		StopWatch s = (StopWatch)Class.forName(className).newInstance(); 
		//className으로 인스턴스 생성,그 클래스 네임의 인스턴스가 생김. 
		//부모 클래스로 캐스팅=> 어떤 인스턴스를 생성하든 부모 클래스로 캐스팅해서 돌아가게 만듬. 
		
		StopWatchDemo swd = new StopWatchDemo();
		//execute메서드가 인스턴스 메서드 여서 객체를 생성해야지만 호출가능. 클래스 메서드(Static)이었다면 바로 호출 가능.
		swd.execute(s); 
		//StopNanoWatch s = new StopNanoWatch();
		//swd.execute(s); //추상 클래스인 StopWatch를 상속받은 클래스의 객체를 넣어준다. 윗줄에서 객체 생성. 추상 클래스는 객체 생성이 안된다. 
		//swd.execute(new StopNanoWatch()); //객체를 만들어서 바로 넣어도 된다.
		
		
		//StopMilliWatch s1 = new StopMilliWatch();
		//swd.execute(s1);
		
		//StopMicroWatch s2 = new StopMicroWatch();
		//swd.execute(s2);
	}
}
