import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private Socket client;
	private PrintWriter out;
	private BufferedReader in;
	private String userName;

	public Client(String userName) {
		this.userName = userName;
	}

	public void startConnection(String ip, int port) {
		try {
			System.out.println("Trying to connect...");
			String message;
			String response;
			client = new Socket(ip, port);
			System.out.println("Connected!");
			out = new PrintWriter(client.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("Sending: " + userName);
			out.println(userName);
			response = in.readLine();
			System.out.println("Response: " + response);
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client("ClientInc");
		client.startConnection("localhost", 2910);
	}

}
