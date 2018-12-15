package naimaier.todolist.repository;

import naimaier.todolist.model.User;

public interface Users {
	public User byId(Long id);
	public User validate(User user);
	
	public void create(User user);
	public void update(User user);
	public void delete(User user);
}
