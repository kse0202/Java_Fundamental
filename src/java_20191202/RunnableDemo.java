package java_20191202;

public class RunnableDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.printf("%s : %d %n", threadName, i);
		}
	}
	public static void main(String[] args) {
		System.out.println("*******start********");
		
		RunnableDemo r1 = new RunnableDemo();
		Thread t1 = new Thread(r1, "first thread");
		//thread객체를 생성해야함
		//thread클래스에 어떤 객체(r1)를 어떤 쓰레드(first thread)로 할건지 할건지 절해서 객체생성함. 
		t1.start();
		
		RunnableDemo r2 = new RunnableDemo();
		Thread t2 = new Thread(r2, "second thread");
		t2.start();
		
		System.out.println("*******start********");
	}

}
