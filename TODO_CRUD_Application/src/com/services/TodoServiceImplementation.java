package com.services;
import java.util.List;


import com.bean.Todos;
import com.bean.User;
import com.dao.TodosDao;

public class TodoServiceImplementation implements TodoServices {

	TodosDao todosDao;
	public TodoServiceImplementation(TodosDao todosDao) {
		super();
		this.todosDao = todosDao;
	}
	@Override
	public Todos getTodo(int id) {
		// TODO Auto-generated method stub
		return todosDao.getTodo(id);
	}

	@Override
	public List<Todos> getAllTodos() {
		// TODO Auto-generated method stub
		return todosDao.getAllTodos();
	}

	@Override
	public boolean insertTodo(Todos todo, User user) {
		// TODO Auto-generated method stub
		return todosDao.insertTodo(todo, user);
	}

	@Override
	public boolean updateTodo(Todos todos) {
		// TODO Auto-generated method stub
		return todosDao.updateTodo(todos);
	}

	@Override
	public boolean deleteTodo(int id) {
		// TODO Auto-generated method stub
		return todosDao.deleteTodo(id);
	}

}
