package modelo;

import util.NumberUtils;

public abstract class Imovel {
    
    protected String matriculaImovel;
    protected Pessoa proprietario;
    protected Endereco endereco;
    protected double largura;
    protected double comprimento;
    protected double valor;
    
    //Método Abrstrato
    public abstract double calcularArea();

    public Imovel() {
        this.proprietario = new Pessoa();
        this.endereco = new Endereco();
    }

    public Imovel(String matriculaImovel, Pessoa proprietario, Endereco endereco, double largura, double comprimento, double valor) {
        this.matriculaImovel = matriculaImovel;
        this.proprietario = proprietario;
        this.endereco = endereco;
        this.largura = largura;
        this.comprimento = comprimento;
        this.valor = valor;
    }
    
    

    public String getMatriculaImovel() {
        return matriculaImovel;
    }

    public void setMatriculaImovel(String matriculaImovel) {
        this.matriculaImovel = matriculaImovel;
    }

    public Pessoa getProprietario() {
        return proprietario;
    }

    public void setProprietario(Pessoa proprietario) {
        this.proprietario = proprietario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void exibirInformacoes(){
        System.out.println("Matricula imovel: "+ matriculaImovel + " - Proprietário: "+proprietario.getNome() + "\tvalor: "+NumberUtils.formatarValorMonetario(valor));
    }
    
}
