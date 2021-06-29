package com.controller;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Messages;
import com.dao.UserDaoImplementation;
import com.services.UserServices;
import com.services.UserServicesImplementation;

@WebServlet("/logout")
public class Logout extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	String notification = null;
	UserDaoImplementation dao = new UserDaoImplementation();
	UserServices service = new UserServicesImplementation(dao);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession(false);
		System.out.println(session);
		if(session != null ) {
			session.invalidate();
			HttpSession session1 = request.getSession();
			Messages msg = new Messages("logout succussefully", "success", "alert-success");
			session1.setAttribute("message", msg);
			
			response.sendRedirect("login.jsp");
		}else {
			HttpSession session1 = request.getSession();
			Messages msg = new Messages("login first", "error", "alert-danger");
			session1.setAttribute("message", msg);
			response.sendRedirect("login.jsp");
			
		}
				
	}
}
