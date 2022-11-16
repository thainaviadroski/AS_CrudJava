package DAO;


import modelo.Imovel;
import modelo.ImovelRural;
import modelo.ImovelUrbano;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImovelDao extends DAO {
	public boolean save(Imovel imovel) {
		if (imovel instanceof ImovelRural) {
			String sql = "INSERT INTO imovel (matricula_imovel, proprietario, endereco, tipo, largura, comprimento, valor) values (?,?,?,?,?,?,?);";
			try {
				PreparedStatement ps = criarPreparedStatement(sql);
				ps.setString(1, imovel.getMatriculaImovel());
				ps.setInt(2, imovel.getProprietario().getId());
				ps.setInt(3, imovel.getEndereco().getId());
				ps.setString(4, imovel.getTipo().name());
				ps.setDouble(5, imovel.getLargura());
				ps.setDouble(6, imovel.getComprimento());
				ps.setDouble(7, imovel.getValor());

				return true;
			} catch (SQLException err) {
				err.printStackTrace();
			}
		}

		if (imovel instanceof ImovelUrbano) {
			String sql = "INSERT INTO imovel (matricula_imovel, proprietario, endereco, tipo, largura, comprimento, valor) values (?,?,?,?,?,?,?);";
			try {
				PreparedStatement ps = criarPreparedStatement(sql);
				ps.setString(1, imovel.getMatriculaImovel());
				ps.setInt(2, imovel.getProprietario().getId());
				ps.setInt(3, imovel.getEndereco().getId());
				ps.setString(4, imovel.getTipo().name());
				ps.setDouble(5, imovel.getLargura());
				ps.setDouble(6, imovel.getComprimento());
				ps.setDouble(7, imovel.getValor());

				return true;
			} catch (SQLException err) {
				err.printStackTrace();
			}
		}

		return false;
	}

	public ImovelRural findAll() {
		String sql = "SELECT * FROM imovel AS i JOIN pessoa AS P";
		Imovel imovel;
		try {
			ResultSet rs = consultaSQL(sql);

			while (rs.next()) {

			}

		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

}
