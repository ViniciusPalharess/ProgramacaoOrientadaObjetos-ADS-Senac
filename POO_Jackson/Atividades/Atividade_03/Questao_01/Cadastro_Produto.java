package POO_Jackson.Atividades.Atividade_03.Questao_01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cadastro_Produto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        int opcao = -1;

        do {
            System.out.println("=== Produto ===");
            System.out.println("0. Sair");
            System.out.println("1. Cadastrar Produto: ");
            System.out.println("2. Adicionar Quantidade ao Produto: ");
            System.out.println("3. Remover Quantidade ao Produto: ");
            System.out.println("4. Exiba Todos os Produtos: ");
            System.out.println("5. Valor Total Armazenado em Estoque: ");
            opcao = buscarOperacao(entrada);

            switch (opcao) {
                case 1:
                    System.out.println("Informe o nome do produto: ");
                    String nomeProduto = entrada.next();
                    System.out.println("Informe a quantidade do produto: ");
                    int quantidadeProduto = entrada.nextInt();
                    System.out.println("Informe o preço do produto: ");
                    float precoProduto = entrada.nextFloat();

                    Produto produto = new Produto(
                            nomeProduto,
                            precoProduto,
                            quantidadeProduto);

                    produtos.add(produto);
                    break;
                case 2:
                    System.out.println("Informe o nome do produto que deseja adicionar: ");
                    String nomeProdutoAdicionar = entrada.next();

                    for (Produto produtoRemover : produtos) {
                        if (produtoRemover.nome.equals(nomeProdutoAdicionar)) {
                            System.out.println("Informe a quantidade que deseja adicionar: ");
                            int quatidadeProdutoAdicionar = entrada.nextInt();

                            produtoRemover.adicionarEstoque(quatidadeProdutoAdicionar);
                            System.out.println("Item adicionado com sucesso!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Informe o nome do produto que deseja remover: ");
                    String nomeProdutoRemover = entrada.next();

                    for (Produto produtoRemover : produtos) {
                        if (produtoRemover.nome.equals(nomeProdutoRemover)) {
                            System.out.println("Informe a quantidade que deseja remover: ");
                            int quantidadeProdutoRemover = entrada.nextInt();

                            produtoRemover.removerEstoque(quantidadeProdutoRemover);
                            System.out.println("Item removido com sucesso!");
                        }
                    }
                    break;
                case 4:
                    for (Produto produtoVisualizar : produtos) {
                        produtoVisualizar.exibirDados();
                    }
                    break;
                case 5:
                    for (Produto produtoValorTotal : produtos) {
                        float valorTotal = produtoValorTotal.calcularValorEstoque();
                        System.out.println(produtoValorTotal.nome + " - Valor: " + valorTotal);
                    }
                    break;
                default:
                    System.out.println("Operação inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    public static int buscarOperacao(Scanner entrada) {
        int opcao = -1;

        do {
            try {
                opcao = entrada.nextInt();
            } catch (InputMismatchException e) {
                entrada.next();
                System.out.println("Operação inválida");
                System.out.println("Digite novamente a informação!");
                opcao = -1;
            }
        } while (opcao < 0);

        return opcao;
    }
}
