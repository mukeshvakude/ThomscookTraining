package com.services;

import java.util.List;


import com.bean.User;

public interface UserServices {

		User getUser(int id);
		List<User> getAllUsers();
		User getUserByUserNameAndPassword(String username, String password);
	 	boolean insertUser(User user);
	    boolean updateUser(User user);
	    boolean deleteUser(int id);
	    boolean getUserByUsername(String username);
}
