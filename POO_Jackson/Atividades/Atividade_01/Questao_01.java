
import java.util.Scanner;

// # Questão 1: Calculadora com Operadores Básicos

// Desenvolva um programa em Java que leia dois números inteiros do usuário e exiba o resultado das 
// operações básicas (adição, subtração, multiplicação, divisão e módulo). 
// Utilize Scanner para entrada de dados e trate possíveis exceções com try/catch.

public class Questao_01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println(" -- Operações básicas (adição, subtração, multiplicação, divisão e módulo) -- \n\n");

        System.out.println("Informe o primeiro número: ");
        int numeroUm = entrada.nextInt();

        System.out.println("Informe o segundo número: \n\n");
        int numeroDois = entrada.nextInt();

        System.out.println("Digite a operação desejada (+, -, /, *, %): ");
        String valorOperacao = entrada.next();

        Integer valorTotal = null;

        switch (valorOperacao) {
            case ("+"):
                valorTotal = numeroUm + numeroDois;
                break;
            case ("-"):
                valorTotal = numeroUm - numeroDois;
                break;
            case ("/"):
                try {
                    if (numeroUm == 0 || numeroDois == 0) {
                        throw new ArithmeticException("Não é possível dividir por zero.");
                    }
                    valorTotal = numeroUm / numeroDois;
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            case ("*"):
                valorTotal = numeroUm * numeroDois;
                break;
            case ("%"):
                valorTotal = numeroUm % numeroDois;
                break;
            default:
                System.out.println("Valor Inválido.");
                break;
        }

        System.out.println("Resultado: " + valorTotal);
    }
}