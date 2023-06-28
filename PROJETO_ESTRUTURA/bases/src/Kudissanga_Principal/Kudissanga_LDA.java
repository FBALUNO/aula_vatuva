package Kudissanga_Principal;

import java.util.Scanner;

import ArvoreBinaria_Atividade_Diária.Main;
import Fila_Salario.ProgramaPrincipal;
import Grafo_Tarefas.Aula_grafo;
import Lista_MarcarReuniao.Principal;
import Pilha_Solicitar_Copia.Solicitacao;

public class Kudissanga_LDA {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 7) {
            printMainMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            switch (option) {
                case 1:
                    System.out.println("Esta aberto o programa de Fila");
                    ProgramaPrincipal.main(null);
                    break;
                case 2:
                    System.out.println("Esta aberto o programa de Pilha...");
                    Solicitacao.main(null);
                    break;
                case 3:
                    System.out.println("Esta aberto o programa de Lista...");
                    Principal.main(null);
                    break;
                case 4:
                    System.out.println("Esta aberto o programa de Árvore...");
                    Main.main(null);
                    break;
                case 5:
                    System.out.println("Esta aberto o programa de Grafos...");
                    Aula_grafo.main(null);
                    break;
                case 6:
                    System.out.println("Voltamos ao menu principal...");
                    break;
                case 7:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("====================");
        System.out.println("Menu Principal");
        System.out.println("1 - Programa PagarSalario");
        System.out.println("2 - Programa SolicitarCopia");
        System.out.println("3 - Programa MarcarReuniao");
        System.out.println("4 - Programa AtividadeDiaria");
        System.out.println("5 - Programa Tarefas");
        System.out.println("6 - Voltar ao menu principal");
        System.out.println("7 - Encerrar programa");
        System.out.print("Escolha uma opção: ");
    }
}

