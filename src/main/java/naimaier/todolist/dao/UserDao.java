package naimaier.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import naimaier.todolist.model.User;
import naimaier.todolist.repository.Users;

@Repository
public class UserDao implements Users{
	private Connection connection;

	@Autowired
	public UserDao(DataSource dataSource) {
		super();
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public User byId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validate(User user) {
		String sql = "select * from user where email=? and password=?";
		boolean valid=false;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			ResultSet resultSet = stmt.executeQuery();
			valid = resultSet.next();
			
			resultSet.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return valid;
	}

	public void create(User user) {
		// TODO Auto-generated method stub
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
