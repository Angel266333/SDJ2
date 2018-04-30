import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

	private ServerSocket welcomeSocket;
	private final int PORT;
	private LogList log;

	public ChatServer(int port) {

		this.PORT = port;
		log = new LogList();
	}

	public void execute() {
		Socket client;
		try {
			welcomeSocket = new ServerSocket(PORT);
			System.out.println("Server is up");

			while (true) {
				System.out.println("Listening for clients...");
				client = welcomeSocket.accept();
				Thread t = new Thread();
				t.setDaemon(true);
				t.start();
			}
		} catch (IOException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}
	}
}