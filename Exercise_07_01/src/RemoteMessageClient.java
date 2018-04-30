import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteMessageClient extends UnicastRemoteObject implements ReplyTo, Serializable {

	private static final long serialVersionUID = 1L;
	private RemoteMessageList server;
	
	public RemoteMessageClient(String msg) throws MalformedURLException, RemoteException, NotBoundException {
		super();
		server = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
		server.addMessage(msg, this);
		System.out.println("SEND");
	}

	@Override
	public void replyMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		try {
			RemoteMessageClient client = new RemoteMessageClient("Test");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
