package basica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cadastro.pessoa.Conexao;

public class UpdateBasico {

	public static void main(String[] args) throws SQLException {
		Connection conexao = new Conexao().getConnection();

		int id_pessoa_update = 6;

		String comando = "Update t_pessoa_fisica  set nome = 'Paulo', endereco  = 'rua Crixá Mirim, 61 São Paulo' where id_pessoa =  "
				+ id_pessoa_update;

		PreparedStatement update = conexao.prepareStatement(comando);
		update.execute();

		System.out.println("Os dados da Pessoa " + id_pessoa_update + " foram  alterados com sucesso!");

		update.close();
		conexao.close();

	}

}
