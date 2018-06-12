package basica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValidaUpdate {

	int id_valida;

	public int validaId(Connection connection, int id_pessoa_valida) throws SQLException {
		Statement select = connection.createStatement();

		// Select para pegar o max id
		try {
			select.execute("select id_pessoa from t_pessoa_fisica where id_pessoa = " + id_pessoa_valida);
			ResultSet resultset = select.getResultSet();
			resultset.next();
			id_valida = resultset.getInt("id_pessoa");

			System.out.println("O cadastro da pessoa " + id_valida + " foi alterado com sucesso ! ");

		} catch (Exception e) {
			System.out.println("A pessoa " + id_pessoa_valida + " não existe no banco de dados! ");
		} finally {
			// Quando utilizamos o try catch não é necessario fechar a conexao
			return id_valida;
		}

	}

}
