package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDaoImplementation;
import com.services.UserServices;
import com.services.UserServicesImplementation;


@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDaoImplementation dao = new UserDaoImplementation();
	UserServices service = new UserServicesImplementation(dao);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("in delete"+id);
		if(service.deleteUser(id))
		{
			request.getRequestDispatcher("home").forward(request, response);
		}else {
			System.out.println(" delete error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
