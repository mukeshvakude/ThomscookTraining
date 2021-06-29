package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDao {

	    User getUser(int id);
	    List<User> getAllUsers();
	    User getUserByUserNameAndPassword(String user, String pass);
	    boolean insertUser(User user);
	    boolean updateUser(User user);
	    boolean deleteUser(int id);
		boolean getUserByUsername(String username);

}
