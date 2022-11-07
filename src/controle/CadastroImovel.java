package controle;

import java.util.ArrayList;
import modelo.Imovel;
import modelo.ImovelRural;
import modelo.ImovelUrbano;
import util.Input;

public class CadastroImovel {

    private static ArrayList<Imovel> imoveis = new ArrayList<>();

    public static ArrayList<Imovel> getImoveis() {
        return imoveis;
    }

    public static void cadastrar() {
        Imovel imovel = null;

        System.out.println("Tipo de imóvel");
        System.out.println("1 - Imóvel Urbano");
        System.out.println("2 - Imóvel Rural");
        int op = Input.nextInt();

        switch (op) {
            case 1:
                imovel = new ImovelRural();
                break;
            case 2:
                imovel = new ImovelUrbano();
                break;
        }

        setarInformacoes(imovel);
        // adiciona na lista de imoveis
        imoveis.add(imovel);
    }

    public static void editar(Imovel imovel) {
        setarInformacoes(imovel);
    }

    public static void setarInformacoes(Imovel imovel) {
        if (imovel == null) {
            System.out.println("Falha ao setar informações do imóvel!");
            return;
        }
        
        System.out.println("matricula imovel: ");
        String matricula = Input.next();
        
        //verifica se a matrícula informada já consta cadastrada no sistema
        if (imovel.getMatriculaImovel().isEmpty() && pesquisar(matricula) != null) {
            System.out.println("\nFalha! já existe imóvel cadastrado com a matrícula: " + matricula);
            return;
        }
        
        imovel.setMatriculaImovel(matricula);
        System.out.println("largura: ");
        imovel.setLargura(Input.nextDouble());
        System.out.println("comprimento: ");
        imovel.setComprimento(Input.nextDouble());
        System.out.println("valor: ");
        imovel.setValor(Input.nextDouble());

        CadastroEndereco.setarInformacoes(imovel.getEndereco());

        System.out.println("Digite o cpf para buscar o cadastro:");
        String cpf = Input.next();
        imovel.setProprietario(CadastroPessoa.pesquisar(cpf));
        if (imovel.getProprietario() == null) { // caso não encontrar a pessoa com o cpf digitado, criar um novo cadastro de pessoa
            imovel.setProprietario(CadastroPessoa.cadastrar());
        }

        if (imovel instanceof ImovelRural) {
            ImovelRural imovelRural = (ImovelRural) imovel;
            System.out.println("Cadastro Ambiental Rural: ");
            imovelRural.setCadPro(Input.next());
        }
    }

    public static Imovel pesquisar(String matriculaImovel) {
        if (imoveis == null || imoveis.isEmpty()) {
            System.out.println("A lista de imóveis está nula ou vazia!");
            return null;
        }

        for (int i = 0; i < imoveis.size(); i++) {
            if (imoveis.get(i).getMatriculaImovel().equalsIgnoreCase(matriculaImovel)) {
                return imoveis.get(i);
            }
        }

        System.out.println("O imóvel não foi encontrado!");
        return null;
    }

    public static void remover(Imovel imovel) {
        if (imoveis.remove(imovel)) {
            System.out.println("O imovel: " + imovel.getMatriculaImovel() + " foi removido com sucesso!");
        } else {
            System.out.println("Falha ao remover imóvel!");
        }
    }

    public static void listar() {
        if (imoveis == null || imoveis.isEmpty()) {
            System.out.println("A Lista está Vazia!");
        } else {
            System.out.println("\n#########---------- Lista de Imóveis ----------#########");
            int n = 1;
            for (Imovel p : imoveis) {
                System.out.print("\n" + (n++) + ". ");
                p.exibirInformacoes();
            }
            System.out.println("\n#########---------- ######### ----------#########");
        }
    }
}
