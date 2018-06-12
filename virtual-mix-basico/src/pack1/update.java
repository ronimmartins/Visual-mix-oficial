package pack1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class update {
	public static void main(String[] args)throws SQLException {
	Connection connection = Database.getConnection();	
	

	
	Statement update = connection.createStatement();	
	Boolean resultado = update.execute("update t_cupom set matriz_cupom = 'nova matriz após update' where id_cupom = 1");
	if (resultado = true) {
	System.out.println("alterado com sucesso!");
	}
	
	Statement select = connection.createStatement();		
	select.execute("select matriz_cupom from t_cupom where id_cupom = 1");
	ResultSet resultset = select.getResultSet();
	resultset.next();
	String matriz = resultset.getString("matriz_cupom");
	System.out.println(matriz);
	
	
		
	}

}
