package starSigns;
public abstract class AbstractStarSign {

	private String name;
	private DateInterval interval;
	
	public AbstractStarSign(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public DateInterval getInterval() {
		return interval;
	}
	
	public String toString() {
		return name + " " + interval;
	}
	
}