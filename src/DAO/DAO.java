package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
	private Connection conexao;

	public DAO() {
		conexao = Conexao.getConnection();
	}

	public Connection getConexao() {
		return conexao;
	}

	public ResultSet consultaSQL(String comandoSql) throws SQLException {
		ResultSet rs = conexao.createStatement().executeQuery(comandoSql);
		return rs;
	}


	public PreparedStatement criarPreparedStatement(String sql) throws SQLException {
		return conexao.prepareStatement(sql);
	}

	public void executeSql(String sql) throws SQLException {
		Statement st = conexao.createStatement();
		st.executeUpdate(sql);
		st.close();
	}
}
