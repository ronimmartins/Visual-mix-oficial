package pack1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	public static void main(String[] args) throws SQLException {
		Connection connection = Database.getConnection();

		Statement delete = connection.createStatement();
		Boolean resultado = delete.execute("delete from t_cupom where id_cupom > 1");
		// se o resultado for true ele emite a mensagem  
		if(resultado) {
			System.out.println("deletado com sucesso");		
		// if(!resultado)  caso eu queira testar if not (sendo FALSO ) por exemmplo usamos ! no inicio 			
		}
		int count = delete.getUpdateCount();
		if (count > 0) {
			System.out.println("Total de " + count + " cupons deletados !");
		}
		Statement select = connection.createStatement();
		select.execute("select max(id_cupom) as id_cupom from t_cupom");
		ResultSet resultSet = select.getResultSet();
		resultSet.next();
		int id = resultSet.getInt("id_cupom");
		System.out.println(id);

		delete.close();
		select.close();
		connection.close();
	}

}
