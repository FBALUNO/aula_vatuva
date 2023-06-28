package Lista_MarcarReuniao;

import java.util.Scanner;
import java.util.UUID;

import Kudissanga_Principal.Kudissanga_LDA;
import Lista_MarcarReuniao.CircularList_logic;
import Lista_MarcarReuniao.reuniao_logica;

public class Principal {

	public static void main(String[] args) throws Exception {
		System.setProperty("file.encoding", "UTF-8");
		monitor();
	}

	private static void monitor() throws Exception {
		final var listaAvioes = new CircularList_logic<reuniao_logica>();
		dados();
		var leitor = new Scanner(System.in);
		int opcao = leitor.nextInt();
		while (opcao != 5) {
			switch (opcao) {
			case 1:
				reuniao_logica novoAviao = adicionar();
				listaAvioes.addFirst(novoAviao);
				dados();
				opcao = leitor.nextInt();
				break;
			case 2:
				listarAvioes(listaAvioes);
				dados();
				opcao = leitor.nextInt();
				break;
			case 3:
				System.out.println("\nRemovendo aviões prioritários:");
				removerAvioesPrioritarios(listaAvioes);
				dados();
				opcao = leitor.nextInt();
				break;
			case 4:
				System.out.printf("\nTamanho da Lista: %d", listaAvioes.getSize());
				dados();
				opcao = leitor.nextInt();
				break;
			}
		}
	}

	private static reuniao_logica adicionar() {
		var leitor = new Scanner(System.in);
		System.out.println("Digite o nome da Reuniao:");
		var nome = leitor.nextLine();
		System.out.println("É um avião prioritário? (s/n)");
		var prioritario = leitor.nextLine();
		var novoAviao = new reuniao_logica(UUID.randomUUID(), nome, prioritario.equalsIgnoreCase("s"));
		return novoAviao;
	}

	private static void listarAvioes(CircularList_logic<reuniao_logica> listaAvioes) {
		System.out.println("\nAviões na lista:");
		if (listaAvioes.isEmpty()) {
			System.out.println("A lista está vazia.");
		} else {
			for (int i = 0; i < listaAvioes.getSize(); i++) {
				reuniao_logica a = listaAvioes.get(i);
				System.out.printf("Nome: %s - Prioritário: %s\n", a.getNomeAviao(), a.isEspecial() ? "Sim" : "Não");
			}
		}
	}

	private static void removerAvioesPrioritarios(CircularList_logic<reuniao_logica> listaAvioes) {
		boolean avioesRemovidos = false;
		for (int i = listaAvioes.getSize() - 1; i >= 0; i--) {
			reuniao_logica a = listaAvioes.get(i);
			if (a.isEspecial()) {
				System.out.printf("Removido: %s - Prioritário: Sim\n", a.getNomeAviao());
				listaAvioes.removeLast();
				avioesRemovidos = true;
			}
		}
		if (!avioesRemovidos) {
			System.out.println("Não há Reuniao prioritários na lista.");
		}
	}

	public static void dados() {
		String mensagem = """
				============ Livraria LCC2N ==========
				    1 - Adicionar Reuniao
				    2 - Consultar Reuniao
				    3 - Remover Reuniao prioritários
				    4 - Ver quantidade de Reuniao
				    5 - Para sair
				    """;
		System.out.println(mensagem);
	}
}
