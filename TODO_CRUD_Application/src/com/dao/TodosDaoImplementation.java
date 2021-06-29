package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;


import com.bean.Todos;
import com.bean.User;
import com.configuration.*;
public class TodosDaoImplementation implements TodosDao{


	ConnectionFactory connectionFactory;
	public TodosDaoImplementation () {
		// connection object available for whole code
		connectionFactory = new ConnectionFactory();
	}
	

	private Todos extractTodosFromResultSet(ResultSet rs) throws SQLException {
		Todos todo1 = new Todos();
		todo1.setTodo_id(rs.getInt(1));
		todo1.setTitle(rs.getString(2));
		todo1.setDescriptions(rs.getString(3));
		todo1.setTarget_date(rs.getDate(4).toLocalDate());
		todo1.setStatus(rs.getBoolean(5));
		todo1.setUser_id(rs.getInt(6));
		return todo1;
	}

	@Override
	public Todos getTodo(int id) {
		Connection connection = null;
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM todos WHERE todo_id = "+id);
			Todos todo = new Todos();
			while(rs.next()) {
				todo.setTodo_id(rs.getInt(1));
				todo.setUser_id(rs.getInt("user_id"));
				todo.setTitle(rs.getString("title"));
				todo.setDescriptions(rs.getString("description"));
				todo.setTarget_date( rs.getDate("target_date").toLocalDate());
				todo.setStatus(rs.getBoolean("status"));
			}
//			System.out.println("todos"+todo);
			return todo;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Todos> getAllTodos() {
		Connection connection = null;
		try {
			connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM todos");
			List<Todos> todos = new ArrayList<>();
			while(rs.next())
			{
				Todos todo =  extractTodosFromResultSet(rs);
				todos.add(todo);
				
			}
			return todos;
		} catch (SQLException e) {
			// TODO: handle exception
		}


		return null;
	}



	@Override
	public boolean insertTodo(Todos todo, User user) {
		Connection connection = null;
		
		try {
			
			connection = connectionFactory.getConnection();
			
			String sql = "insert into todos(title,description,target_date,status,user_id) values(?,?,?,?,?)";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, todo.getTitle());
			stmt.setString(2, todo.getDescriptions());
			stmt.setDate(3, ConnectionFactory.getSQLDate(todo.getTarget_date()));
			stmt.setBoolean(4, todo.isStatus());
			stmt.setInt(5, user.getId());
			int i = stmt.executeUpdate();
			
			if(i==1)
				return true;

		} catch (SQLException e) {
			System.out.println(" todo errrror ");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTodo(Todos todo) {
		Connection connection = null;
		try {
	    	connection = connectionFactory.getConnection();
	        PreparedStatement ps = connection.prepareStatement("UPDATE todos SET title=?,description=?, target_date=?,status=?  WHERE todo_id=?");
	        ps.setString(1, todo.getTitle());
	        ps.setString(2, todo.getDescriptions());
	        ps.setDate(3, ConnectionFactory.getSQLDate(todo.getTarget_date()));
	        ps.setBoolean(4, todo.isStatus());
	        ps.setInt(5, todo.getTodo_id());
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
	public boolean deleteTodo(int id) {
		Connection connection = null;
		try {
			connection = connectionFactory.getConnection();
			PreparedStatement statement = connection.prepareStatement("Delete from todos where todo_id = "+id);
			int i = statement.executeUpdate();
			if(i==1)
				return true;
		} catch (SQLException e) {
			System.out.println("error delete todo"+e.getMessage());
		}
		return false;
	}

}
