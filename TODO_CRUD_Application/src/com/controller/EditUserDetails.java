package com.controller;

import com.bean.User;
import com.dao.*;
import com.services.UserServices;
import com.services.UserServicesImplementation;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditUserDetails
 */
@WebServlet("/edit")
public class EditUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImplementation dao = new UserDaoImplementation();
	UserServices service = new UserServicesImplementation(dao);
	
    public EditUserDetails() {
        super();
         }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user  = service.getUser(id);
		request.setAttribute("user", user);
		System.out.println("user"+ user);
		request.getRequestDispatcher("edituser.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1 = request.getParameter("id");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String mobileNumber = request.getParameter("mobileNumber");
		String password = request.getParameter("password");
		int id = Integer.parseInt(id1);
		System.out.println("here......");
		User user = new User(id , username, password, email, mobileNumber);
		
		if(service.updateUser(user)) {
			response.sendRedirect("home");
		}
		else {
			
			System.out.println("edit error");
		}		
		
	}

}
