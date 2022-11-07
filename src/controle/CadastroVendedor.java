package controle;

import java.util.ArrayList;
import modelo.Pessoa;
import modelo.Vendedor;
import util.Input;

public class CadastroVendedor extends CadastroPessoa {

    public static Vendedor cadastrar() {
        Vendedor v = new Vendedor();
        setarInformacoes(v);
        pessoas.add(v);
        return v;
    }

    public static void editar(Vendedor v) {
        setarInformacoes(v);
    }

    public static void setarInformacoes(Vendedor v) {
        CadastroPessoa.setarInformacoes(v);

        System.out.print("\nSalário: ");
        v.setSalario(Input.nextDouble());

        System.out.print("Percentual Comissão: ");
        v.setPercentualComissao(Input.nextDouble());
    }

    public static void listar() {
        if (pessoas == null || pessoas.isEmpty()) {
            System.out.println("A Lista está Vazia!");
        } else {
            ordenarLista(pessoas);
            System.out.println("\n#########---------- Cadastro de Vendedores ----------#########");
            int n = 1;
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i) instanceof Vendedor) {
                    Vendedor v = (Vendedor) pessoas.get(i);
                    System.out.print("\n" + (n++) + ". ");
                    v.exibirInformacoes();
                }
            }
            System.out.println("\n#########---------- ######### ----------#########");
        }
    }
}
