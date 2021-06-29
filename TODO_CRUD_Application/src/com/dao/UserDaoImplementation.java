package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


import com.bean.User;
import com.configuration.ConnectionFactory;

public class UserDaoImplementation implements UserDao {

	ConnectionFactory connectionFactory;
	public UserDaoImplementation() {
		// connection object available for whole code
		connectionFactory = new ConnectionFactory();
	}

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId( rs.getInt("user_id") );
		user.setUsername(rs.getString("username") );
		user.setPassword( rs.getString("password") );
		user.setEmail( rs.getString("email") );
		user.setMobileNumber( rs.getString("mobile_number") );
		return user;
	}
	@Override
	public User getUser(int id) {
		Connection connection = null;
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE user_id=" + id);
			if(rs.next())
			{
				return extractUserFromResultSet(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<User> getAllUsers() {

		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			List<User> users = new ArrayList<>();
			while(rs.next())
			{
				User user = extractUserFromResultSet(rs);
				users.add(user);
			}
			return users;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{	System.out.println("hello");
				 return extractUserFromResultSet(rs);
			}else {
				System.out.println("record not found");
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insertUser(User user) {

		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("INSERT INTO users(username,password,email,mobile_number) VALUES (?, ?, ?, ?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobileNumber());
			int i = ps.executeUpdate();
			if(i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE users SET username=?,password=?, email=? ,mobile_number=? WHERE user_id=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobileNumber());
			ps.setInt(5, user.getId());
			int i = ps.executeUpdate();
			if(i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(int id) {

		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			int i = stmt.executeUpdate("DELETE FROM users WHERE user_id=" + id);
			System.out.println(i);
			if(i == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean getUserByUsername(String username) {
		
		try {
			Connection connection = connectionFactory.getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
			else {
				return false;
			}
				
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}


