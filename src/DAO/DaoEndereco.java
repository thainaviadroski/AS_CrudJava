package DAO;

import modelo.Endereco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEndereco extends DAO {
	public ArrayList<Endereco> carregarEnderecos() {
		ArrayList<Endereco> enderecos = new ArrayList<>();
		try {
			String sql = "select * from endereco";
			ResultSet rs = consultaSQL(sql);
			while (rs.next()) {
				Endereco end = new Endereco();
				end.setId(rs.getInt("id"));
				end.setCidade(rs.getString("cidade"));
				end.setRua(rs.getString("rua"));
				end.setNumero(rs.getInt("numero"));

				enderecos.add(end);
			}
		} catch (SQLException ex) {
			System.out.println("Falha ao carregar endereços!\n" + ex.getMessage());
		}
		return enderecos;
	}

	public Endereco carregarEnderecoPorId(int idEndereco) {
		Endereco end = null;
		try {
			String sql = "select * from endereco where id = " + idEndereco;
			ResultSet rs = consultaSQL(sql);
			if (rs.next()) {
				end = new Endereco();
				end.setId(rs.getInt("id"));
				end.setCidade(rs.getString("cidade"));
				end.setRua(rs.getString("rua"));
				end.setNumero(rs.getInt("numero"));
			}
		} catch (SQLException ex) {
			System.out.println("Falha ao carregar endereço!\n" + ex.getMessage());
		}
		return end;
	}

	public int salvar(Endereco end) {
		try {
			String sql = " INSERT INTO endereco (cidade, rua, numero ) VALUES(?, ?, ?); ";

			PreparedStatement ps = criarPreparedStatement(sql);

			ps.setString(1, end.getCidade());
			ps.setString(2, end.getRua());
			ps.setInt(3, end.getNumero());

			int i = ps.executeUpdate();

			if (i == 1) {
				System.out.println("Salvo!!");
				return lastId();
			} else {
				System.out.println("Falhou!!!");

			}

			return lastId();
		} catch (SQLException ex) {
			System.out.println("Falha ao salvar endereço\n" + ex.getMessage());
			return 0;
		}
	}

	public boolean atualizar(Endereco end) {
		try {
			String sql = "UPDATE endereco SET cidade =?,rua =?,numero =? 	WHERE id = " + end.getId();

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

	public String comandoSqlRemover(Endereco end) {
		return "DELETE FROM endereco WHERE id = " + end.getId();
	}

	public boolean remover(Endereco end) {
		try {
			executeSql(comandoSqlRemover(end));
			return true;
		} catch (SQLException e) {
			System.out.println("Falha ao remover endereço\n" + e.getMessage());
			return false;
		}
	}


	public int lastId() {
		int id = 0;
		try {
			String sql = "select id from endereco order by id desc";
			ResultSet rs = consultaSQL(sql);
			if (rs.next()) {
				id = rs.getInt("id");

			}
			return id;
		} catch (SQLException ex) {
			System.out.println("Falha ao carregar endereço!\n" + ex.getMessage());
		}
		return id;
	}

}