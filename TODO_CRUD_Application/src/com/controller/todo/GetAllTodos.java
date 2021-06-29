package com.controller.todo;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Messages;
import com.bean.Todos;
import com.dao.TodosDaoImplementation;
import com.services.TodoServiceImplementation;
import com.services.TodoServices;

@WebServlet("/getAllTodos")
public class GetAllTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TodosDaoImplementation todoDao = new TodosDaoImplementation();
	TodoServices service = new TodoServiceImplementation(todoDao);

	public GetAllTodos() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") != null) {
			List<Todos> todos = service.getAllTodos();
			request.setAttribute("todolist", todos);
			//request.setAttribute("todo", null);
			for(Todos t:todos) {
				System.out.println("date"+t.getTarget_date());

			}
			request.getRequestDispatcher("todosList.jsp").forward(request, response);
		}else {
			Messages msg = new Messages("login first", "error", "alert-danger");
			HttpSession s = request.getSession();
			s.setAttribute("message", msg);
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
