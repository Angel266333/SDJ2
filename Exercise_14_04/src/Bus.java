import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

public class Bus extends Observable {
	private String info;
	private Set<BusPassenger> passengers;

	public Bus() {
		passengers = new HashSet<BusPassenger>();
		this.info = "eXpress " + hashCode() % 100;
	}

	public void passengerGettingIn(BusPassenger p) {
		Iterator<BusPassenger> it = passengers.iterator();
		while (it.hasNext())
			it.next().showMessage("Enter:" + p.getName());
		passengers.add(p);
	}

	public void passengerGettingOut(BusPassenger p) {
		passengers.remove(p);
		Iterator<BusPassenger> it = passengers.iterator();
		while (it.hasNext())
			it.next().showMessage("Leave:" + p.getName());
	}

	public String getInfo() {
		return info;
	}

	public String getPassengerList() {
		String s = "";
		Iterator<BusPassenger> it = passengers.iterator();
		while (it.hasNext()) {
			s += it.next().toString();
			s += "\n";
		}
		int index = s.lastIndexOf("\n");
		if (index > -1)
			s = s.substring(0, index);
		return s;
	}

	public String toString() {
		return getInfo() + ":\n" + getPassengerList();
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Bus))
			return false;
		Bus b = (Bus) obj;
		return info.equals(b.info);
	}
}