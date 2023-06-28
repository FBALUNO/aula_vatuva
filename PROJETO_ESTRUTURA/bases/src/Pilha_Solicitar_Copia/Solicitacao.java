package Pilha_Solicitar_Copia;
import java.util.Scanner;

import Kudissanga_Principal.Kudissanga_LDA;
public class Solicitacao {

	public static void main(String[] args) throws Exception {
		Pilha<Integer> pilha = new Pilha<Integer>();
		Scanner scanner = new Scanner(System.in);
		int option = -1;

		while (option != 4) {
			printMenu();
			option = scanner.nextInt();

			switch (option) {
				case 1:
					System.out.println("Por favor, digite o número:");
					int numero = scanner.nextInt();
					pilha.Empilhar(numero);
					System.out.println("Elemento " + numero + " adicionado à pilha.");
					break;
				case 2:
					Integer desempilhado = pilha.Desempilhar();
					if (desempilhado == null) {
						System.out.println("Pilha está vazia. Não é possível remover elemento.");
					} else {
						System.out.println("Elemento " + desempilhado + " removido da pilha.");
					}
					break;
				case 3:
					if (pilha.estaVazia()) {
						System.out.println("A pilha está vazia.");
					} else {
						System.out.println("Elementos na pilha: " + pilha.toString());
					}
					break;
				case 4:
					System.out.println("Ir ao Menu principal.");
					Kudissanga_LDA.main(null);
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private static void printMenu() {
		System.out.println("====================");
		System.out.println("Menu");
		System.out.println("1 - Adicionar elemento a pilha");
		System.out.println("2 - Remover elemento da pilha");
		System.out.println("3 - Verificar elementos na pilha");
		System.out.println("4 - Sair do programa");
		System.out.print("Escolha uma opcao: ");
	}
}
