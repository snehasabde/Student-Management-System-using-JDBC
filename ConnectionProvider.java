package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {
//in this we make connection of java application with database
	static Connection con ;
	
	public static Connection createConn ()  {
		
			try {
				//Load the driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//Create the connection...
				String url = "jdbc:mysql://localhost:3306/student_manage";
				String username = "root";
				String password = "admin";

				con = DriverManager.getConnection(url , username , password);
			} catch(Exception e) {
				
				e.printStackTrace();
			}
			
		return con;
			
			
	}
}
