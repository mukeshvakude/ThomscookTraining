package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;

import com.dao.UserDaoImplementation;
import com.services.UserServices;
import com.services.UserServicesImplementation;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImplementation dao = new UserDaoImplementation();
	//loose coupling
	UserServices service = new UserServicesImplementation(dao);
	public Registration() {
		super();
		System.out.println(" registration ");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobileNumber");
		String message =null;
		System.out.println("username"+username);
		
		if(!(service.getUserByUsername(username))) {
			
			User user = new User(username,password,email,mobileNumber);
			
			
			if(service.insertUser(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				message = "done";
				out.println(message);
			}
			else {
//				out.println("<h2>record not inserted </h2>");
//				response.sendRedirect("login.jsp");
//				System.out.println("not inserted");
				message = "user inserting user";
				out.println(message);
			}	
			
		}else {
			System.out.println("user aleready present");
			message = "user Already present";
			out.println(message);
		}
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
