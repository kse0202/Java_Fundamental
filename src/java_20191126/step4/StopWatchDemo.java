package java_20191126.step4;

public class StopWatchDemo {
	public static void execute(StopMilliWatch s){
		
		s.start();
		for (long i = 0; i < 5000000000l; i++) {

		}
		s.stop();
		double elapsedTime = s.getElapsedTime();
		System.out.printf("경과시간 : %.3f", elapsedTime);

		
	}
public static void execute(StopNanoWatch s){
		
		s.start();
		for (long i = 0; i < 5000000000l; i++) {

		}
		s.stop();
		double elapsedTime = s.getElapsedTime();
		System.out.printf("경과시간 : %.9f", elapsedTime);

		
	}

	public static void main(String[] args) {
		StopMilliWatch s = new StopMilliWatch();
		
	}

}
