package com.brainmentors.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static void getConnection() throws ClassNotFoundException, SQLException {
		// Step - 1 Load a Driver
		// Class is a predefine class in Java
		// forName is a static method inside the Class.
		// forName is a method to load a class
		//  Class.forName("oracle.jdbc.driver.OracleDriver");
		// Class.forName("org.postgresql.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		// jdbc:postgresql://127.0.0.1:5432/test
		// jdbc:oracle:thin:@localhost:1521:servicename
		String connectionString = "jdbc:mysql://localhost:3306/testingdb";
		// Step -2 Create a Connection
		Connection con = null;
		con = DriverManager.getConnection(connectionString,"root","amit123456");
		if(con!=null) {
			System.out.println("Connection Created....");
			//con.close();
		}
		
		
	}
	public static void main(String[] args) {
		try {
			DBConnection.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
