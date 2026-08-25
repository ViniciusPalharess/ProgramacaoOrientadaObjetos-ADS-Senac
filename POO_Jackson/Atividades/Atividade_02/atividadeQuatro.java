package atividadeDois;
import java.util.ArrayList;
import java.util.Scanner;

public class atividadeQuatro {
        public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> listaCompras = new ArrayList<>();

        int opcao = 0;

        do {
            System.out.println("\n===== LISTA DE COMPRAS =====");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Listar produtos");
            System.out.println("4 - Consultar produto");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1:
                        System.out.print("Digite o nome do produto: ");
                        String produto = scanner.nextLine();

                        listaCompras.add(produto);

                        System.out.println("Produto adicionado!");
                        break;

                    case 2:
                        System.out.print("Digite o nome do produto que deseja remover: ");
                        String produtoRemover = scanner.nextLine();

                        if (listaCompras.remove(produtoRemover)) {
                            System.out.println("Produto removido!");
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                        break;

                    case 3:
                        System.out.println("\nProdutos da lista:");

                        if (listaCompras.isEmpty()) {
                            System.out.println("A lista está vazia.");
                        } else {
                            for (String item : listaCompras) {
                                System.out.println("- " + item);
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Digite o nome do produto que deseja consultar: ");
                        String produtoConsultar = scanner.nextLine();

                        if (listaCompras.contains(produtoConsultar)) {
                            System.out.println("O produto está na lista.");
                        } else {
                            System.out.println("O produto não está na lista.");
                        }
                        break;

                    case 5:
                        System.out.println("Programa encerrado.");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite uma opção válida.");
                scanner.nextLine();
            }

        } while (opcao != 5);

        scanner.close();
    }
}
