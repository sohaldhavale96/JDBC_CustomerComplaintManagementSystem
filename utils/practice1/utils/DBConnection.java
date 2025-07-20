package practice1.utils;

import java.sql.Connection;

import practice1.exceptions.CustomerException;

public class DBConnection {
	private static Connection connection;
//	static {
//		try {
//			connection = DBConfig.setConnection();
//		}catch(CustomerException e) {
//			System.out.println(e.getMessage());
//		}
//	}
	public static Connection getConnection() throws CustomerException {
		try {
			connection = DBConfig.setConnection();
			return connection;
		}catch(Exception e) {
			throw new CustomerException(e.getMessage());
		}
	}
}
