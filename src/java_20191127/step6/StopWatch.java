package java_20191127.step6;

public abstract class StopWatch {
	private long startTime;
	private long endTime;
	
	//멤버 변수에 대한 encapsulation
	public void setStartTime(long startTime){
		this.startTime = startTime;
	}
	public long getStartTime(){
		return startTime;
	}
	
	public void setEndTime(long endTime){
		this.endTime = endTime;
	}
	
	public long getEndTime(){
		return endTime;
	}
	
	public abstract void run();

}
