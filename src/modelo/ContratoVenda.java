package modelo;

import util.DateUtils;
import util.NumberUtils;


public class ContratoVenda extends Contrato{
    
    private String formaPagamento;
    private int qtdParcelas;

    public ContratoVenda() {
    }

    public ContratoVenda(String formaPagamento, int qtdParcelas, int id, Vendedor funcionario, Cliente cliente, Imovel imovel, double valor) {
        super(id, funcionario, cliente, imovel, valor);
        this.formaPagamento = formaPagamento;
        this.qtdParcelas = qtdParcelas;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }
    
    @Override
    public void exibirInformacoes(){
        System.out.print("id: "+ id + " cliente: "+ cliente.getNome() +" Tipo contrato: Venda - valor: "+ NumberUtils.formatarValorMonetario(valor));
       
    }
    
}
