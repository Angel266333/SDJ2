
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiServer extends UnicastRemoteObject implements ServerInterface {

	private static final long serialVersionUID = -8430408026050442369L;
	private ClientInterface client2;

	public RmiServer() throws RemoteException {
		super();
	} 
	
	@Override
	public String toUpperCase(String msg, Object client) throws RemoteException {
		System.out.println("toUpperCase: client = " + client);
		if (client != null) {
			ClientInterface cb = (ClientInterface) client;
			cb.show(client, msg.toUpperCase());
		}
		return msg.toUpperCase();
	}
	
	public static void main(String[] args) {
		
		try {
			Registry reg = LocateRegistry.createRegistry(1099); 
			System.setProperty("java.security.policy", "security.policy");
			ServerInterface rmiServer = new RmiServer();
			Naming.rebind("RMIServer", rmiServer);
			System.out.println("Starting server...");
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

	
}
