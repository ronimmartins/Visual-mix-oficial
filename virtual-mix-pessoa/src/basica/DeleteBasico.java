package basica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cadastro.pessoa.Conexao;

public class DeleteBasico {
	public static void main(String[] args) throws SQLException {
		
		// Faço a conexão através do pool de conexao 
		Connection conexao = new Conexao().getConnection();
		
		// Informo qual id eu quero deletar
		int id_pessoa_delete = 2;

		// Monto o comando para o delete
		String comando = "delete from t_pessoa_fisica where id_pessoa =" + id_pessoa_delete;

		// Chamo o metodo prepare
		PreparedStatement delete = conexao.prepareStatement(comando);

		// executo o metodo
		delete.execute();

		// Sempre tenho que fechar o que eu abri (conexao e statement )
		delete.close();
		conexao.close();

	}

}
