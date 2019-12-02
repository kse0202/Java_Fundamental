package java_20191202;

public class SynchronizedDemo implements Runnable {
	int x;
	int y;
	@Override
	public synchronized void run() { //두 쓰레드가 같은 객체를 공유할 때, synchronized 메서드는 한번 잡은 제어권을 절대 안넘겨줌. 
		synchronized(SynchronizedDemo.class){//run안에 일정 부분에만 걸수도 있다. 
		for (int i = 0; i < 1000; i++) {
			
			x++;
			y++;
			String threadName = Thread.currentThread().getName();
			System.out.printf("x : %d , y : %d - %s %n", x, y, threadName );
		}
		}
	}
	public static void main(String[] args) {
		SynchronizedDemo s1 = new SynchronizedDemo();
		SynchronizedDemo s2 = new SynchronizedDemo();
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s1);
		
		t1.start();
		t2.start();
		
		
		while(true){
			try {
				Thread.sleep(1000); //동작을 멈춘다 시간만큼
				//예외처리 꼭 해줘야 한다..
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Thread(s1).start();
		}
	}

}
