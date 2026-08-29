
import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 4: Soma de Números com while

// Desenvolva um programa que leia números inteiros do usuário em um laço while até que ele digite 0
// (zero). Ao final, exiba a soma de todos os números digitados. Utilize try/catch para tratar
// entradas inválidas.

public class Questao_04 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Soma dos números -- \n\n");

        int soma = 0;
        int numero = 0;

        do {
            try {
                System.out.println("(0)- Sair \n");

                System.out.println("Informe um número: ");
                numero = entrada.nextInt();

                soma += numero;
            } catch (InputMismatchException e) {
                System.out.println("Informe um número");
            }

        } while (numero != 0);

        System.out.println("Valor: " + soma);
    }
}