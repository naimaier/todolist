package naimaier.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naimaier.todolist.model.Task;
import naimaier.todolist.model.User;
import naimaier.todolist.repository.Tasks;

@Repository
public class TaskDao implements Tasks{
	Connection connection;
	
	@Autowired
	public TaskDao(DataSource dataSource) {
		super();
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Task byId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Task> byUser(User user) {
		List<Task> tasks = new ArrayList<Task>();
		Task task;
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from task where user=?");
			stmt.setLong(1, user.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				task = new Task();
				task.setId(rs.getLong("id"));
				task.setDescription(rs.getString("description"));
				task.setFinished(rs.getBoolean("finished"));
				task.setUserId(rs.getLong("user"));
				
				tasks.add(task);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return tasks;
	}

	public void create(Task task) {
		String sql = "insert into task (description, user) values (?, ?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, task.getDescription());
			stmt.setLong(2, task.getUserId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}

	public void update(Task task) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Task task) {
		// TODO Auto-generated method stub
		
	}

}
