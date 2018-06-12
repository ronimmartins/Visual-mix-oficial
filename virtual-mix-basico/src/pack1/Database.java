package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {	
	static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@seu_database", "user","password");
		return connection;
			}
}