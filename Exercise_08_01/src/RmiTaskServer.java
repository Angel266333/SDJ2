import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiTaskServer extends UnicastRemoteObject implements RemoteTaskList {

	private static final long serialVersionUID = 1L;
	private RmiTaskList tasks;

	protected RmiTaskServer() throws RemoteException {
		super();
		tasks = new RmiTaskList();
	}

	@Override
	public void add(String task) throws RemoteException {
		tasks.addTask(task);
	}

	@Override
	public String remove() throws RemoteException {
		return tasks.remove();
	}

	@Override
	public int size() throws RemoteException {
		return tasks.size();
	}
}