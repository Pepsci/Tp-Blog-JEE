package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	
	public static Connection getConnection() {
		 String url="jdbc:mysql://localhost/";
		 String dbName="blogJEE";
		 String user="root";
		 String password="";
		 
		Connection connect = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect = DriverManager.getConnection(url+dbName,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connect;
		
	}
}
