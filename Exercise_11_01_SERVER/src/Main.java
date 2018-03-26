import java.util.Scanner;

import tasklist.domain.model.TaskList;

import tasklist.domain.model.Task;

public class Main {
	public static void main(String args[]) {
		TaskList taskList = new TaskList();
		Scanner input = new Scanner(System.in);
		boolean continueWorking = true;
		while (continueWorking) {
			System.out.print("1) Type 1 for \"ADD\"\n" + "2) Type 2 to \"GET\"" + "\n3) Type 3 to get the \"SIZE\"\n"
					+ "0) Type 0 to \"EXIT\"\nEnter choice: ");
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				String what = "task";
				System.out.print("Enter " + what + ": ");
				String taskText = input.nextLine();
				what = "estimated task time";
				System.out.print("Enter " + what + ": ");
				String taskTime = input.nextLine();
				long time = -1;
				try {
					time = Long.parseLong(taskTime);
				} catch (NumberFormatException e) {
				}
				Task task = new Task(taskText, time);
				taskList.add(task);
				System.out.println("ADDED: " + task);
				break;
			case 2:
				task = taskList.getAndRemoveNextTask();
				System.out.println("Task: " + task);
				break;
			case 3:
				int size = taskList.size();
				System.out.println("Size=" + size);
				break;
			case 0:
				System.exit(1);
				break;
			}
			if (choice == 0) {
				continueWorking = false;
			}
		}
		input.close();
	}
}