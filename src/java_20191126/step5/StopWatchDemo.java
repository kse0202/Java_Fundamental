package java_20191126.step5;

public class StopWatchDemo {
	public static void execute(StopWatch s) {
		s.run();
	}

	public static void main(String[] args) throws Exception{
		
		String input = args[0];
		input = "java_20191126.step5."+input;
		//java reflection
		StopWatch s1 =(StopWatch)Class.forName(input).newInstance();
		execute(s1);
	
	}
	
	

}
