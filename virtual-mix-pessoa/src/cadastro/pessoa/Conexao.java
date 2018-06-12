package cadastro.pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

public class Conexao {

    private OracleDataSource oracleDataSource;

    public Conexao(){
        try {
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL("\"jdbc:oracle:thin:@seu_database");
            oracleDataSource.setUser("user");
            oracleDataSource.setPassword("password");

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public Connection getConnection() throws SQLException {
        return oracleDataSource.getConnection();
    }
        
    // aqui eu  esta instanciando de novo o OracleDataSource e isso o 
    //public static Connection getConnection() throws SQLException {
	//Connection con = Conexao.getConnection();
	//return con;

}