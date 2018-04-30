import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiTaskClient implements Serializable {

	private static final long serialVersionUID = 1L;
	private RemoteTaskList server;

	public RmiTaskClient() {
		try {
			server = (RemoteTaskList) Naming.lookup("rmi://localhost:" + Server.registryNo + "/server");
			server.add("test");
			System.out.println(server.size());
			System.out.println(server.remove());
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
