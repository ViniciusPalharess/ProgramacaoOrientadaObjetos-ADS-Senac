import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 7: Conversão de Temperatura

// Desenvolva um programa que converta temperaturas entre Celsius e Fahrenheit. Ofereça um menu com
// switch para escolher a conversão desejada. Utilize Scanner para entrada, operadores aritméticos
// para cálculo e try/catch para tratamento de exceções.

public class Questao_07 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Conversão de Temperatura --\n");

        System.out.println("Informe qual conversão deseja realizar:");
        System.out.println("(1) - Celsius para Fahrenheit");
        System.out.println("(2) - Fahrenheit para Celsius");

        try {
            int valorOpcao = entrada.nextInt();

            switch (valorOpcao) {
                case 1:
                    System.out.println("Informe o valor da temperatura em Celsius:");
                    double temperaturaCelsius = entrada.nextDouble();

                    double valorFahrenheit = (temperaturaCelsius * 9 / 5) + 32;

                    System.out.println("Fahrenheit: " + valorFahrenheit);
                    break;

                case 2:
                    System.out.println("Informe o valor da temperatura em Fahrenheit:");
                    double temperaturaFahrenheit = entrada.nextDouble();

                    double valorCelsius = (temperaturaFahrenheit - 32) * 5 / 9;

                    System.out.println("Celsius: " + valorCelsius);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Informe um número válido.");
        }
    }
}