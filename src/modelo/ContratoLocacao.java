package modelo;

import java.time.LocalDate;
import util.DateUtils;


public class ContratoLocacao extends Contrato{
    
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private double percentualMulta;

    public ContratoLocacao() {
    }
    
    public ContratoLocacao(LocalDate dataInicio, LocalDate dataTermino, double percentualMulta, int id, Vendedor funcionario, Cliente cliente, Imovel imovel, double valor) {
        super(id, funcionario, cliente, imovel, valor);
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.percentualMulta = percentualMulta;
    }

    

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getPercentualMulta() {
        return percentualMulta;
    }

    public void setPercentualMulta(double percentualMulta) {
        this.percentualMulta = percentualMulta;
    }

    @Override
    public String toString() {
        return "ContratoLocacao{" + "dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", percentualMulta=" + percentualMulta + '}';
    }
    
    @Override
    public void exibirInformacoes(){
        System.out.print("id: "+ id + " cliente: "+ cliente.getNome() +" Tipo contrato: Locação - período de : "+ DateUtils.formatarDataBR(dataInicio) + " a "+ DateUtils.formatarDataBR(dataTermino));
       
    }
}
