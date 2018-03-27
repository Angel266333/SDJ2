package src;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		boolean isConnected = true;
		final int PORT = 2910;
		System.out.println("Starting Server...");
		MessageBroadcast mb = new MessageBroadcast();
		ServerSocket welcomeSocket = new ServerSocket(PORT);

		while (isConnected) {
			System.out.println("Waiting for a client...");

			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("Connection from " + connectionSocket.getInetAddress().getHostAddress());
			ServerConnection c = new ServerConnection(connectionSocket, mb);
			mb.addConnection(c);
			new Thread(c, "Communication ").start();

		}
		welcomeSocket.close();
	}

}
