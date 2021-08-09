package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/management?autoReconnect=true&useSSL=false", "root", "");
		} catch(Exception e) {
			System.err.println(e);
		}
		return conn;
	}
}
