package atividades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtividadeSete {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("(1) - Celsius para Fahrenheit");
            System.out.println("(2) - Fahrenheit para Celsius");
            System.out.print("Escolha uma opção: ");

            int opcao = entrada.nextInt();

            double resultado;

            switch (opcao) {
                case 1:
                    System.out.print("Informe a temperatura em Celsius: ");
                    double celsius = entrada.nextDouble();

                    resultado = (celsius * 9 / 5) + 32;

                    System.out.println("Temperatura em Fahrenheit: " + resultado);
                    break;

                case 2:
                    System.out.print("Informe a temperatura em Fahrenheit: ");
                    double fahrenheit = entrada.nextDouble();

                    resultado = (fahrenheit - 32) * 5 / 9;

                    System.out.println("Temperatura em Celsius: " + resultado);
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números.");
        }

        entrada.close();
    }
}