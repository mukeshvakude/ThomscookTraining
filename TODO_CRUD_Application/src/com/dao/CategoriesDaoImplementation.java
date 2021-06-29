package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.bean.Categories;

import com.configuration.ConnectionFactory;
import java.sql.*;
public class CategoriesDaoImplementation implements CategoriesDao {

	ConnectionFactory connection;

	ConnectionFactory connectionFactory;
	public CategoriesDaoImplementation() {
		// connection object available for whole code
		connectionFactory = new ConnectionFactory();
	}
	@Override
	public boolean addCategorie(Categories categories) {
		Connection con = null;

		try {
			con = connectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement("insert into categories values(?,?)");
			statement.setString(1, categories.getCat_title());
			statement.setString(2, categories.getCat_description());
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return false;

	}
	@Override
	public List<Categories> getAllCategories() {
		Connection con = null;
		con = connectionFactory.getConnection();
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select * from categories");

			ResultSet rs = statement.executeQuery();
			List<Categories> categories = new ArrayList<>();
			while(rs.next()) {
				Categories cat =new Categories();
				cat.setCat_id(rs.getInt(1));
				cat.setCat_title(rs.getString(2));
				cat.setCat_description(rs.getString(3));
				categories.add(cat);
			}
			return categories;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

/*
	@Override
	public List<Post> getAllPost() {
		Connection con = null;
		try {
			con = connectionFactory.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from post");
			ResultSet rs = statement.executeQuery();
			List<Post> posts = new ArrayList<>();
			while(rs.next()) {
				Post post=new Post();
				post.setPost_id(rs.getInt(1));
				post.setPostTitle(rs.getString(2));
				post.setPostDescription(rs.getString(3));
				post.setPostedDate(rs.getDate(4));
				post.setUser_id(rs.getInt(5));
				posts.add(post);
			}
			return posts;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

}
 */