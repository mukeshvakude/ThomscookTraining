package com.controller.todo;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Todos;
import com.dao.TodosDaoImplementation;
import com.services.TodoServiceImplementation;
import com.services.TodoServices;


@WebServlet("/updateTodo")
public class UpdateTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TodosDaoImplementation todoDao = new TodosDaoImplementation();
	TodoServices service = new TodoServiceImplementation(todoDao);

	public UpdateTodo() {
		super();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int todo_id = Integer.parseInt(request.getParameter("todoid"));
		Todos todo = new Todos();
		todo = service.getTodo(todo_id);
		if(todo != null) {
			System.out.println("status ======="+todo.isStatus());
			request.setAttribute("todo", todo);
			request.getRequestDispatcher("TodoListEdit.jsp").forward(request, response);
		}

		else {
			response.sendRedirect("login.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String title = request.getParameter("title");
		String descriptions = request.getParameter("description");
		boolean  status = Boolean.valueOf(request.getParameter("isDone"));
		String date = request.getParameter("targetDate");
//		System.out.println(date+" 00:00:00.000000");

		LocalDate target_date = LocalDate.parse(date);
		System.out.println(target_date);
		int todo_id = Integer.parseInt(request.getParameter("todoid"));
		int user_id = Integer.parseInt(request.getParameter("userid"));

		Todos todo = new Todos(todo_id, user_id, title, descriptions, target_date,status);
		if(service.updateTodo(todo))
			request.getRequestDispatcher("getAllTodos").forward(request, response);
		else
			response.sendRedirect("login.jsp");
	}
}

