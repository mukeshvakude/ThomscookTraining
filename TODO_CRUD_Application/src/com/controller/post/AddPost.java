package com.controller.post;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.Messages;
import com.bean.Post;
import com.bean.User;
import com.dao.PostDaoImplementation;
import com.helper.HelperFile;
import com.services.PostServices;
import com.services.PostServicesImplementation;

@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB)
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostDaoImplementation postdao = new PostDaoImplementation();
	PostServices service = new PostServicesImplementation(postdao);

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user") !=null) {
			String postTitle = request.getParameter("postTitle");
			String postDescription = request.getParameter("postDescription");
			int cat_id =Integer.parseInt( request.getParameter("catId"));
			Part postImage = request.getPart("postImage"); 
			User user = (User) session.getAttribute("user");

			int user_id = user.getId();
			InputStream myFile = null; // input stream of the upload file
			// obtains input stream of the upload file
			myFile = postImage.getInputStream();
			
			Post post = new Post(postTitle, postDescription, postImage.getSubmittedFileName(), cat_id, user_id);
			post.setMyFile(myFile);
			if(service.addPost(post)) {
				String path = "D:\\JavaWorkspace\\TODO_CRUD_Application\\WebContent\\PostFiles"+File.separator+ postImage.getSubmittedFileName();
				HelperFile.saveFile(postImage.getInputStream(), path);
				response.getWriter().println("done");
			}else {
				response.getWriter().println("not inserted");
			}
			
			/*response.getWriter().println("done");*/
			
		}
		else {
			HttpSession session1 = request.getSession();
			Messages msg = new Messages("login first", "error", "alert-danger");
			session1.setAttribute("message", msg);
			response.sendRedirect("login.jsp");
		}
	}

}
