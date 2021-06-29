package com.controller.post;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.bean.*;
import com.dao.LikedDaoImplementation;
import com.helper.JsonJackson;
import com.services.LikedServices;
import com.services.LikedServicesImplementation;


@WebServlet("/LikePost")
public class LikePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LikedDaoImplementation likedao = new LikedDaoImplementation();
	LikedServices service = new LikedServicesImplementation(likedao);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int post_id = Integer.parseInt(request.getParameter("postId"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String action = request.getParameter("action");

		response.setContentType("text/json");

		Liked liked = new Liked();
		if(session.getAttribute("user")!=null) {
			if(action.equals("like")) {
				if(service.likepost(user_id, post_id)) {
					liked.setLiked(service.getlikeCount(post_id));
					liked.setDisliked(service.getdislikeCount(post_id));
					System.out.println("liked" + liked.toString());


					Map<String, Object> mapObject = new HashMap<String, Object>();
					mapObject.put("data", liked);

					response.addHeader("Access-Control-Allow-Origin", "*");
					
					JsonJackson.includeJSONResponse(mapObject, request, response);

				}

				/*response.getWriter().println(liked.getLiked());*/
			}else if(action.equals("dislike")){
				if(service.dislikepost(user_id, post_id)) {
					liked.setLiked(service.getlikeCount(post_id));
					liked.setDisliked(service.getdislikeCount(post_id));
					Map<String, Object> mapObject = new HashMap<String, Object>();
					mapObject.put("data", liked);
					
					response.addHeader("Access-Control-Allow-Origin", "*");
					JsonJackson.includeJSONResponse(mapObject, request, response);
				}

			}


		}else {

			HttpSession session1 = request.getSession();
			Messages msg = new Messages("login first", "error", "alert-danger");
			session1.setAttribute("message", msg);
			response.sendRedirect("login.jsp");
		}
	}

	/*

	public String getJSONFromObject(Object object) {
		String jsonData = null;

		ObjectMapper writeMapper = new ObjectMapper();


		try {

			jsonData = writeMapper.writeValueAsString(object);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in  getJSONFromObject ");
		}
		return jsonData;
	}


	public String getValidJsonFromObject(Map<String, Object> allObjectMap) {
		if (null == allObjectMap || allObjectMap.isEmpty()) {

			allObjectMap = new HashMap<String, Object>();

		}
		return getJSONFromObject(allObjectMap);
	}

	public void includeJSONResponse(Map<String, Object> jsonMap, HttpServletRequest request, HttpServletResponse response) {
		String jsonString = getValidJsonFromObject(jsonMap);
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			System.out.println("before write :: " + response.isCommitted());
			response.getWriter().write(jsonString);


			System.out.println("jsonString :: " + jsonString);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in  includeJSONResponse");
		}
	}

*/
}
