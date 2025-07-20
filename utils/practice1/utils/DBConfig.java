package practice1.utils;
import java.sql.DriverManager;

import practice1.exceptions.CustomerException;

import java.sql.Connection;

public class DBConfig {
	static String URL = "";
	static String USER = "";
	static String PASSWORD = "";
	protected static Connection setConnection() throws CustomerException{
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(Exception e) {
			throw new CustomerException("Error : "+e.getMessage());
		}
	}
}
