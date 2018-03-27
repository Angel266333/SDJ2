package src;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerConnection implements Runnable {

	private Socket clientSocket;
	private MessageBroadcast mb;
	ObjectOutputStream outToClient;

	public ServerConnection(Socket connectionSocket, MessageBroadcast mb) {
		clientSocket = connectionSocket;
		this.mb = mb;
	}

	@Override
	public void run() {

		try {
			outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
			ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());
			while (true) {
				// message from client
				Message message = (Message) inFromClient.readObject();
				// sent reply to client
				Message replyMessage = new Message(message.getId(), message.getBody().toUpperCase());
				outToClient.writeObject(replyMessage);
				mb.handleMessages(replyMessage, this);
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
