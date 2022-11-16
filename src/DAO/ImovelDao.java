package DAO;


import modelo.Imovel;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImovelDao extends DAO{
	public boolean save(Imovel imovel){
		String sql = "INSERT INTO";
		try{
			PreparedStatement ps = criarPreparedStatement(sql);




			return true;
		}catch (SQLException err){
			err.printStackTrace();
		}


		return false;
	}
}
