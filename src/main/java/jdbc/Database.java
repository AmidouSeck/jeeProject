package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection connection = null;

	static
	{
		String url = "jdbc:mysql://localhost:3306/albumPhoto";
		String user = "root";
		String password = "password";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return connection;
	}

}
