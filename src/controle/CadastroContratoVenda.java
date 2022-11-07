package controle;

import static controle.CadastroContrato.contratos;
import modelo.ContratoVenda;
import util.Input;

public class CadastroContratoVenda extends CadastroContrato{
    
    public static ContratoVenda cadastrar() {
        ContratoVenda contr = new ContratoVenda();
        setarInformacoes(contr);
        contratos.add(contr);
        return contr;
    }

    public static void editar(ContratoVenda contr) {
        setarInformacoes(contr);
    }

    public static void setarInformacoes(ContratoVenda contr) {
        CadastroContrato.setarInformacoes(contr);

        System.out.print("Forma de pagamento: ");
        contr.setFormaPagamento(Input.nextLine());

        System.out.print("Parcelas: ");
        contr.setQtdParcelas(Input.nextInt());
    }
    
    public static void listar() {
        CadastroContrato.listar(ContratoVenda.class);
    }
}
