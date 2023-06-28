package ArvoreBinaria_Atividade_Diária;

import java.util.Scanner;
import java.util.UUID;

import Kudissanga_Principal.Kudissanga_LDA;

public class Main {

    public static void main(String[] args) throws Exception {
        Atividade_BinaryTree<Atividade> tree = new Atividade_BinaryTree<>();
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 5) {
            printMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            switch (option) {
                case 1:
                    Atividade atividade = createAviao(scanner);
                    tree.add(atividade);
                    System.out.println("Atividade adicionada com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de Atividade:");
                    tree.printInOrder();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Digite o ISBN do Atividade que deseja remover:");
                    UUID isbn = UUID.fromString(scanner.nextLine());
                    Atividade removedAviao = removeAviao(tree, isbn);
                    if (removedAviao != null) {
                        System.out.println("Atividade removido: " + removedAviao);
                    } else {
                        System.out.println("Atividade não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Quantidade de Atividade: " + countAvioes(tree));
                    break;
                case 5:
                	System.out.println("Menu Principal");
    				Kudissanga_LDA.main(null);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("====================");
        System.out.println("1 - Adicionar elemento");
        System.out.println("2 - Consultar elementos");
        System.out.println("3 - Remover elementos");
        System.out.println("4 - Ver quantidade de elementos");
        System.out.println("5 - Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static Atividade createAviao(Scanner scanner) {
        System.out.println("Digite o elemento:");
        String nomeAviao = scanner.nextLine();
        System.out.println("É Prioritário? (s/n)");
        String especial = scanner.nextLine();
        boolean isEspecial = especial.equalsIgnoreCase("s");
        UUID isbn = UUID.randomUUID();
        return new Atividade(isbn, nomeAviao, isEspecial);
    }

    private static Atividade removeAviao(Atividade_BinaryTree<Atividade> tree, UUID isbn) {
        Atividade atividade = new Atividade(isbn, "", false);
        tree.remove(atividade);
        return atividade;
    }

    private static int countAvioes(Atividade_BinaryTree<Atividade> tree) {
        return countAvioesRecursive(tree.getRoot());
    }

    private static int countAvioesRecursive(TreeNode<Atividade> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countAvioesRecursive(node.getLeft()) + countAvioesRecursive(node.getRight());
    }
}
