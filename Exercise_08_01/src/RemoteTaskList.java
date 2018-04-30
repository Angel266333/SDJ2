import java.rmi.RemoteException;

public interface RemoteTaskList {

	public void add(String task) throws RemoteException;
	
	public String remove() throws RemoteException;
	
	public int size() throws RemoteException;
	
}
