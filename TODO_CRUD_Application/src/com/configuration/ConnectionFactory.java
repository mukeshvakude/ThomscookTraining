package com.configuration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class ConnectionFactory {

	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/student";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	private  Connection con  = null;
	public ConnectionFactory() {
		
	}
	public  Connection getConnection() {

		try{  
			Class.forName(DRIVER);  
			con = DriverManager.getConnection(URL,USER,PASSWORD);   
			System.out.println("connection succussfully done " + con);
		}catch(ClassNotFoundException | SQLException e){ 
			System.out.println("error" + e.getMessage());
		}
		return con;
	}
	
	public static Date getSQLDate(LocalDate date) {
        return Date.valueOf(date);
    }

    public static LocalDate getUtilDate(Date sqlDate) {
        return sqlDate.toLocalDate();
    }

}
