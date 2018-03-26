package tasklist.domain.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.google.gson.Gson;

import tasklist.domain.model.Task;

public class TaskListClient implements TaskListModel {
	private Queue<Task> tasks;
	public Task taskObj;

	public Socket socket;
	public BufferedReader in;
	public PrintWriter out;

	public String host;
	public int port;

	public TaskListClient() {
		tasks = new ConcurrentLinkedQueue<Task>();
	}

	public synchronized void add(Task task) {
		
		tasks.add(task);
	}

	public synchronized Task getAndRemoveNextTask() {
		return tasks.poll();
	}

	public synchronized int size() {
		return tasks.size();
	}

	public String toString() {
		return "Tasks=" + tasks;
	}

	@Override
	public Task get() {
		return this.taskObj;

	}

	private Package request() {

		String msgBody = "";
		Gson gson = new Gson();
		Package received = new Package(msgBody);
		try {
			socket = new Socket(host, port);
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			do {
				Package pkg = new Package(msgBody);
				out.println(gson.toJson(msgBody));
				received = pkg;
			} while (!msgBody.equals("EXIT"));

		} catch (IOException e) {
			System.out.println("Connection error");
			e.printStackTrace();
		}
		return received;
	}

}