package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/developerdatabase";
	static String username="root";
	static String userpass="Pass@123";
	static Connection conn=null;
	
	public static Connection getConnect() {
		try {
			Class.forName(driver);
			System.out.println("driver loaded");
			conn=DriverManager.getConnection(url,username,userpass);
			System.out.println("connected to db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
