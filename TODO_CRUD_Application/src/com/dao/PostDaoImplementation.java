package com.dao;

import java.util.ArrayList;
import java.util.List;
import com.bean.Post;
import com.configuration.ConnectionFactory;
import java.sql.*;
public class PostDaoImplementation implements PostDao {

	ConnectionFactory connection;

	ConnectionFactory connectionFactory;
	public PostDaoImplementation() {
		// connection object available for whole code
		connectionFactory = new ConnectionFactory();
	}


	@Override
	public boolean addPost(Post post) {

		Connection con = null;

		try {
			con = connectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement("insert into posts(post_title,post_description,user_id,cat_id,post_pic) values(?,?,?,?,?)");
			statement.setString(1, post.getPostTitle());
			statement.setString(2, post.getPostDescription());
			statement.setInt(3,post.getUser_id());
			statement.setInt(4, post.getCat_id());
			statement.setString(5, post.getPostImage());
			System.out.println("userid"+ post.getUser_id());
			int i = statement.executeUpdate();
			
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Post> getAllPost() {
		Connection con = null;
		try {
			con = connectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from posts order by post_id desc");
			ResultSet rs = statement.executeQuery();
			List<Post> posts = new ArrayList<>();
			while(rs.next()) {
				Post post=new Post();
				post.setPost_id(rs.getInt(1));
				post.setPostTitle(rs.getString(2));
				post.setPostDescription(rs.getString(3));
				post.setPostedDate(rs.getDate(4));
				post.setPostImage(rs.getString(5));
				post.setUser_id(rs.getInt(6));
				post.setCat_id(rs.getInt(7));
				posts.add(post);
			}
			return posts;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public List<Post> getPostByCategoryid(int catId) {
		Connection con = null;
		try {
			con = connectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from posts where cat_id = ? order by post_id desc");
			statement.setInt(1, catId);
			ResultSet rs = statement.executeQuery();
			List<Post> posts = new ArrayList<>();
			while(rs.next()) {
				Post post=new Post();
				post.setPost_id(rs.getInt(1));
				post.setPostTitle(rs.getString(2));
				post.setPostDescription(rs.getString(3));
				post.setPostedDate(rs.getDate(4));
				post.setPostImage(rs.getString(5));
				post.setUser_id(rs.getInt(6));
				post.setCat_id(rs.getInt(7));
				posts.add(post);
			}
			return posts;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return null;	}


}