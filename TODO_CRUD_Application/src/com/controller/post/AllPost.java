package com.controller.post;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Post;
import com.dao.*;
import com.services.PostServices;
import com.services.PostServicesImplementation;

@WebServlet("/allPost")
public class AllPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostDaoImplementation postdao = new PostDaoImplementation();
	PostServices service = new PostServicesImplementation(postdao);

	public AllPost() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Post> posts = new ArrayList<>();
		service.getAllPost();
		request.setAttribute("posts", posts);
		
		request.getRequestDispatcher("AllPost.jsp").forward(request, response);;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
