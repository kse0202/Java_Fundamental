package java_20191127.step1;
//1. 요구 사항 : 밀리 세컨드로 시간을 측정 할 수 있는 애플리케이션을 만들어 주세요
public class FootStopWatch {
	long startTime;
	long endTime;

	public static void main(String[] args) {
		FootStopWatch f = new FootStopWatch();
		f.startTime = System.currentTimeMillis();
		for (long i = 0; i < 5000000000l; i++) {

		}
		f.endTime = System.currentTimeMillis();

		double elapsedTime = (double) (f.endTime - f.startTime) / (double) 1000;

		System.out.printf("경과 시간 : %.3f %n", elapsedTime);
	}
}