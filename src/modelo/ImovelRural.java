package modelo;

public class ImovelRural extends Imovel{
    
    protected  String cadPro;
    
    public double calcularICMS(){
        return 0;
    }

    public ImovelRural() {
    }

    public ImovelRural(String matriculaImovel, Pessoa proprietario, Endereco endereco, double largura, double comprimento, double valor) {
        super(matriculaImovel, proprietario, endereco, largura, comprimento, valor);
    }
    
    @Override
    public double calcularArea(){
        return largura * comprimento;
    }

    public String getCadPro() {
        return cadPro;
    }

    public void setCadPro(String cadPro) {
        this.cadPro = cadPro;
    }
    
    
}
