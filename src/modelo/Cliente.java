package modelo;

import java.time.LocalDate;


public class Cliente extends Pessoa {

	private int idCliente;


	public Cliente() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente(String nome, String cpf, LocalDate dataNasc, Endereco endereco) {
		super(nome, cpf, dataNasc, endereco);
	}


}
