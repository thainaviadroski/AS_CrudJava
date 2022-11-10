package controle;

import modelo.Cliente;

public class ControllerCliente extends CadastroPessoa {

    public static Cliente cadastrar() {
        Cliente c = new Cliente();
        setarInformacoes(c);
        return c;
    }

    public static void listar() {
        if (pessoas == null || pessoas.isEmpty()) {
            System.out.println("A Lista está Vazia!");
        } else {
            ordenarLista(pessoas);
            System.out.println("\n#########---------- Cadastro de Clientes ----------#########");
            int n = 1;
            for (int i = 0; i < pessoas.size(); i++) {
                if (pessoas.get(i) instanceof Cliente) {
                    Cliente cli = (Cliente) pessoas.get(i);
                    System.out.print("\n" + (n++) + ". ");
                    cli.exibirInformacoes();
                }
            }
            System.out.println("\n#########---------- ######### ----------#########");
        }
    }

}
