package cadastro.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basica.Maxid;

public class PessoaDao {

	public int incluir(Pessoa pessoa) throws SQLException {

		Connection connection = new Conexao().getConnection();

		// Chama a classe que recebe uma connection e retorna o Max ID
		pessoa.setId_pessoa(new Maxid().maxId(connection));

		String comando = "insert into t_pessoa_fisica (id_pessoa, nome, endereco, tel, email, rg) values (?, ?, ?, ?, ?, ?)";

		PreparedStatement insert = connection.prepareStatement(comando);

		insert.setInt(1, pessoa.getId_pessoa());
		insert.setString(2, pessoa.getNome());
		insert.setString(3, pessoa.getEndereco());
		insert.setString(4, pessoa.getTel());
		insert.setString(5, pessoa.getEmail());
		insert.setString(6, pessoa.getRg());

		insert.execute();

		insert.close();
		connection.close();

		System.out.println("A pessoa " + pessoa.getId_pessoa() + " foi cadastrada com sucesso !");

		return pessoa.getId_pessoa();

	}

	public List<Pessoa> selecionarTodos() throws SQLException {

		Connection connection = new Conexao().getConnection();

		Statement select = connection.createStatement();

		select.execute("select * from t_pessoa_fisica ");

		ResultSet lista = select.getResultSet();

		List<Pessoa> al = new ArrayList<Pessoa>();

		while (lista.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId_pessoa(lista.getInt("id_pessoa"));
			pessoa.setNome(lista.getString("nome"));
			pessoa.setEndereco(lista.getString("endereco"));
			pessoa.setEmail(lista.getString("email"));
			pessoa.setTel(lista.getString("tel"));
			pessoa.setRg(lista.getString("rg"));

			al.add(pessoa);
		}

		return al;

	}

	public Pessoa selecionaId(Pessoa param_pessoa) throws SQLException {

		Connection connection = new Conexao().getConnection();

		Statement select = connection.createStatement();

		select.execute("select * from t_pessoa_fisica where id_pessoa = " + param_pessoa.getId_pessoa());

		ResultSet lista = select.getResultSet();

		lista.next();
		Pessoa pessoa = new Pessoa();
		pessoa.setId_pessoa(lista.getInt("id_pessoa"));
		pessoa.setNome(lista.getString("nome"));
		pessoa.setEndereco(lista.getString("endereco"));
		pessoa.setEmail(lista.getString("email"));
		pessoa.setTel(lista.getString("tel"));
		pessoa.setRg(lista.getString("rg"));

		return pessoa;

	}

	public void alterar(Pessoa pessoa) throws SQLException {

		Connection connection = new Conexao().getConnection();

		String comando = "update t_pessoa_fisica  set nome=?, endereco=?,tel=?,email=?, rg=? where id_pessoa ="
				+ pessoa.getId_pessoa();

		PreparedStatement alterar = connection.prepareStatement(comando);

		// seta as Variaveis conforme o array lembrando que se inicia do 1 e nao do 0

		alterar.setString(1, pessoa.getNome());
		alterar.setString(2, pessoa.getEndereco());
		alterar.setString(3, pessoa.getTel());
		alterar.setString(4, pessoa.getEmail());
		alterar.setString(5, pessoa.getRg());

		alterar.execute();
		alterar.close();
		connection.close();

		System.out.println("A pessoa " + pessoa.getId_pessoa() + " foi alterada com sucesso!");

		return;
	}

	public void deletar(Pessoa pessoa) throws SQLException {

		Connection connection = new Conexao().getConnection();

		String comando = "delete from t_pessoa_fisica  where id_pessoa = " + pessoa.getId_pessoa();

		PreparedStatement deletar = connection.prepareStatement(comando);

		deletar.execute();
		deletar.close();
		connection.close();

		System.out.println("A pessoa " + pessoa.getId_pessoa() + " foi deletada com sucesso!");

		return;
	}

	public void deletar(int id) throws SQLException {

		Connection connection = new Conexao().getConnection();

		String comando = "delete from t_pessoa_fisica  where id_pessoa = " + id;

		PreparedStatement deletar = connection.prepareStatement(comando);

		deletar.execute();
		deletar.close();
		connection.close();

		System.out.println("A pessoa " + id + " foi deletada com sucesso!");

		return;
	}
}