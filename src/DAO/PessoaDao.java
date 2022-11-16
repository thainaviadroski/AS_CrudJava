/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Pessoa;

/**
 * @author karol
 */
public class PessoaDao extends DAO {

	private DaoEndereco daoEndereco;

	private DAO dao;

	public PessoaDao() {
		daoEndereco = new DaoEndereco();
	}

	public List<Pessoa> carregarPessoas() {
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		try {
			String sql = "SELECT p.id as idPessoa, p.nome, p.cpf, p.dataNasc, e.id as idEndereco, e.cidade, e.rua, e.numero FROM pessoa AS p LEFT JOIN endereco AS e ON p.endereco = e.id;";
			ResultSet rs = consultaSQL(sql);
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("idPessoa"));
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setDataNasc(rs.getDate("dataNasc"));
				p.getEndereco().setId(rs.getInt("idEndereco"));
				p.getEndereco().setCidade(rs.getString("cidade"));
				p.getEndereco().setRua(rs.getString("rua"));
				p.getEndereco().setNumero(rs.getInt("numero"));

				listaPessoas.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Falha ao carregar pessoas!\n" + e.getMessage());
		}
		return listaPessoas;
	}

	public Pessoa carregarPorId(int idPessoa) {
		Pessoa cl = null;
		try {
			String sql = "SELECT * FROM pessoa left join endereco as ed on id_endereco = ed.id  where pessoa.id = " + idPessoa;
			ResultSet rs = consultaSQL(sql);
			if (rs.next()) {
				cl = new Pessoa();
				cl.setId(rs.getInt("id"));
				cl.setNome(rs.getString("nome"));
				cl.setCpf(rs.getString("cpf"));

				if (rs.getObject("id_endereco", Integer.class) != null) {
					cl.getEndereco().setId(rs.getInt("id_endereco"));
					cl.getEndereco().setCidade(rs.getString("cidade"));
					cl.getEndereco().setRua(rs.getString("rua"));
					cl.getEndereco().setNumero(rs.getInt("numero"));
				}
			}
		} catch (SQLException e) {
			System.out.println("Falha ao carregar pessoa!\n" + e.getMessage());
		}
		return cl;
	}

	public boolean salvar(Pessoa pessoa) {
		try {
			String sql = "INSERT INTO pessoa (nome, cpf, endereco) VALUES (?, ?, ?)";

			PreparedStatement ps = criarPreparedStatement(sql);

			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());

			if (pessoa.getEndereco() != null) {
				if (pessoa.getEndereco().getId() == 0) {
					int id = daoEndereco.salvar(pessoa.getEndereco());
					pessoa.getEndereco().setId(id);
				}
				ps.setInt(3, pessoa.getEndereco().getId());
			}
			ps.execute();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				getConexao().rollback();
			} catch (SQLException ex1) {
				ex1.printStackTrace();
				System.out.println("Falhar ao realizar RollBack");
			}
			System.out.println("Falha ao salvar Pessoa\n" + ex.getMessage());
			return false;
		}
	}

	public boolean atualizar(Pessoa pessoa) {
		try {
			String sql = "UPDATE pessoa SET nome=?, cpf=?, id_endereco=? WHERE id= " + pessoa.getId();

			PreparedStatement ps = criarPreparedStatement(sql);
			ps.setString(1, pessoa.getNome());
			ps.setString(2, pessoa.getCpf());

			if (pessoa.getEndereco() != null) {
				if (pessoa.getEndereco().getId() != 0) {
					daoEndereco.salvar(pessoa.getEndereco());
				} else {
					daoEndereco.atualizar(pessoa.getEndereco());
				}
				ps.setInt(3, pessoa.getEndereco().getId());
			} else {
				ps.setObject(4, null);
			}

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {

			System.out.println("Falha ao editar pessoa!\n" + e.getMessage());
			return false;
		}
	}

	public boolean remover(Pessoa pessoa) {
		try {
			String sql = "DELETE FROM pessoa WHERE id =" + pessoa.getId() + "; " + daoEndereco.comandoSqlRemover(pessoa.getEndereco());
			executeSql(sql);
			return true;
		} catch (SQLException e) {
			System.out.println("Falha ao remover pessoa!\n" + e.getMessage());
			return false;
		}
	}

	public int searchByCpf(String cpf) {
		int id = 0;

		String sql = "select id from pessoa where cpf='" + cpf + "';";

		try {
			ResultSet rs = dao.consultaSQL(sql);

			while (rs.next()) {
				id = rs.getInt("id");
			}
			return id;

		} catch (SQLException e) {
			e.printStackTrace();

			System.out.println("Pesosa não encontrada!!");
		}

		return id;
	}
}
