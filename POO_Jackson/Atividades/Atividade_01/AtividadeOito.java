package atividades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtividadeOito {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.print("Informe um número inteiro positivo: ");
            int numero = entrada.nextInt();

            if (numero < 0) {
                System.out.println("Digite apenas números positivos.");
                return;
            }

            String numeroTexto = numero + "";

            int quantidadeDigitos = 0;

            for (int i = 0; i < numeroTexto.length(); i++) {
                quantidadeDigitos++;
            }

            System.out.println("Quantidade de dígitos: " + quantidadeDigitos);

        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números inteiros.");
        }

        entrada.close();
    }
}