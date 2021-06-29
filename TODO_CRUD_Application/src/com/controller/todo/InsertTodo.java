package com.controller.todo;
import java.time.LocalDate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Messages;
import com.bean.Todos;
import com.bean.User;
import com.dao.TodosDaoImplementation;
import com.services.TodoServiceImplementation;
import com.services.TodoServices;


@WebServlet("/insertTodo")
public class InsertTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TodosDaoImplementation todoDao = new TodosDaoImplementation();
	TodoServices service = new TodoServiceImplementation(todoDao);

	public InsertTodo() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String title = request.getParameter("title");
		String descriptions = request.getParameter("description");
		boolean  status = Boolean.valueOf(request.getParameter("isDone"));
		String date = request.getParameter("targetDate");
		LocalDate target_date = LocalDate.parse(date);
		System.out.println("status "+ status);
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") == null) {
			HttpSession session1 = request.getSession();
			Messages msg = new Messages("login first", "error", "alert-danger");
			session1.setAttribute("message", msg);
			response.sendRedirect("login.jsp");
			
		}else {

			User user = (User) session.getAttribute("user");
			Todos todo = new Todos(user.getId(), title, descriptions, target_date, status);
			if(service.insertTodo(todo, user)) {
				request.getRequestDispatcher("getAllTodos").forward(request, response);
				
			}
		}

	}

}
