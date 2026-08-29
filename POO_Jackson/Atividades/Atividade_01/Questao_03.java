
import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 3: Tabuada com Laço for

// Implemente um programa que leia um número inteiro do usuário e exiba a tabuada desse número
// (de 1 a 10) utilizando um laço for. Valide a entrada com try/catch e utilize operadores de multiplicação.

public class Questao_03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Tabuada -- \n\n");

        try {
            System.out.println("Informe um número: ");
            int valorNumero = entrada.nextInt();

            for (int i = 0; i <= 10; i++) {
                int valorTotal = valorNumero * i;

                System.out.println(valorNumero + "x" + i + "=" + valorTotal);
            }
        } catch (InputMismatchException e) {
            System.out.println("Informe um número");
        }
    }
}