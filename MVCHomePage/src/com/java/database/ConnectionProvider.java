package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String id ="kitri";
			String password = "kitri";
			
			conn = DriverManager.getConnection(url,id,password);
		}catch(Exception e) {
			
		}
		return conn;
	}
}
