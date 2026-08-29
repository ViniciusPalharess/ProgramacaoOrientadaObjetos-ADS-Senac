
import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 6: Verificação de Número Par ou Ímpar com do/while

// Implemente um programa que utilize um laço do/while para ler números do usuário e verificar se são
// pares ou ímpares. O programa deve continuar até que o usuário digite -1. Utilize o operador módulo
// (%) e try/catch para validação.

public class Questao_06 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Verificação de Número Par ou Ímpar -- \n\n");

        int valorOpcao = 0;

        do {
            System.out.println("(-1) - Sair");
            System.out.println("Informe um número para verificação de Impar ou Par: ");

            valorOpcao = entrada.nextInt();

            try {
                if (valorOpcao % 2 == 0) {
                    System.out.println("Número: " + valorOpcao + " é Par");
                } else {
                    System.out.println("Número: " + valorOpcao + " é Impar");
                }
            } catch (InputMismatchException e) {
                System.out.println("Informe um número.");
            }

        } while (valorOpcao != -1);
    }
}