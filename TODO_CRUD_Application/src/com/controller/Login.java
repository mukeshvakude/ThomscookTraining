package com.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.*;
import com.dao.*;
import com.services.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImplementation dao = new UserDaoImplementation();
	//	Loose coupling / dynamic polymorprism
	UserServices service = new UserServicesImplementation(dao);
	public Login() {
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = service.getUserByUserNameAndPassword(username, password);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			System.out.println("user activated"+user);
			response.sendRedirect("home");
		}else {
			System.out.println("invalide credentials");
			Messages msg = new Messages("invalide credentials", "error", "alert-danger");
			HttpSession s = request.getSession();
			s.setAttribute("message", msg);
			response.sendRedirect("login.jsp");
		}
	}





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
