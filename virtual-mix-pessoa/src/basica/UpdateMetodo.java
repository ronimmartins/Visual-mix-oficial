package basica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cadastro.pessoa.Conexao;

public class UpdateMetodo {
	public static void main(String[] args) throws SQLException {

		Connection conexao = new Conexao().getConnection();

		int id_altera = 4;

		// metodo que valida a pessoa que queremos alterar
		int id_pessoa_update = new ValidaUpdate().validaId(conexao, id_altera);

		String comando = "update t_pessoa_fisica set nome = ?, endereco = ? where id_pessoa = " + id_pessoa_update;

		// Monta o prepare
		PreparedStatement update = conexao.prepareStatement(comando);

		// Carrega as informações a serem alteradas
		alteraPessoa("Maria Joaquina", "Rua 7 de setembro 1202, Bareuri", update);

		// fecha a conexao
		conexao.close();

	}

	private static void alteraPessoa(String nome, String endereco, PreparedStatement update) throws SQLException {

		update.setString(1, nome);
		update.setString(2, endereco);

		// Executa o update
		update.execute();

	}
}
