package model;

import java.sql.*;

/**
 * a class to connect to our database on mySQL
 */
public class DatabaseConnection {

	private Connection conn;

	/**
	 * create connection
	 */
	public DatabaseConnection() {
		// initialize database connection
		// Driver
		String driverName = "com.mysql.jdbc.Driver";
		// DB administrator
		String userName = "root";
		// Password
		String userPasswd = "123456";
		// DB name
		String dbName = "dinnerDB";
		// connect
		String url = "jdbc:mysql://localhost/" + dbName;
		try {
			// load the driver
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, userName, userPasswd);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Driver Problem");
			cnfe.printStackTrace();
			System.exit(0);
		} catch (SQLException se) {
			System.out.println("SQL Problem");
			se.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * To close the db connection
	 */
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Can't close the database connection");
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Get the database connection
	 * 
	 * @return
	 */
	public Connection getConnection() {
		return this.conn;
	}
}
