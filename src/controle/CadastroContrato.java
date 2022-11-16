package controle;

import java.util.ArrayList;
import java.util.Collections;
import modelo.Cliente;
import modelo.Contrato;
import modelo.Vendedor;
import util.Input;

public class CadastroContrato {

    protected static ArrayList<Contrato> contratos = new ArrayList<>();

    public static ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public static Contrato cadastrar(Contrato p) {
        setarInformacoes(p);
        contratos.add(p);
        return p;
    }

    public static void editar(Contrato p) {
        setarInformacoes(p);
    }

    public static void setarInformacoes(Contrato contrato) {
        if (contrato == null) {
            System.out.println("Falha ao setar informações do Contrato!");
            return;
        }

        System.out.print("\nId: ");
        int idContrato = Input.nextInt();

        //verifica se o id informado já existe
        if (contrato.getId()==0 && pesquisar(idContrato) != null) {
            System.out.println("\nFalha! já existe contrato cadastrado com id contrato: " + idContrato);
            return;
        }

        contrato.setId(idContrato);
        System.out.println("Digite o cpf para buscar o cadastro do Vendedor:");
        String cpf = Input.next();
        contrato.setFuncionario((Vendedor) CadastroVendedor.pesquisar(cpf));
        if (contrato.getFuncionario() == null) {
            System.out.println("falha ao atribuir o vendedor ao contrato!");
        }

        System.out.println("Digite o cpf para buscar o cadastro do Cliente:");
        cpf = Input.next();
        contrato.setCliente((Cliente) ControllerCliente.pesquisar(cpf));
        if (contrato.getCliente() == null) {
            System.out.println("falha ao atribuir o cliente ao contrato!");
        }

        System.out.println("Digite a matricula do imóvel para buscar o cadastro:");
        String matricula = Input.next();
        contrato.setImovel(ControllerImovel.pesquisar(matricula));
        if (contrato.getImovel() == null) {
            System.out.println("falha ao atribuir o imóvel ao contrato!");
        }

        System.out.print("\nValor: ");
        contrato.setValor(Input.nextDouble());
    }

    public static void ordenarLista(ArrayList<Contrato> list) {
        System.out.println("1 - Ascendente: ");
        System.out.println("2 - Descendente: ");
        int op = Input.nextInt();

        if (op == 1) {
            Collections.sort(list);
        } else {
            Collections.sort(list, Collections.reverseOrder());
        }
    }

    public static void listar() {
        listar(Contrato.class);
    }

    public static void listar(Class t) {
        if (contratos == null || contratos.isEmpty()) {
            System.out.println("A Lista está Vazia!");
        } else {
            ordenarLista(contratos);
            System.out.println("\n#########---------- Cadastro de Contratos ----------#########");
            int n = 1;

            for (Contrato p : contratos) {
                if (t.isInstance(p)) {
                    System.out.print("\n" + (n++) + ". ");
                    p.exibirInformacoes();
                }
            }
            System.out.println("\n#########---------- ######### ----------#########");
        }
    }

    public static void remover(Contrato p) {
        if (contratos.remove(p)) {
            System.out.println("O contrato id:" + p.getId() + " cliente: " + p.getCliente().getNome() + " foi removido com sucesso!");
        } else {
            System.out.println("Falha ao remover contrato!");
        }
    }

    public static Contrato pesquisar(int id) {
        for (Contrato p : contratos) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }
}
