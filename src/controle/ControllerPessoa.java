package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import DAO.PessoaDao;
import modelo.Pessoa;
import util.DateUtils;
import util.Input;

/**
 * @author Andre
 */
public class ControllerPessoa {
	protected static ArrayList<Pessoa> pessoas = new ArrayList<>();

	private static PessoaDao pessoaDao = new PessoaDao();

	public static ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public static Pessoa cadastrar() {
		Pessoa p = new Pessoa();
		PessoaDao pessoaDao = new PessoaDao();
		setarInformacoes(p);
		boolean save = pessoaDao.salvar(p);

		p.toString();

		if (save == true) {
			System.out.println("DEU CERTO POOOOOOOORRRRAAAA.....");
			p.toString();
		} else {
			System.out.println("FUUUUUDDDDDEEUUU!!!!");
			p.toString();
		}

		return p;

	}

	public static void editar(Pessoa p) {
		setarInformacoes(p);
	}

	public static void setarInformacoes(Pessoa p) {
		if (p == null) {
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
		List<Pessoa> clientes = new ArrayList<>();
		clientes = pessoaDao.carregarPessoas();

		for (Pessoa p : clientes) {
			System.out.println("Nome: " + p.getNome() + "\nCPF: " + p.getCpf() + "\n" + DateUtils.dataFormat(p.getDataNasc()));
			System.out.println("Rua " + p.getEndereco().getRua() + " nº " + p.getEndereco().getNumero() + " - Cidade: " + p.getEndereco().getCidade());
			System.out.println("------");
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
