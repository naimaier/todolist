package naimaier.todolist.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import naimaier.todolist.model.Task;
import naimaier.todolist.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;

	@GetMapping("/user/tasks")
	public ModelAndView tasks() {
		ModelAndView modelAndView = new ModelAndView("list-tasks");
		modelAndView.addObject("tasks", taskService.listTasks());
		return modelAndView;
	}
	
	@PostMapping("/user/addTask")
	@Transactional
	public String addTask(Task task) {
		taskService.addTask(task);
		
		return "redirect:/user/tasks";
	}
	
	@PostMapping("/user/deleteTask")
	@Transactional
	public String deleteTask(Long id) {
		taskService.deleteTask(id);
		
		return "redirect:/user/tasks";
	}
	
	@PostMapping("/user/toggleFinished")
	@Transactional
	public void toggleFinished(Long id) {
		taskService.toggleFinished(id);
	}
	
}