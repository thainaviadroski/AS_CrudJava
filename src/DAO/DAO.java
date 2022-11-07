/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author karol
 */
public abstract class DAO {
    private Connection conexao;
    
    public DAO() {
        conexao = ConnectionPg.connect();
    }
    
    
    public Connection getConexao() {
        return conexao;
    }
    
    public ResultSet consultaSQL(String comandoSql) throws SQLException {
        ResultSet rs = conexao.createStatement().executeQuery(comandoSql);
        return rs;
    }
    
    protected int gerarProximoId(String tabela){
        try {
            ResultSet rs = consultaSQL("select max(id) from "+tabela);
            if(rs.next()){
                return rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("falha ao gerar próximo ID\n"+ ex.getMessage());
        }
        return -1;
    }
    
    public PreparedStatement criarPreparedStatement(String sql) throws SQLException{
        return conexao.prepareStatement(sql);
    }
    
    public void executeSql(String sql) throws SQLException{
        Statement st =  conexao.createStatement();
        st.executeUpdate(sql);
        st.close();
    }
}
