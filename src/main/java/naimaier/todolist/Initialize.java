package naimaier.todolist;

import org.springframework.beans.factory.annotation.Autowired;

import naimaier.todolist.model.User;
import naimaier.todolist.service.UserService;

public class Initialize {
	@Autowired
	UserService userService;

	public Initialize() {
		
		User user = new User("kurt@kurt.com", "kurt");
		userService.saveAdmin(user);
	}
	
	
}