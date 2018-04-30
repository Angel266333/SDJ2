import java.util.ArrayList;

public class Observable {

	private ArrayList<Observer> allObservers = new ArrayList<Observer>();

	public void addObserver(Observer obs) {
		allObservers.add(obs);
	}

	public void removeObserver(Observer obs) {
		allObservers.remove(obs);
	}

	public void notifyObservers(Object msg) {
		for (Observer o : allObservers) {
			o.update(this, msg);
		}
	}
}