package atividades;
import java.util.Scanner;

public class AtividadeDois {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Integer opcao;

        do {
            System.out.println("(1) - Calcular área de um quadrado");
            System.out.println("(2) - Calcular área de um círculo");
            System.out.println("(3) - Calcular perímetro de um retângulo");
            System.out.println("(4) - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o número do lado: ");
                    Double ladoUm = entrada.nextDouble();

                    Double valorAreaQuadrado = ladoUm * ladoUm;

                    System.out.println("Área do quadrado: " + valorAreaQuadrado);
                    break;

                case 2:
                    System.out.print("Informe o número do raio do círculo: ");
                    Double raio = entrada.nextDouble();

                    Double valorAreaCirculo = 3.14 * (raio * raio);

                    System.out.println("Área do círculo: " + valorAreaCirculo);
                    break;

                case 3:
                    System.out.print("Informe o comprimento: ");
                    Double comprimento = entrada.nextDouble();

                    System.out.print("Informe a largura: ");
                    Double largura = entrada.nextDouble();

                    Double valorPerimetroRetangulo = 2 * (comprimento + largura);

                    System.out.println("Perímetro do retângulo: " + valorPerimetroRetangulo);
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 4);

        entrada.close();
    }
}