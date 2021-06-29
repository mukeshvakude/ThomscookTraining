package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.configuration.ConnectionFactory;

public class LikedDaoImplementation implements LikedDao{

	ConnectionFactory connectionFactory;


	public LikedDaoImplementation() {
		// connection object available for whole code
		connectionFactory = new ConnectionFactory();
	}
	private boolean getPostByPostIdAndUserId(Connection con,int user_id , int post_id) {
		PreparedStatement statement = null;
		System.out.println("here");
		try {
			statement = con.prepareStatement("select * from likededisliked where user_id =? and post_id =?");	
			statement.setInt(1, user_id);
			statement.setInt(2, post_id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getInt(5));
				return true;
			}
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	private boolean UpdateLikeDislikeByPostIdAndUserId(Connection con, int user_id, int post_id, String action) throws SQLException {
		PreparedStatement statement = null;
		if(action.equals("liked")) {
			
			statement= con.prepareStatement("update likededisliked set liked=? , disliked=? where post_id =? and user_id= ?");
			statement.setInt(1, 1);
			statement.setInt(2, 0);
		}else {
			
			statement= con.prepareStatement("update likededisliked set liked=? , disliked=? where post_id =? and user_id= ?");
			statement.setInt(1, 0);
			statement.setInt(2, 1);
		}
		statement.setInt(3, post_id);
		statement.setInt(4, user_id);
		statement.executeUpdate();
		System.out.println("comm9ing");
		return true;
		
	}
	@Override
	public boolean likepost(int user_id, int post_id) {
		Connection con = null;

		try {
			con = connectionFactory.getConnection();
			if(false == getPostByPostIdAndUserId(con, user_id, post_id)) {
				PreparedStatement statement = con.prepareStatement("insert into likededisliked(post_id , user_id,liked,disliked) values(?,?,?,?)");
				statement.setInt(1, post_id);
				statement.setInt(2, user_id);
				statement.setInt(3, 1);
				statement.setInt(4, 0);
				statement.executeUpdate();
				
			}else {
				UpdateLikeDislikeByPostIdAndUserId(con, user_id, post_id, "liked");
			}
			return true;
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean dislikepost(int user_id, int post_id) {
		Connection con = null;
		try {
			con = connectionFactory.getConnection();
			if(false == getPostByPostIdAndUserId(con, user_id, post_id)) {
				PreparedStatement statement = con.prepareStatement("insert into likededisliked(post_id , user_id,liked,disliked) values(?,?,?,?)");
				statement.setInt(1, post_id);
				statement.setInt(2, user_id);
				statement.setInt(3, 0);
				statement.setInt(4, 1);
				statement.executeUpdate();
			}else {
				UpdateLikeDislikeByPostIdAndUserId(con, user_id, post_id, "disliked");
			}
			return true;
			
			

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public int getlikeCount(int post_id) {
		int count = 0;
		Connection con = null;
		System.out.println("hereeeeeeeeeeeee");
		try {
			con = connectionFactory.getConnection();
			System.out.println("Doneeeeeeeeeee");
			PreparedStatement statement = con.prepareStatement("select count(*) from likededisliked  where liked=? and disliked=? and post_id=?");
			statement.setInt(1, 1);
			statement.setInt(2, 0);
			statement.setInt(3, post_id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			System.out.println("count"+count);
			return count;

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public int getdislikeCount(int post_id) {
		int count = 0;
		Connection con = null;
		try {
			con = connectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement("select count(*) from likededisliked  where liked=? and disliked=? and post_id=?");
			statement.setInt(1, 0); // like 0
			statement.setInt(2, 1);// dislike 1
			statement.setInt(3, post_id);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
			return count;

		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return count;
	}

}
