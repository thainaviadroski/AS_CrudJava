/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author karol
 */
public class ImovelRuralDao extends DAO {

	public int findMatriculaImovel(String matriculaImovel) {
		String sql = "SELECT id FROM imovel WHERE matricula_imovel = ?";

		try {
			PreparedStatement ps = criarPreparedStatement(sql);
			ps.setString(1, matriculaImovel);
			ResultSet rs = consultaSQL(sql);

			while (rs.next()) {
				return rs.getInt("id");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


		return 0;
	}

}
