package naimaier.todolist.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import naimaier.todolist.model.User;
import naimaier.todolist.service.UserService;

@Controller
public class SecurityController {

	@Autowired
	UserService userService;

	@RequestMapping("createUser")
	@Transactional
	public String createUser(User user, @RequestParam(defaultValue="false") Boolean admin, @RequestParam(defaultValue="false") Boolean managing) {
		if (admin) {
			userService.saveAdmin(user);
		} else {
			userService.saveUser(user);
		}
		if (managing) {
			return "redirect:/admin/users";
		} else {
			return "redirect:login";
		}
	}
	
	@RequestMapping("/admin/users")
	public ModelAndView users() {
		ModelAndView modelAndView = new ModelAndView("list-users");
		modelAndView.addObject("users", userService.listUsers());
		modelAndView.addObject("loggedUser", userService.getActive());
		return modelAndView;
	}
	
	@PostMapping("/admin/deleteUser")
	@Transactional
	public String deleteUser(Long id) {
		userService.deleteUser(id);
		return "redirect:users";
	}
}
