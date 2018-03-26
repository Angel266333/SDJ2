package tasklist.domain.model;

public class Task {

	private String text;
	private long estimatedTime;
	
	public Task(String text, long estimatedTime) {
		
		this.text = text;
		this.estimatedTime = estimatedTime;
		
	}
	
	public String getText() {
		
		return this.text;
	
	}
	
	public long getEstimatedTime() {
		
		return this.estimatedTime;
	}
	
	public void setEstimatedTime(long estimatedTime) {
		
		this.estimatedTime = estimatedTime;
		
	}
	
	public String toString() {
		
		return "Input: " + this.text + "ETA: " + this.estimatedTime;
		
	}
}
