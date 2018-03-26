package tasklist.view;

import java.util.Scanner;

import tasklist.controller.ClientTaskListController;

public class ClientTaskListConsole implements TaskListView, Runnable {

	private Scanner input;
	
	private ClientTaskListController controller;
	
	public ClientTaskListConsole() {
		input = new Scanner(System.in);
		
		this.controller = null;
	
	}		
		
	@Override
	public String get(String text) {
		System.out.println(text);
		return input.nextLine();
	
	}

	@Override
	public void show(String text) {
	System.out.println(text);	
	}

	@Override
	public void startView(ClientTaskListController controller) {
		
		this.controller = controller;
		Thread t = new Thread(this);
		t.start();
		
	}

	@Override
	public void run() {
		int choice;
		do {
		choice = Integer.parseInt(get
				("1) Type 1 for \"ADD\"\n"
					 + "2) Type 2 to \"GET\""
					 + "\n3) Type 3 to get the \"SIZE\"\n"
					 + "0) Type 0 to \"EXIT\"\nEnter choice: "));
			controller.execute(choice);
		} while (choice != 0);
	}
}
