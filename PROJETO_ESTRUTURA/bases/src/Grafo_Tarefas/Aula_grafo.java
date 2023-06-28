package Grafo_Tarefas;

import java.util.ArrayList;
import java.util.Scanner;

import Kudissanga_Principal.Kudissanga_LDA;
public class Aula_grafo {
    
    public static void main(String[] args) throws Exception {
        Grafo<String> grafo = new Grafo<String>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistema de Gerenciamento de Grafo");

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1 - Adicionar elemento ao vértice");
            System.out.println("2 - Adicionar elemento ao aresta");
            System.out.println("3 - Remover elemento ao vértices prioritários");
            System.out.println("4 - Consultar grafo");
            System.out.println("5 - Encerrar programa");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("\nDigite o nome do elemento: ");
                String nome = scanner.next();
                grafo.adicionarVertice(nome);
                System.out.println("Elemento adicionado com sucesso.");
            } else if (opcao == 2) {
                System.out.print("\nDigite o peso da aresta: ");
                Double peso = scanner.nextDouble();
                System.out.print("Digite o nome do vértice de início: ");
                String inicio = scanner.next();
                System.out.print("Digite o nome do vértice de fim: ");
                String fim = scanner.next();
                grafo.adicionarAresta(peso, inicio, fim);
                System.out.println("Aresta adicionada com sucesso.");
            } else if (opcao == 3) {
                grafo.removerVerticesPrioritarios();
                System.out.println("Vértices prioritários removidos.");
            } else if (opcao == 4) {
                System.out.println("\nConsulta do grafo:");
                System.out.println(grafo.toString());
            } else if (opcao == 5) {
            	System.out.println("Menu Principal");
				Kudissanga_LDA.main(null);
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}