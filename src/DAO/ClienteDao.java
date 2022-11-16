package DAO;

import controle.ControllerCliente;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends DAO {

	static PessoaDao pessoaDao = new PessoaDao();
	static DAO dao;

	public static void save(Pessoa p) {
		Cliente c = new Cliente();
		int idPessoa = pessoaDao.searchByCpf(p.getCpf());

		if (idPessoa != 0) {
			try {
				String sql = "INSERT INTO cliente id_pessoa values (?)";
				PreparedStatement ps = dao.criarPreparedStatement(sql);
				ps.setInt(1, idPessoa);
				ps.executeUpdate();

				System.out.println("Cliente Salvo com sucesso!!");

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			c = ControllerCliente.cadastrar();
			PessoaDao pessoaDao = new PessoaDao();

			pessoaDao.salvar(p);


		}
	}

	public static List<Pessoa> findAll() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Pessoa p = null;
		String sql = "SELECT c.id as idCliente, p.nome, p.cpf, p.dataNasc, e.id as idEndereco, e.cidade, e.rua, e.numero FROM cliente AS c JOIN pessoa AS p ON c.id_pessoa = p.id JOIN endereco AS e ON e.id = p.endereco;";

		try {
			ResultSet rs = dao.consultaSQL(sql);
			while (rs.next()) {
				p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setDataNasc(rs.getDate("dataNasc"));
				p.getEndereco().setId(rs.getInt("id"));
				p.getEndereco().setCidade(rs.getString("cidade"));
				p.getEndereco().setRua(rs.getString("rua"));
				p.getEndereco().setNumero(rs.getInt("numero"));

				pessoas.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return pessoas;
	}

	public static Pessoa findByCpf(String cpf) {

		Pessoa p = null;
		String sql = "SELECT c.id as idCliente, p.nome, p.cpf, p.dataNasc, e.id as idEndereco, e.cidade, e.rua, e.numero FROM cliente AS c JOIN pessoa AS p ON c.id_pessoa = p.id JOIN endereco AS e ON e.id = p.endereco WHERE p.cpf = ?;";

		try {
			PreparedStatement ps = dao.criarPreparedStatement(sql);
			ps.setString(1 , cpf);

			ResultSet rs = dao.consultaSQL(sql);

			while (rs.next()) {
				p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCpf(rs.getString("cpf"));
				p.setDataNasc(rs.getDate("dataNasc"));
				p.getEndereco().setId(rs.getInt("id"));
				p.getEndereco().setCidade(rs.getString("cidade"));
				p.getEndereco().setRua(rs.getString("rua"));
				p.getEndereco().setNumero(rs.getInt("numero"));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return p;
	}
}
