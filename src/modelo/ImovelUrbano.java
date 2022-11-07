package modelo;

public class ImovelUrbano extends Imovel{

    protected double calcularIPTU(){
        return 0;
    }

    public ImovelUrbano() {
    }

    public ImovelUrbano(String matriculaImovel, Pessoa proprietario, Endereco endereco, double largura, double comprimento, double valor) {
        super(matriculaImovel, proprietario, endereco, largura, comprimento, valor);
    }
    
    @Override
    public double calcularArea() {
        return largura * comprimento;
    }
}
