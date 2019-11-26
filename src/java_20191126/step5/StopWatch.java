package java_20191126.step5;

public abstract class StopWatch {
	private long startTime;
	private long endTime;
	
	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public abstract void run();
	

	
}
