package basica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Maxid {

	public int maxId(Connection connection) throws SQLException {
		Statement select = connection.createStatement();
		// Select para pegar o max id
		select.execute("select max(id_pessoa) as id_pessoa from t_pessoa_fisica");
		ResultSet resultset = select.getResultSet();
		resultset.next();
		int id = resultset.getInt("id_pessoa");
		if (id < 1) {
			id = 1;
		} else {
			id = (id + 1);
		}
		select.close();
		return id;
	}

}
