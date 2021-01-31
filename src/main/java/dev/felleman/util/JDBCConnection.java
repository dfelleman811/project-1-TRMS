package dev.felleman.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {

	// Create an empty connection object
	public static Connection conn = null;

	// Method to establish connection
	public static Connection getConnection() {

		try {

			// Check for existing connection or not
			if (conn == null) {

				// Force driver to load
				Class.forName("oracle.jdbc.driver.OracleDriver");

				// Create a new Properties Object to get required credentials (I want to
				// eventually make this an environment variable).
				Properties prop = new Properties();

				// Load in file from resources and assign to variables
				FileInputStream input = new FileInputStream(
						JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());
				prop.load(input);

				String url = prop.getProperty("url");
				String username = prop.getProperty("username");
				String password = prop.getProperty("password");

				// Establish conection using above credentials
				conn = DriverManager.getConnection(url, username, password);

				return conn;

			} else {

				// If connection already exists
				return conn;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// If connection fails - return null
		return null;
	}

}
