package test;

import DAO.Conexao;
import controle.ControllerCliente;
import controle.ControllerPessoa;
import modelo.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestMain {
	public static void main(String[] args) {
		System.out.println("Pessoa:");

		ControllerPessoa.listar();


	}

}
