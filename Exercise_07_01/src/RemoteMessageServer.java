import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer extends UnicastRemoteObject implements RemoteMessageList, Serializable {

	private ArrayList<String> list;
	private static final long serialVersionUID = 1L;

	public RemoteMessageServer() throws RemoteException {
		super();
		list = new ArrayList<String>();
	}

	@Override
	public void addMessage(String msg, ReplyTo who) throws RemoteException {
		list.add(msg);
		System.out.println("Added: " + msg);
		who.replyMessage("Thank you");

	}

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			RemoteServer rmiServer = new RemoteMessageServer();
			Naming.rebind("addMessage", rmiServer);
			System.out.println("Server is up");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

}