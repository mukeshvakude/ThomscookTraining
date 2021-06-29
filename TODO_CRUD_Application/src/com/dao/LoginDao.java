package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	static Connection con;
	static Statement statement;
	static ResultSet rs;
	public static boolean authenticate(String username , String password) {
		boolean isValid = false;
		try {
			con = DatabaseConnection.getConnection();
			String query = "select * from user where username = '"+username +"' and "+"password ='"+password+"'";
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				isValid = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeResources();
		}
		return isValid;
	}

	public static void closeResources() {
		if(statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (con != null )
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("resources close succeesfully");
	}



}
