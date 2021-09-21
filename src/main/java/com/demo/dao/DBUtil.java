package com.demo.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection con;
	
	public static Connection getMyConnection() {
		try {
		if(con==null) {
			String url="jdbc:mysql://localhost:3306/auction?useSSL=false";
			String username="root";
			String password="Pooja";
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeMyConnection() {
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
