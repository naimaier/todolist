package naimaier.todolist.repository;

import naimaier.todolist.model.Role;

public interface Roles {
	public Role byName(String name);
	public void save(Role role);
	public void delete(Role role);
}
