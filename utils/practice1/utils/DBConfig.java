package practice1.utils;
import java.sql.DriverManager;

import practice1.exceptions.CustomerException;

import java.sql.Connection;

public class DBConfig {
	static String URL = "jdbc:mysql://127.0.0.1:3306/jdbc";
	static String USER = "root";
	static String PASSWORD = "Sohal@123";
	protected static Connection setConnection() throws CustomerException{
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(Exception e) {
			throw new CustomerException("Error : "+e.getMessage());
		}
	}
}
