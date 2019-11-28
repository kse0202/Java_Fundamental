package java_20191127.step1;
//1. 요구 사항 : 나노 세컨드로 시간을 측정 할 수 있는 애플리케이션을 만들어 주세요
public class FootNanoStopWatch {
	long startTime;
	long endTime;
	
	long startNanoTime;
	long endNanoTime;
	
	public double getElapsedTime(){
		return (double) (endTime - startTime) / (double) 1000;
	}
	public double getElapsedNanoTime(){
		return (double) (endNanoTime - startNanoTime) / (double) 1000000000;
	}

	public static void main(String[] args) {
		FootNanoStopWatch f = new FootNanoStopWatch();
		f.startTime = System.nanoTime();
		for (long i = 0; i < 5000000000l; i++) {

		}
		f.endTime = System.nanoTime();
		
		double elapsedTime = f.getElapsedNanoTime();


		System.out.printf("경과 시간 : %.9f %n",elapsedTime);
	}
}