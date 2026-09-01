import java.util.Scanner;

// # Questão 2: Busca de Valores em um Array

// Crie um programa que leia 10 números inteiros e armazene-os em um array. Em seguida, solicite outro número ao usuário e informe se ele está presente no array. 
// Caso esteja, exiba todas as posições em que foi encontrado; caso contrário, informe que o número não foi localizado.
// O programa deve utilizar um laço for para preencher e percorrer o array. A entrada dos números deve ser protegida por try/catch,
// e a comparação deve ser realizada com operadores relacionais e if/else.

public class Questao_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[10];

        for (int i = 0; i < numeros.length; i++) {
            try {
                System.out.print("Digite o número da posição " + i + ": ");
                numeros[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
                scanner.nextLine();
                i--;
            }
        }

        System.out.print("Digite o número que deseja procurar: ");
        int numeroProcurado = scanner.nextInt();

        boolean encontrado = false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroProcurado) {
                System.out.println("Número encontrado na posição: " + i);
                encontrado = true;
            }
        }

        if (encontrado) {
            System.out.println("O número foi localizado.");
        } else {
            System.out.println("O número não foi localizado.");
        }

        scanner.close();
    }
}