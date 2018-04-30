package tasklist.domain.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import tasklist.domain.model.Task;

public class TaskListCommunicationThreadHandler implements Runnable {

	private PrintWriter out;
	private BufferedReader in;
	private Socket socket;
	private String ip;
	private TaskListModel taskListModel;

	public TaskListCommunicationThreadHandler(TaskListModel taskListModel, Socket socket) {
		this.socket = socket;
		this.taskListModel = taskListModel;

		try {

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			this.ip = socket.getInetAddress().getHostAddress();
			System.out.println(ip + " connected");

		} catch (IOException e) {
			System.out.println("Error for client connection. Message: " + e.getMessage());
		}
	}

	@Override
	public void run() {

		boolean continueCommunicating = true;

		try {

			String clientInput = in.readLine();

			// convert from Json
			Gson gson = new Gson();
			Package request = gson.fromJson(clientInput, Package.class);
			System.out.println("package: " + request);

			Package reply = operation(request);

			// convert to Json

			gson = new Gson();
			String json = gson.toJson(reply);
			out.println(json);
			System.out.println("Server to " + ip + "> " + reply);
			if (reply.getText().equalsIgnoreCase("EXIT")) {
				continueCommunicating = false;

			}
			System.out.println("Closing connection to client " + ip);

		} catch (Exception e) {

			String message = e.getMessage();
			if (message == null) {

				message = "Connection lost";
			}
			System.out.println("Error to client: " + ip + " - Message" + message);
		} finally {
			System.out.println("Closing...");
			out.close();
			try {
				in.close();
				socket.close();
			} catch (IOException e) {
				System.out.println("Closing error");
				e.printStackTrace();
			}
		}
	}

	private Package operation(Package request) {

		switch (request.getText()) {
		case Package.ADD:
			taskListModel.add(request.getTask());
			return new Package(Package.ADD);

		case Package.GET:
			Task nextTask = taskListModel.get();
			if (nextTask == null) {
				return new Package(Package.GET, nextTask);
			}
		case Package.SIZE:
			int size = taskListModel.size();
			return new Package("SIZE = " + size, null);
		case Package.EXIT:
			return new Package("EXIT", null);
		default:
			return new Package("WRONG FORMAT", null);
		}
	}
}