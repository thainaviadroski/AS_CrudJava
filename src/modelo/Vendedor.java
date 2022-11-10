package modelo;

import java.time.LocalDate;
import java.util.Date;


public class Vendedor extends Pessoa{
    private double percentualComissao;
    private double salario;

    public Vendedor() {
    }

    public Vendedor(double percentualComissao, double salario, String nome, String cpf, Date dataNasc, Endereco endereco) {
        super(nome, cpf, dataNasc, endereco);
        this.percentualComissao = percentualComissao;
        this.salario = salario;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
