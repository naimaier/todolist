package naimaier.todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task implements Comparable<Task> {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private boolean finished;
	
	@ManyToOne
	private User user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int compareTo(Task anotherTask) {
		if (this.id < anotherTask.id) {
			return -1;
		}
		if (this.id > anotherTask.id) {
			return 1;
		}
		return 0;
	}


}
