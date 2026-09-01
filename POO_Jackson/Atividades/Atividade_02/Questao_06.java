
import java.util.HashMap;
import java.util.Scanner;

// # Questão 6: Controle de Estoque com HashMap

// Desenvolva um sistema simples de estoque utilizando um HashMap<String, Integer>, no qual a chave representa o nome do produto e o valor representa a quantidade disponível.
// O menu deve oferecer as opções de cadastrar produto, consultar estoque, atualizar quantidade, remover produto e listar todos os produtos.
// Utilize switch para as opções do menu e um laço while ou do/while para manter o sistema em execução. 
// Ao consultar ou atualizar um produto, verifique sua existência com if/else. Trate entradas numéricas inválidas com try/catch e faça as conversões necessárias.

public class Questao_06 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Controle de Estoque com HashMap --");

        HashMap<String, Integer> estoque = new HashMap<>();

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("(1) - Cadastrar Produto.");
            System.out.println("(2) - Consultar Produto.");
            System.out.println("(3) - Atualizar Produto.");
            System.out.println("(4) - Remover Produto.");
            System.out.println("(5) - Listar Todos os Produto.");
            System.out.println("(6) - sair.");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe um produto para cadastrar: ");
                    String nomeProduto = entrada.nextLine();

                    System.out.println("Informe a quantidade cadastrada: ");
                    int quantidadeProduto = entrada.nextInt();

                    if (quantidadeProduto >= 0) {
                        estoque.put(nomeProduto, quantidadeProduto);
                        System.out.println("Número cadastrado corretamente");
                    } else {
                        System.out.println("Não permite número negativo");
                    }
                    break;

                case 2:
                    System.out.println("Informe um produto para consultar: ");
                    String nomeProdutoConsultado = entrada.nextLine();

                    if (estoque.containsKey(nomeProdutoConsultado)) {
                        int quantidadeProdutoConsultado = estoque.get(nomeProdutoConsultado);

                        System.out.println("Produto: " + nomeProdutoConsultado);
                        System.out.println("Quantidade disponível: " + quantidadeProdutoConsultado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("Informe um produto para atualizar");
                    String nomeProdutoAtualizado = entrada.nextLine();

                    System.out.println("Informe a nova quantidade para ser atualizada");
                    int novaQuantidade = entrada.nextInt();

                    if (estoque.containsKey(nomeProdutoAtualizado)) {
                        estoque.put(nomeProdutoAtualizado, novaQuantidade);
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");

                    }

                    break;

                case 4:
                    System.out.println("Informe o produto para remover");
                    String nomeProdutoRemover = entrada.nextLine();

                    if (estoque.containsKey(nomeProdutoRemover)) {
                        estoque.remove(nomeProdutoRemover);
                        System.out.println("Produto removido.");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                    break;

                case 5:
                    for (String produto : estoque.keySet()) {
                        System.out.println("Produto: " + produto);
                        System.out.println("Quantidade: " + estoque.get(produto));
                    }

                    break;

                case 6:
                    System.out.println("Saindo...");
            }

        }
    }

}
