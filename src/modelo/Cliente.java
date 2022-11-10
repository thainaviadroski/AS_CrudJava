package modelo;

import java.time.LocalDate;
import java.util.Date;


public class Cliente extends Pessoa {

	private int idCliente;

	public Cliente(String nome, String cpf, Date dataNasc, Endereco endereco) {
		super(nome, cpf, dataNasc, endereco);
	}

	public Cliente() {
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
