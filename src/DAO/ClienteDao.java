/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controle.CadastroCliente;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author karol
 */
public class ClienteDao extends DAO {

	static PessoaDao p = new PessoaDao();
	static DAO dao;

	public static void save() {
		String cpf = "";
		Cliente c = new Cliente();
		int idPessoa = p.searchByCpf(cpf);

		if (idPessoa != 0) {
			try {
				String sql = "INSERT INTO public.cliente (id_pessoa) values(?)";
				PreparedStatement ps = dao.criarPreparedStatement(sql);
				ps.setInt(1, idPessoa);
				ps.executeUpdate();

				System.out.println("Cliente Salvo com sucesso!!");

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			c = CadastroCliente.cadastrar();
			String sqlPessoa = "INSERT INTO public.pessoa	(nome, cpf, dataNasci, endereco ) values (?,?,?,?) ";

			try {
				PreparedStatement ps = dao.criarPreparedStatement(sqlPessoa);
				ps.setString(1, c.getNome());
				ps.setString(2, c.getCpf());
				ps.setDate(3, new java.sql.Date(c.getDataNasc().getTime()));

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}


	}

}
