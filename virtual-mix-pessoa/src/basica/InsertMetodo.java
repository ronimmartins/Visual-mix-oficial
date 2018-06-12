package basica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cadastro.pessoa.Conexao;


public class InsertMetodo {
	public static void main(String[] args) throws SQLException {

		Connection connection = new Conexao().getConnection();

		// Chamada da classe que recebe uma connection e retorna o Max ID
		int maxid = new Maxid().maxId(connection);

		// Monta o comando para o insert
		String comando = "insert into t_pessoa_fisica (id_pessoa, nome, endereco, tel, email, rg) values (?, ?, ?, ?, ?, ?)";

		// Monta o prepare
		PreparedStatement insert = connection.prepareStatement(comando);

		// Insert atraves de um metodo ... podemos extrair e gerar uma classe
		incluirPessoa(maxid, "Joao", "rua doze 123", "3911 1221", "teste@teste", "123440", insert);
		connection.close();
	}

	// metodo Insert para extrair e gerar uma classe
	private static void incluirPessoa(int maxid, String nome, String endereco, String tel, String email, String rg,
			PreparedStatement insert) throws SQLException {
		insert.setInt(1, maxid);
		insert.setString(2, nome);
		insert.setString(3, endereco);
		insert.setString(4, tel);
		insert.setString(5, email);
		insert.setString(6, rg);

		// Executa o inserir
		insert.execute();

		System.out.println("A pessoa " + maxid + " foi cadastrada com sucesso !");

		insert.close();

	}

}
