package controle;

import java.util.ArrayList;
import java.util.Collections;
import modelo.Pessoa;
import util.Input;

/**
 *
 * @author Andre
 */
public class CadastroPessoa {
    protected static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }
    
    public static Pessoa cadastrar() {
        Pessoa p = new Pessoa();
        setarInformacoes(p);
        pessoas.add(p);
        return p;
    }
    
    public static void editar(Pessoa p) {
        setarInformacoes(p);
    }
    
    public static void setarInformacoes(Pessoa p) {
        if(p == null){
            System.out.println("Falha ao setar informações da Pessoa!");
            return;
        }
        
        System.out.print("\nNome: ");
        p.setNome(Input.nextLine());
        
        System.out.print("CPF: ");
        p.setCpf(Input.next());
        
        System.out.print("Data Nascimento (ano-mês-dia): ");
        p.setDataNasc(Input.nextDate());
        
        CadastroEndereco.setarInformacoes(p.getEndereco());
    }
    
    public static void ordenarLista(ArrayList list) {
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
        if (pessoas == null || pessoas.isEmpty()) {
            System.out.println("A Lista está Vazia!");
        } else {
            ordenarLista(pessoas);
            System.out.println("\n#########---------- Cadastro de Pessoas ----------#########");
            int n = 1;
            for (Pessoa p : pessoas) {
                System.out.print("\n"+ (n++) + ". ");
                p.exibirInformacoes();
            }
            System.out.println("\n#########---------- ######### ----------#########");
        }
    }

    public static void remover(Pessoa p) {
        if (pessoas.remove(p)) {
            System.out.println("O cadastro: " + p.getNome() + " - " + p.getCpf() + " foi removido com sucesso!");
        } else {
            System.out.println("Falha ao remover imóvel!");
        }
    }

    public static Pessoa pesquisar(String cpf) {
        for (Pessoa p : pessoas) {
            if (cpf.compareTo(p.getCpf()) == 0) {
                return p;
            }
        }
        return null;
    }
}
