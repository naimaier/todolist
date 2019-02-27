package naimaier.todolist.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import naimaier.todolist.dao.TaskDao;
import naimaier.todolist.dao.UserDao;
import naimaier.todolist.model.Task;
import naimaier.todolist.repository.Tasks;
import naimaier.todolist.repository.Users;

@Service
public class TaskService {

	private Tasks tasks;
	private Users users;
	
	@Autowired
	public TaskService(TaskDao tasks, UserDao users) {
		this.tasks = tasks;
		this.users = users;
	}
	
	public List<Task> listTasks() {
		List<Task> tasksList = tasks.byUser(users.getActive());
		
		Collections.sort(tasksList, Collections.reverseOrder());
		
		return tasksList;
	}
	
	public void addTask(Task task) {
		task.setUser(users.getActive());
		task.setFinished(false);
		
		tasks.save(task);
	}
	
	public void deleteTask(Long id) {
		tasks.delete(tasks.byId(id));
	}
	
	public void toggleFinished(Long id) {
		Task task = tasks.byId(id);
		task.setFinished(!task.isFinished());
		tasks.save(task);
	}
}
