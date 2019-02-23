package naimaier.todolist.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import naimaier.todolist.model.Role;
import naimaier.todolist.repository.Roles;

@Repository
public class RoleDao implements Roles{

	@PersistenceContext
	EntityManager manager;

	@Override
	public Role byName(String name) {
		return manager.find(Role.class, name);
	}

	@Override
	public void save(Role role) {
		manager.merge(role);
	}

	@Override
	public void delete(Role role) {
		manager.remove(role);
	}
	
	
}
