import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 9: Validação de Entrada com Múltiplos try/catch

// Implemente um programa que leia três números decimais do usuário e calcule a média aritmética.
// Utilize múltiplos blocos try/catch para tratar diferentes tipos de exceção (NumberFormatException,
// InputMismatchException). Valide se os números são positivos com if/else.

public class Questao_09 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Valor da média com três números --\n");

        double valorUm = 0;
        double valorDois = 0;
        double numeroTres = 0;

        try {
            System.out.println("Informe o primeiro número:");
            String numeroUm = entrada.nextLine();

            valorUm = Double.parseDouble(numeroUm);

            if (valorUm <= 0) {
                throw new IllegalArgumentException("O número deve ser positivo.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Informe um número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Informe o segundo número:");
            String numeroDois = entrada.nextLine();

            valorDois = Double.parseDouble(numeroDois);

            if (valorDois <= 0) {
                throw new IllegalArgumentException("O número deve ser positivo.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Informe um número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Informe o terceiro número:");
            numeroTres = entrada.nextDouble();

            if (numeroTres <= 0) {
                throw new IllegalArgumentException("O número deve ser positivo.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Informe um número válido.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        double media = (valorUm + valorDois + numeroTres) / 3;

        System.out.println("Média: " + media);
    }
}