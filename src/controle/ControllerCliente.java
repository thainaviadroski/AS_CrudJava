package controle;

import DAO.ClienteDao;
import modelo.Cliente;
import modelo.Pessoa;
import util.DateUtils;

import java.util.List;

public class ControllerCliente extends ControllerPessoa {
	static ClienteDao clienteDao = new ClienteDao();

	public static Cliente cadastrar() {
		Cliente c = new Cliente();
		setarInformacoes(c);

		clienteDao.save(c);
		return c;
	}

	public static void listar() {
		List<Pessoa> pessoas = ClienteDao.findAll();

		pessoas.stream().map(cliente -> "Nome: " + cliente.getNome() + "\nCPF: " + cliente.getCpf()
						+ "\nData de Nascimeto:" + DateUtils.dataFormat(cliente.getDataNasc())
						+ "\nEndereço: Rua " + cliente.getEndereco().getRua() + ", Nª" + cliente.getEndereco().getNumero() + " - "
						+ cliente.getEndereco().getCidade())
				.forEach(System.out::println);

	}

}
