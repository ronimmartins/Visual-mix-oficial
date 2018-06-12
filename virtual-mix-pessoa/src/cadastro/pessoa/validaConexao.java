package cadastro.pessoa;


import java.sql.Connection;
import java.sql.SQLException;


 class validaConexao {
	public static void main(String[] args) throws SQLException {
		Connection connection = new Conexao().getConnection();
		System.out.println("Banco conectado via pool de conexão Oracle !");
		connection.close();
	}	
}


