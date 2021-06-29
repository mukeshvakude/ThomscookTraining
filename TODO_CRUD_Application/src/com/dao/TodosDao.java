package com.dao;

import java.util.List;


import com.bean.Todos;
import com.bean.User;

public interface TodosDao {


	Todos getTodo(int id);
	List<Todos> getAllTodos();
	boolean insertTodo(Todos todo , User user);
	boolean updateTodo(Todos todo);
	boolean deleteTodo(int id);
}
