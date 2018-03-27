package src;

import java.io.ObjectInputStream;

public class ClientReceiver implements Runnable{
	
	private ObjectInputStream inFromServer;
	private ChatView view;
	
	public ClientReceiver(ObjectInputStream inFromServer, ChatView view) {
		System.out.println("Created client receiver");
		this.inFromServer = inFromServer;
		this.view = view;
	}

	@Override
	public void run() {
		try {
			while(true) {
				Message msg = (Message) inFromServer.readObject();
				view.updateMessages(msg.getId() + " : " +  msg.getBody());
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			view.updateMessages("Connection broke");
		}
		
	}

}
