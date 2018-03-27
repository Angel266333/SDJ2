import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote
{
	public String show(Object from, String msg) throws RemoteException;
}