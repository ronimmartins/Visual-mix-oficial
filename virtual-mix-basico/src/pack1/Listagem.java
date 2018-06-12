package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listagem {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();
		
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from T_CUPOM");
		// System.out.println(resultado);
		ResultSet resultSet = statement.getResultSet();
		while (resultSet.next()) {
			int id = resultSet.getInt("ID_CUPOM");
			String matriz = resultSet.getString("MATRIZ_CUPOM");
			System.out.println("ID - " + id + "			 " + " MATRIZ_CUPOM - " + matriz);
		}
		resultSet.close();
		statement.close();
		connection.close();
	}
}
