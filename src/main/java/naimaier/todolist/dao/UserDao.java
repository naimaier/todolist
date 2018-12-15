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

	/**
	 * Verify username and password and return a complete User object from the database (with id) if successful.
	 * Returns null if the verification fails.
	 */
	public User validate(User validateUser) {
		String sql = "select * from user where email=? and password=?";
		User user = null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, validateUser.getEmail());
			stmt.setString(2, validateUser.getPassword());
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				user = new User();
				user.setId(resultSet.getLong("id"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
			}
			
			resultSet.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
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
