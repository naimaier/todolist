package naimaier.todolist.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import naimaier.todolist.dao.TaskDao;
import naimaier.todolist.model.Task;
import naimaier.todolist.model.User;
import naimaier.todolist.repository.Tasks;

@Controller
public class ToDoController {
	private final Tasks tasks;

	@Autowired
	public ToDoController(TaskDao tasks) {
		super();
		this.tasks = tasks;
	}

	@RequestMapping("tasks")
	public String tasks(Model model, HttpSession session) {
		model.addAttribute("tasks", listTasks(session));
		return "list-tasks";
	}
	
	@RequestMapping("addTask")
	public String addTask(Task task, HttpSession session) {
		Long userId = ((User) session.getAttribute("loggedUser")).getId();
		task.setUserId(userId);
		
		tasks.create(task);
		
		return "redirect:tasks";
	}
	
	@RequestMapping("deleteTask")
	public String deleteTask(Long id) {
		tasks.delete(tasks.byId(id));
		return "redirect:tasks";
	}
	
	@RequestMapping("toggleFinished")
	public void toggleFinished(Long id) {
		Task task = tasks.byId(id);
		task.setFinished(!task.isFinished());
		tasks.update(task);
	}
	
	public List<Task> listTasks(HttpSession session){
		User user = (User) session.getAttribute("loggedUser");
		
		return tasks.byUser(user);
	}
	
}