package case_study;

import java.sql.*;

public class MySqlConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc_cs";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "password";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	}

}
