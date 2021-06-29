package com.services;

import java.util.List;

import com.bean.User;
import com.dao.UserDao;


public class UserServicesImplementation implements UserServices{

	
//	UserDoa Object which used to communicate with database 
	UserDao dao;
	
	public UserServicesImplementation(UserDao dao) {
		super();
		this.dao = dao;
	}
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User getUser(int id) {
		return dao.getUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return  dao.getAllUsers();
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		return dao.getUserByUserNameAndPassword(username, password);
	}

	@Override
	public boolean insertUser(User user) {
		return dao.insertUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return dao.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		return dao.deleteUser(id);
	}

	@Override
	public boolean getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getUserByUsername(username) ;
	}

	

}
