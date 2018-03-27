package src;

import java.io.IOException;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, UnknownHostException{
		ChatView cv = new ChatView();
		cv.start();			
	}

}
