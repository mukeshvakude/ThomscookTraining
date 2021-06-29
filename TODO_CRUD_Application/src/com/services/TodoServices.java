package com.services;

import java.util.List;

import com.bean.Todos;
import com.bean.User;

public interface TodoServices {

	Todos getTodo(int id);
	List<Todos> getAllTodos();
	boolean insertTodo(Todos todo , User user);
	boolean updateTodo(Todos todo);
	boolean deleteTodo(int id);
}
