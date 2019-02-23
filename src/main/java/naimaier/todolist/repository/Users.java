package naimaier.todolist.repository;

import naimaier.todolist.model.User;

public interface Users {
	public User byId(Long id);
	public User byName(String name);
	
	public void save(User user);
	public void delete(User user);
	public User getActive();
}
