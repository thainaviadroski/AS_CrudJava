package controle;

import java.util.ArrayList;

import DAO.ImovelDao;
import DAO.ImovelRuralDao;
import DAO.ImovelUrbanoDao;
import enums.TipoImovel;
import modelo.Imovel;
import modelo.ImovelRural;
import modelo.ImovelUrbano;
import util.Input;

public class ControllerImovel {

	static ImovelDao imovelDao = new ImovelDao();
	static ImovelRuralDao imovelRuralDao = new ImovelRuralDao();
	static ImovelUrbanoDao imovelUrbanoDao = new ImovelUrbanoDao();

	public static void cadastrar() {
		Imovel imovel = null;

		System.out.println("Tipo de imóvel");
		System.out.println("1 - Imóvel Urbano");
		System.out.println("2 - Imóvel Rural");
		int op = Input.nextInt();

		switch (op) {
			case 1:
				imovel = new ImovelRural();
				imovel.setTipo(TipoImovel.IMOVEL_RURAL);
				break;
			case 2:
				imovel = new ImovelUrbano();
				imovel.setTipo(TipoImovel.IMOVEL_URBANO);
				break;
		}

		setarInformacoes(imovel);

		imovelDao.save(imovel);

		if (imovel instanceof ImovelRural) {
			imovelRuralDao.save();

		}
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
		imovel.setProprietario(ControllerPessoa.pesquisar(cpf));
		if (imovel.getProprietario() == null) {
			imovel.setProprietario(ControllerPessoa.cadastrar());
		}

		if (imovel instanceof ImovelRural) {
			ImovelRural imovelRural = (ImovelRural) imovel;
			System.out.println("Cadastro Ambiental Rural: ");
			imovelRural.setCadPro(Input.next());
		}


		imovelDao.save(imovel);
	}

	public static Imovel pesquisar(String matriculaImovel) {
		return null;
	}

	public static void remover(Imovel imovel) {

	}

	public static void listar() {
	}
}
