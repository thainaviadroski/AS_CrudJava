package modelo;


public abstract class Contrato implements Comparable<Contrato>{
    protected int id;
    protected Vendedor funcionario;
    protected Cliente cliente;
    protected Imovel imovel;
    protected double valor;
    
    public abstract void exibirInformacoes();

    public Contrato() {
        this.funcionario = new Vendedor();
        this.cliente = new Cliente();
    }

    
    public Contrato(int id, Vendedor funcionario, Cliente cliente, Imovel imovel, double valor) {
        this.id = id;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.imovel = imovel;
        this.valor = valor;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vendedor getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Vendedor funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Contrato t) {
        return Integer.compare(id, t.getId());
    }
    
    
}
