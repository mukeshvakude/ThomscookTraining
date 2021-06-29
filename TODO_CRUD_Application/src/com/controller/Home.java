package com.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Messages;
import com.bean.User;
import com.dao.*;
import com.services.*;
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDaoImplementation dao = new UserDaoImplementation();
	UserServicesImplementation service = new UserServicesImplementation(dao);
	public Home() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") !=null) {
			
//			User activeUser = (User) session.getAttribute("user");
//			session.setAttribute("activeuser", activeUser.getUsername());
			List<User> user_list = service.getAllUsers();
			request.setAttribute("userlist", user_list);
			request.getRequestDispatcher("home.jsp").forward(request, response);

		}else {
			
			HttpSession session1 = request.getSession();
			Messages msg = new Messages("login first", "error", "alert-danger");
			session1.setAttribute("message", msg);
			response.sendRedirect("login.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
