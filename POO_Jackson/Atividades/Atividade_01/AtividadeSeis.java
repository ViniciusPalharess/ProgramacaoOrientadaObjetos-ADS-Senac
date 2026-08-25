package atividades;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AtividadeSeis {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
        int numero;

        do {
            System.out.println("Validação de Número Par ou Ímpar.\n");
            System.out.println("Digite um número (-1 para sair): ");

            numero = entrada.nextInt();

            if (numero % 2 == 0) {
                System.out.println("Este número é par.");
            } else if (numero == -1) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Este número é ímpar.");
            }

        } while (true);
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números inteiros.");
            }

        entrada.close();
    }
}