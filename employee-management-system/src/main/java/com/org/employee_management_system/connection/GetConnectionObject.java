package com.org.employee_management_system.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionObject {
	private static final String URL = "jdbc:postgresql://localhost:5432/employee-management-system";
	private static final String USER = "postgres";
	private static final String PWD = "1234";
	Connection con=null;
	public static Connection getconnectionObject() {
          
		try {
			Class.forName("org.postgresql.Driver");

			return DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;

	}
}
