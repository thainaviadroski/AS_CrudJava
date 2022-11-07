/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Endereco;

/**
 *
 * @author karol
 */
public class DaoEndereco extends DAO{
    public ArrayList<Endereco> carregarEnderecos(){
        ArrayList<Endereco> enderecos = new ArrayList<>();
        try {
            String sql = "select * from endereco";
            ResultSet rs = consultaSQL(sql);
            while(rs.next()){
                Endereco end = new Endereco();
                end.setId(rs.getInt("id"));
                end.setCidade(rs.getString("cidade"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
                
                enderecos.add(end);
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar endereços!\n"+ ex.getMessage());
        }
        return enderecos;
    }
    
    public Endereco carregarEnderecoPorId(int idEndereco){
        Endereco end = null;
        try {
            String sql = "select * from endereco where id = "+idEndereco;
            ResultSet rs = consultaSQL(sql);
            if(rs.next()){
                end = new Endereco();
                end.setId(rs.getInt("id"));
                end.setCidade(rs.getString("cidade"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));
            }
        } catch (SQLException ex) {
            System.out.println("Falha ao carregar endereço!\n"+ ex.getMessage());
        }
        return end;
    }
    
    public boolean salvar(Endereco end){
        try {
            String sql = "INSERT INTO public.endereco(id, cidade, rua, numero ) VALUES (?, ?, ?, ?);";
            
            PreparedStatement ps = criarPreparedStatement(sql);
            end.setId(gerarProximoId("endereco"));
            ps.setInt(1, end.getId());
            ps.setString(2, end.getCidade());
            ps.setString(3, end.getRua());
            ps.setInt(4, end.getNumero());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao salvar endereço\n" + ex.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Endereco end){
        try {
            String sql = "UPDATE public.endereco SET cidade=?, rua=?, numero=? WHERE id ="+end.getId();
            
            PreparedStatement ps = criarPreparedStatement(sql);
            ps.setString(1, end.getCidade());
            ps.setString(2, end.getRua());
            ps.setInt(3, end.getNumero());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Falha ao editar endereço\n" + ex.getMessage());
            return false;
        }
    }
    
    public String comandoSqlRemover(Endereco end){
        return "DELETE FROM public.endereco WHERE id = "+end.getId();
    }
    
    public boolean remover(Endereco end){
        try {
            executeSql(comandoSqlRemover(end));
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao remover endereço\n"+e.getMessage());
            return false;
        }
    }
    
}