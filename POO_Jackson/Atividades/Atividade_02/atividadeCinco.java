package atividadeDois;
import java.util.HashSet;
import java.util.Scanner;

public class atividadeCinco {
       public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashSet<String> pessoas = new HashSet<>();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n===== CADASTRO DE PESSOAS =====");
            System.out.println("1 - Cadastrar nome");
            System.out.println("2 - Listar nomes");
            System.out.println("3 - Consultar nome");
            System.out.println("4 - Quantidade de pessoas");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1:
                        System.out.print("Digite o nome: ");
                        String nome = scanner.nextLine();

                        if (pessoas.add(nome)) {
                            System.out.println("Nome cadastrado com sucesso!");
                        } else {
                            System.out.println("Esse nome já está cadastrado.");
                        }
                        break;

                    case 2:
                        System.out.println("\nPessoas cadastradas:");

                        if (pessoas.isEmpty()) {
                            System.out.println("Nenhuma pessoa cadastrada.");
                        } else {
                            for (String pessoa : pessoas) {
                                System.out.println("- " + pessoa);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Digite o nome que deseja consultar: ");
                        String nomeConsultar = scanner.nextLine();

                        if (pessoas.contains(nomeConsultar)) {
                            System.out.println("O nome está cadastrado.");
                        } else {
                            System.out.println("O nome não está cadastrado.");
                        }
                        break;

                    case 4:
                        System.out.println("Quantidade de pessoas cadastradas: " + pessoas.size());
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
        }

        scanner.close();
    }
}
