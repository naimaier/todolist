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
		String sql = "select * from task where id=?";
		Task task = null;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				task = new Task();
				task.setId(rs.getLong("id"));
				task.setDescription(rs.getString("description"));
				task.setFinished(rs.getBoolean("finished"));
				task.setUserId(rs.getLong("user"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return task;
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
		String sql = "update task set description=?, finished=?, user=? where id=? limit 1";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, task.getDescription());
			stmt.setBoolean(2, task.isFinished());
			stmt.setLong(3, task.getUserId());
			stmt.setLong(4, task.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Task task) {
		String sql = "delete from task where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, task.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
