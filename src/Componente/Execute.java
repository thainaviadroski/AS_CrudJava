package Componente;

import util.Input;

public abstract class Execute {
	public static void menu() {
		System.out.println("...\n");

		System.out.println("Qual operação deseja realizar?\n1- Cliente | 2- Funcionario | 3- Imoveis | 4- Contratos | 0- Sair");
		System.out.print("->");
		int op = Input.nextInt();
		int exit = 1;
		do {
			switch (op) {
				case 1:
					System.out.println("Sub-menu Cliente");
					menuCliente();
					break;
				case 2:
					System.out.println("Sub-menu Funcionario");
					break;
				case 3:
					System.out.println("Sub-menu Imoveis");
					break;
				case 4:
					System.out.println("Sub-menu Contratos");
					break;
				case 0:
					System.out.println("Deseja sair ? ");
					exit = Input.nextInt();
					break;
				default:
					System.out.println("ERRO!! Selecione um opção valida");
					break;
			}
		} while (exit != 0);
	}

	public static void menuCliente() {
		System.out.println("....MENU DO CLIENTE....\n");
		System.out.println("1- Cadastrar | 2- Listar | 3- Buscar | 4- Atualizar | 5- Remover");
		int op = Input.nextInt();

		switch (op) {
			case 1:
				System.out.println("Cadastar Cliente:");
				break;
			case 2:
				System.out.println("Listar de Clientes:");
				break;
			case 3:
				System.out.println("Buscar Cliente:");
				break;
			case 4:
				System.out.println("Atualizar Cliente:");
				break;
			case 5:
				System.out.println("Remover Cliente:");
				break;
			default:
				System.out.println("ERRO!! Selecione um opção valida");
				break;
		}

	}
}
