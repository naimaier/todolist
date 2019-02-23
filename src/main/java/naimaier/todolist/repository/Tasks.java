package naimaier.todolist.repository;

import java.util.List;

import naimaier.todolist.model.Task;
import naimaier.todolist.model.User;

public interface Tasks {
	public Task byId(Long id);
	public List<Task> byUser(User user);
	
	public void save(Task task);
	public void delete(Task task);
}
