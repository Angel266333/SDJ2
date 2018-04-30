package tasklist.controller;

import tasklist.domain.mediator.TaskListModel;

import tasklist.view.TaskListView;

import tasklist.domain.model.Task;

public class ClientTaskListController {
	
	private TaskListModel model;
	private TaskListView view;
	

	public ClientTaskListController(TaskListModel model, TaskListView view) {
		
		this.model = model;
		this.view = view;
		
	}
	
	public void execute(int choice) {
		
		switch(choice) {
		
		case 1:
			String taskDesc = view.get("Enter task description");
			long time = Long.parseLong(view.get("Enter task time"));
			model.add(new Task(taskDesc, time));
			break;
		case 2:
			view.show(model.get().toString());
			break;
		case 3:
			view.show(model.get().toString());
			break;
		case 0:
			System.exit(1);
			break;
		}
		
	}
	
}