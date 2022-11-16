package modelo;

import util.DateUtils;

import java.time.LocalDate;
import java.util.Date;

public class Pessoa implements Comparable<Pessoa> {

	protected int id;
	protected String nome;
	protected String cpf;
	protected Date dataNasc;
	protected Endereco endereco;

	public Pessoa(String nome, String cpf, Date dataNasc, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.endereco = endereco;
	}

	public Pessoa() {
		this.endereco = new Endereco();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void exibirInformacoes() {
		System.out.print(nome + " CPF: " + cpf + " Data de Nascimento: " + dataNasc);
		endereco.exibirInformacoes();
	}

	@Override
	public int compareTo(Pessoa outraPessoa) {
		return nome.compareTo(outraPessoa.getNome());
	}


	@Override
	public String toString() {
		return "Pessoa{" + "id=" + id + ", nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + ", dataNasc=" + dataNasc + ", endereco=" + endereco + '}';
	}
}
