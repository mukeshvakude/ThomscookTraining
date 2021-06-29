package com.helper;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetAllUser
 */
@WebServlet("/GetAllUser")
public class JsonJackson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public JsonJackson() {
    	System.out.println("Inside GetAllUser Constructor...");
       
    }

	public static String getJSONFromObject(Object object) {
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


	public static String getValidJsonFromObject(Map<String, Object> allObjectMap) {
		if (null == allObjectMap || allObjectMap.isEmpty()) {

			allObjectMap = new HashMap<String, Object>();

		}
		return getJSONFromObject(allObjectMap);
	}

	public static void includeJSONResponse(Map<String, Object> jsonMap, HttpServletRequest request, HttpServletResponse response) {
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

}