package naimaier.todolist.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import naimaier.todolist.dao.UserDao;
import naimaier.todolist.model.User;
import naimaier.todolist.repository.Users;

@Controller
public class LoginController {
	private final Users users;

	@Autowired
	public LoginController(UserDao users) {
		super();
		this.users = users;
	}
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "login-form";
	}
	
	@RequestMapping("createAccountForm")
	public String createAccountForm() {
		//TODO return "create-account";
		return null;
	}
	
	@RequestMapping("login")
	public String login(User user, HttpSession session) {
		user = users.validate(user);
		if (user != null) {
			session.setAttribute("loggedUser", user);
			return "redirect:tasks";
		}
		return "redirect:loginForm"; //chama o metodo que despacha para o jsp.
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginForm";
	}
}
