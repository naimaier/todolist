package naimaier.todolist.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import naimaier.todolist.model.User;
import naimaier.todolist.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	UserService userService;

	@RequestMapping("createUser")
	@Transactional
	public String createUser(User user) {
		userService.saveAdmin(user);
		return "redirect:login";
	}
	
}
