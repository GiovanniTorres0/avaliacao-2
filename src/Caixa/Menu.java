package Caixa;

import java.util.Scanner;

public class Menu {

	public int menu(Scanner scanner) {
		int opcao;
		System.out.println("\nESCOLHA UMA OP��O:");
		System.out.println("1- Cadastre 3 ofertas\n2- Atualizar primeira oferta cadastrada\n3- Excluir segunda oferta cadastrada\n4- Selecionar um Range de Produtos\n5- Insirir Auto 3 Produtos\n6- 20 produtos para Teste\n0- Sair");
		opcao = scanner.nextInt();
		return opcao;
	}
}