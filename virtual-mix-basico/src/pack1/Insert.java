package pack1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();

		Statement select = connection.createStatement();
		// Select para pegar o max id
		select.execute("select max(id_cupom) as id_cupom from t_cupom");
		ResultSet resultset = select.getResultSet();
		resultset.next();
		int id = resultset.getInt("id_cupom");
		if (id < 1) {
			id = 1;
		} else {
			id = (id + 1);
		}

		Statement insert = connection.createStatement();
		// Se inserir exibimos a mensagem
		Boolean resultado = insert.execute("insert into t_cupom (id_cupom,matriz_cupom, vl_cupom) values (" + id + ",'loja 1', 10)");
		if (resultado) {
			System.out.println("O cupom " + id + " foi inserido com sucesso !");
		}
		select.close();
		insert.close();
		connection.close();
	}
}
