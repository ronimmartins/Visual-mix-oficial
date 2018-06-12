package basica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cadastro.pessoa.Conexao;

public class ListarPessoa {

	public static void main(String[] args) throws SQLException {
		Connection pool = new Conexao().getConnection();
		Statement select = pool.createStatement();

		// filtro para pesquisar por id
		int id_pessoa_pesquisa = 4;

		select.execute("select * from t_pessoa_fisica where id_pessoa  = " + id_pessoa_pesquisa + "  ");
		ResultSet lista = select.getResultSet();
		while (lista.next()) {
			int id = lista.getInt("id_pessoa");
			String nome = lista.getString("nome");
			String endereco = lista.getString("endereco");
			String tel = lista.getString("tel");
			String email = lista.getString("email");
			String rg = lista.getString("rg");
			System.out.println("Cód. " + id + "	" + "Nome: " + nome + "End. " + endereco + " Tel: " + tel + " Email: "
					+ email + " Rg: " + rg);
		}

		select.close();
		lista.close();
		pool.close();

	}
}
