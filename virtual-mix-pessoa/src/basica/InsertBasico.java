package basica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import cadastro.pessoa.Conexao;

public class InsertBasico {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = new Conexao().getConnection();

		// Chamada da classe que recebe uma connection e retorna o Max ID
		
		int maxid = new Maxid().maxId(connection);
		
		// variaveis para metodo insert		
		String nome = "Joao";
		String endereco = "rua doze 123";
		String tel	= "39111";
		String email = "teste@teste";
		String rg	= "123440";
		
		String comando = "insert into t_pessoa_fisica (id_pessoa, nome, endereco, tel, email, rg) values (?, ?, ?, ?, ?, ?)";

		PreparedStatement insert = connection.prepareStatement(comando);
		
		insert.setInt(1, maxid);
		insert.setString(2, nome);
		insert.setString(3, endereco);
		insert.setString(4, tel);
		insert.setString(5, email);
		insert.setString(6, rg);	
		
		insert.execute();
		
		System.out.println("A pessoa " + maxid + " foi cadastrada com sucesso !");		

		insert.close();
		connection.close();
	}

}
