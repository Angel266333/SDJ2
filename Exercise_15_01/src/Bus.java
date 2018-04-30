import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Observable;
import java.util.Set;

import utility.observer.AbstractRemoteSubject;
import utility.observer.RemoteObserver;
import utility.observer.RemoteSubject;

public class Bus extends AbstractRemoteSubject implements RemoteSubject {
	private String info;
	private Set<BusPassenger> passengers;
	private static Bus instance;
	
	public Bus() {
		passengers = new HashSet<BusPassenger>();
		this.info = "eXpress " + hashCode() % 100;
		instance = this;
	}
	
	public static Bus getInstance() {
		if(instance == null)
			instance = new Bus();
		return instance;
	}

	public void passengerGettingIn(BusPassenger p) throws RemoteException {
		passengers.add(p);
		addObserver((RemoteObserver) p);
		notifyObservers("Enter:" + p.getName());
	}

	public void passengerGettingOut(BusPassenger p) throws RemoteException {
		passengers.remove(p);
		deleteObserver((RemoteObserver) p);
		notifyObservers("Leave: " + p.getName());
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