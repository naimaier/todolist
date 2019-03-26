package naimaier.todolist.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import naimaier.todolist.dao.RoleDao;
import naimaier.todolist.dao.UserDao;
import naimaier.todolist.model.Role;
import naimaier.todolist.model.User;
import naimaier.todolist.repository.Roles;
import naimaier.todolist.repository.Users;

@Service
public class UserService {

	private Users users;
	private Roles roles;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserDao user, RoleDao roles) {
		this.users = user;
		this.roles = roles;
	}
	
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(Arrays.asList(roles.byName("USER"))));
		users.save(user);
	}
	
	public void saveAdmin(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(Arrays.asList(roles.byName("USER"), roles.byName("ADMIN"))));
		users.save(user);
	}
	
	public void deleteUser(Long id) {
		users.delete(users.byId(id));
	}
	
	public List<User> listUsers() {
		return users.listAll();
	}
	
	public User getActive() {
		return users.getActive();
	}
	
}
