package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		System.out.println("Banco conectado!");
		connection.close();
	}

	
}
