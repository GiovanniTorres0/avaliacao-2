package Caixa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CriaConexao {

	public Connection Conexao() throws SQLException {
	
	
	return DriverManager
            .getConnection("jdbc:mysql://localhost/avaliacao_2?useTimezone=true&serverTimezone=UTC", "root", "root");
	
}
	
	public int getLastId() throws SQLException{
		String sql = "SELECT MAX(ID) as id FROM PRODUTO";
		PreparedStatement stmt = (PreparedStatement) Conexao().prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		int lastId = rs.getInt("id");

			rs.close();
			stmt.close();
				
			return lastId;
		}
	
	
}
