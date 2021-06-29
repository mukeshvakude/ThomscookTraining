package com.controller.todo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TodosDaoImplementation;
import com.services.TodoServiceImplementation;
import com.services.TodoServices;

@WebServlet("/deletetodo")
public class DeleteTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   TodosDaoImplementation todosDao = new TodosDaoImplementation();
   TodoServices service = new TodoServiceImplementation(todosDao);
    public DeleteTodo() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("todoid"));
		if(service.deleteTodo(id)) {
			
			request.getRequestDispatcher("getAllTodos").forward(request, response);
		}else {
			response.sendRedirect("login.jsp");
		}
	}


}
