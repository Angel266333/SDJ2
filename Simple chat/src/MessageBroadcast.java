package src;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MessageBroadcast {

	private List<ServerConnection> conns = new ArrayList<>();

	public MessageBroadcast() {
	}

	public void addConnection(ServerConnection conn) {
		conns.add(conn);
	}

	public void handleMessages(Message msg, ServerConnection sender) {
		for (ServerConnection e : conns) {
			if (!e.equals(sender)) {
				try {
					ObjectOutputStream outToClient = e.outToClient;
					outToClient.writeObject(msg);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
