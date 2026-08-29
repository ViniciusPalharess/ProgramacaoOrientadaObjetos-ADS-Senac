
import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 5: Menu com switch

// Crie um programa de menu que oferece as seguintes opções: (1) Calcular área de um quadrado, (2)
// Calcular área de um círculo, (3) Calcular perímetro de um retângulo, (4) Sair. Utilize switch para
// controlar o fluxo, Scanner para entrada e try/catch para tratamento de erros.

public class Questao_05 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Cálculo (área do quadrado), (área do círculo), (perímetro do retângulo) -- \n\n");
        int numeroOpcao = 0;

        try {
            do {
                System.out.println("(1) - Calcular área de um quadrado");
                System.out.println("(2) - Calcular área de um círculo");
                System.out.println("(3) - Calcular perímetro de um retângulo");
                System.out.println("(4) - Sair");

                System.out.print("Escolha uma opção: ");
                numeroOpcao = entrada.nextInt();

                switch (numeroOpcao) {
                    case 1:
                        System.out.println("Informe o valor do lado: ");
                        double lado = entrada.nextDouble();

                        double valorAreaQuadrado = lado * lado;

                        System.out.println("Área do quadrado: " + valorAreaQuadrado);
                        break;

                    case 2:
                        System.out.println("Informe o raio do círculo: ");
                        double raio = entrada.nextDouble();
                        double pi = 3.14;

                        if (raio <= 0) {
                            throw new IllegalArgumentException("O raio deve ser maior que zero.");
                        }

                        double valorAreaCirculo = pi * raio * raio;

                        System.out.println("Área do círculo: " + valorAreaCirculo);
                        break;

                    case 3:
                        System.out.println("Informe o valor da base: ");
                        double base = entrada.nextDouble();

                        System.out.println("Informe o valor da altura: ");
                        double altura = entrada.nextDouble();

                        double valorPerimetroRetangulo = 2 * (base + altura);

                        System.out.println("Perímetro do retângulo:" + valorPerimetroRetangulo);
                        break;

                    case 4:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida");
                }
            } while (numeroOpcao != 4);
        } catch (InputMismatchException e) {
            System.out.println("Informe um número.");
        }
    }
}