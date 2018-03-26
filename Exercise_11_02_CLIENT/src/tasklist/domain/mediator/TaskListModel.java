package tasklist.domain.mediator;

import tasklist.domain.model.Task;

public interface TaskListModel {

	public void add(Task task);

	public Task get();

	public int size();
}
