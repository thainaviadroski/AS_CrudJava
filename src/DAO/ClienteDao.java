/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controle.ControllerCliente;
import modelo.Cliente;
import modelo.Pessoa;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author karol
 */
public class ClienteDao extends DAO {

	static PessoaDao pessoaDao = new PessoaDao();
	static DAO dao;

	public static void save(Pessoa p) {
		String cpf = "";
		Cliente c = new Cliente();
		int idPessoa = pessoaDao.searchByCpf(cpf);

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
			c = ControllerCliente.cadastrar();
			PessoaDao pessoaDao = new PessoaDao();

			pessoaDao.salvar(p);


		}


	}

}
