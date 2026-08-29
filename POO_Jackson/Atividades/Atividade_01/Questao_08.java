
import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 8: Contagem de Dígitos com for

// Crie um programa que leia um número inteiro positivo e conte quantos dígitos ele possui. Utilize
// um laço for com conversão de String, operadores relacionais e try/catch para validação de entrada.

public class Questao_08 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Contagem de Dígitos Positivos -- \n\n");

        try {
            System.out.println("Informe um número inteiro positivo:  ");
            int numero = entrada.nextInt();

            if (numero <= 0) {
                System.out.println("Informe um número positivo.");
            } else {

                String numeroString = String.valueOf(numero);
                int quantidadeDigitos = 0;

                for (int i = 0; i < numeroString.length(); i++) {
                    quantidadeDigitos++;
                }

                System.out.println("O número possui " + quantidadeDigitos + " dígitos.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Informe um número inteiro.");
        }
    }
}