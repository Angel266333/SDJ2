import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RmiClient implements ClientInterface {

	@Override
	public String show(Object from, String msg) throws RemoteException {
		System.out.println(msg + " from " + from.toString());
		return msg;
	}
	
	public static void main(String args[]) {
		try {
			ClientInterface client = new RmiClient();
			System.out.println("Exporting the client object...");
			UnicastRemoteObject.exportObject(client, 0);
			String serverUrl = "rmi://127.0.0.1:1099/RMIServer";
			ServerInterface server = (ServerInterface) Naming.lookup(serverUrl);
			String str;
			while(true) {
				System.out.print("Enter new message: ");
				Scanner scanner = new Scanner(System.in);
				str = scanner.nextLine();
				if (str != null) {
					server.toUpperCase(str, client);
				}
				
			}
		} catch (Exception e) {
			System.out.println("Exception while sending a message " + "\n" + e.getMessage());
		}
	}

}
