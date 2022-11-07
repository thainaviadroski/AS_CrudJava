package modelo;

public class Endereco{
    
    private int id;
    private String cidade;
    private int numero;
    private String rua;

    public Endereco(String cidade, int numero, String rua) {
        this.cidade = cidade;
        this.numero = numero;
        this.rua = rua;
    }

    public Endereco() {
        
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Endereco{" + "cidade=" + cidade + ", numero=" + numero + ", rua=" + rua + '}';
    }
    
    public void exibirInformacoes(){
        System.out.println(" Cidade: "+ cidade + " Rua: "+ rua + " n: "+ numero );
    }
}
