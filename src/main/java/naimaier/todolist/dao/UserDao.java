package naimaier.todolist.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import naimaier.todolist.facade.AuthenticationFacade;
import naimaier.todolist.model.User;
import naimaier.todolist.repository.Users;

@Repository
public class UserDao implements Users, UserDetailsService{

	@PersistenceContext
	EntityManager manager;

	public User byId(Long id) {
		return manager
				.find(User.class, id);
	}
	
	public User byName(String name) {
		return manager
				.createQuery("select u from User u where u.email = :email", User.class)
				.setParameter("email", name)
				.getSingleResult();
	}

	public void save(User user) {
		manager.merge(user);
	}

	public void delete(User user) {
		manager.remove(user);
	}

	public User getActive() {
		String username = new AuthenticationFacade().getAuthentication().getName();
		return this.byName(username); 
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return byName(username);
	}
}
