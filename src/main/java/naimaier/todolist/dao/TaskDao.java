package naimaier.todolist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import naimaier.todolist.model.Task;
import naimaier.todolist.model.User;
import naimaier.todolist.repository.Tasks;

@Repository
public class TaskDao implements Tasks{
	
	@PersistenceContext
	EntityManager manager;
	
	public Task byId(Long id) {
		return manager.find(Task.class, id);
	}

	public List<Task> byUser(User user) {
		try {
			return manager
					.createQuery("select t from Task t where t.user = :user", Task.class)
					.setParameter("user", user)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void save(Task task) {
		manager.merge(task);
	}

	public void delete(Task task) {
		manager.remove(task);
	}

}
