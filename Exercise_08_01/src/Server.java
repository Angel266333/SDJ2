import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;

public class Server {

	public static final int registryNo = 1099;

	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(registryNo);
			RemoteServer rmiServer = new RmiTaskServer();
			Naming.rebind("server", rmiServer);
			System.out.println("Server is up");
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
}