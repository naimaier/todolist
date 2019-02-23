package naimaier.todolist.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import naimaier.todolist.dao.TaskDao;
import naimaier.todolist.dao.UserDao;
import naimaier.todolist.model.Task;
import naimaier.todolist.repository.Tasks;
import naimaier.todolist.repository.Users;

@Controller
public class ToDoController {
	private final Tasks tasks;
	private final Users users;

	@Autowired
	public ToDoController(TaskDao tasks, UserDao users) {
		super();
		this.tasks = tasks;
		this.users = users;
	}

	@GetMapping("/user/tasks")
	public ModelAndView tasks() {
		ModelAndView modelAndView = new ModelAndView("list-tasks");
		modelAndView.addObject("tasks", listTasks());
		return modelAndView;
	}
	
	@PostMapping("/user/addTask")
	@Transactional
	public String addTask(Task task) {
		task.setUser(users.getActive());
		
		tasks.save(task);
		
		return "redirect:/user/tasks";
	}
	
	@PostMapping("/user/deleteTask")
	@Transactional
	public String deleteTask(Long id) {
		tasks.delete(tasks.byId(id));
		return "redirect:/user/tasks";
	}
	
	@PostMapping("/user/toggleFinished")
	@Transactional
	public void toggleFinished(Long id) {
		Task task = tasks.byId(id);
		task.setFinished(!task.isFinished());
		tasks.save(task);
	}
	
	public List<Task> listTasks(){
		return tasks.byUser(users.getActive());
	}
	
}