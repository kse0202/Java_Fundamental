package java_20191202;

public class ThreadDemo extends Thread{
	public ThreadDemo(String threadName){
		super(threadName);
		
	}
	public void run(){
		for (int i = 0; i < 1000; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.printf("%s : %d %n", threadName, i);
			
		}
	}
	public static void main(String[] args) {
		//쓰레드 객체를 생성하는 방법
		//1. Thread 클래스를 상속받는다.
		//2. run 메서드를 오버라이딩한다.
		//3. 해당 객체(threadDemo)를 생성한다.
		//4. 해당 객체로 start메서드를 호출한다.
		System.out.println("**********start**********");
		ThreadDemo t1 = new ThreadDemo("first thread");
		t1.start();
		ThreadDemo t2 = new ThreadDemo("second thread");
		t2.start();
		System.out.println("************end************");
	}
	

}
