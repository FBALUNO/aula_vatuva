package Fila_Salario;

import java.util.Scanner;

import Kudissanga_Principal.Kudissanga_LDA;

public class ProgramaPrincipal {

	public static void main(String[] args) throws Exception {
		Fila<String> filaNormal = new Fila<>();
		Prioridades<String> filaPrioridade = new Prioridades<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Sistema de Atendimento");
		System.out.println(" ");

		while (true) {
			System.out.print("Escolha uma das opcaoes: ");
			System.out.println("\nOpcoes                Descricao ");
			System.out.println("    1 -        Para Adicionar pessoa a Fila");
			System.out.println("    2 -        Para Remover pessoa a lista");
			System.out.println("    3 -        Para Consultar as pessoas da fila");
			System.out.println("    4 -        Se Pretende Encerrar programa");
			int opcao = scanner.nextInt();

			if (opcao == 1) {
				System.out.print("\nDigite o nome do serviço: ");
				String nome = scanner.next();
				System.out.print("É prioritária?: Digite (S ou N): ");
				String prioritaria = scanner.next();

				if (prioritaria.equalsIgnoreCase("S")) {
					filaPrioridade.Enfileirar(nome);
					System.out.println("Pessoa adicionada com prioridade.");
				} else {
					filaNormal.Enfileirar(nome);
					System.out.println("Pessoa adicionada como normal.");
				}
			} else if (opcao == 2) {
				System.out.println("\nForam removidas as seguintes pessoas:");
				while (!filaPrioridade.estaVazia()) {
					atendimentoPublico(filaPrioridade);
				}
				while (!filaNormal.estaVazia()) {
					atendimentoPublico(filaNormal);
				}
			} else if (opcao == 3) {
				System.out.println("\nConsulta da fila:");
				System.out.println("Faz parte das prioritárias:");
				System.out.println(filaPrioridade.toString());
				System.out.println("Faz parte das Pessoas normais:");
				System.out.println(filaNormal.toString());
			} else if (opcao == 4) {
				System.out.println("Menu Principal");
				Kudissanga_LDA.main(null);
				break;
			} else {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}

		scanner.close();
	}

	public static void atendimentoPublico(Fila<String> fila) {
		String pessoaAtendida = fila.Desinfileirar();
		System.out.println(pessoaAtendida + " - A pessoa foi atendida.");
	}
}
