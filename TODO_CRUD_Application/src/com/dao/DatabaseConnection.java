package com.dao;

import java.sql.*;

public class DatabaseConnection {
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/student";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	private static Connection con  = null;
	public static Connection getConnection() {

		try{  
			Class.forName(DRIVER);  
			con = DriverManager.getConnection(URL,USER,PASSWORD);   
			System.out.println("connection succussfully done " + con);
		}catch(ClassNotFoundException | SQLException e){ 
			System.out.println("error" + e.getMessage());
		}
		return con;
	}
	
	
//	public static void main(String[] args) {
//		DatabaseConnection.getConnection();
//	}


}
