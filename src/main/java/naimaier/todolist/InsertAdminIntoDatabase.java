package naimaier.todolist;

import org.springframework.beans.factory.annotation.Autowired;

import naimaier.todolist.model.User;
import naimaier.todolist.service.UserService;

public class InsertAdminIntoDatabase {
	@Autowired
	UserService userService;

	public InsertAdminIntoDatabase() {
		
		User user = new User("admin@admin.com", "admin");
		userService.saveAdmin(user);
	}
	
	
}