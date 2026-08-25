package atividadeDois;
import java.util.Scanner;

public class atividadeTres {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numeros = new int[15];
        int quantidadePares = 0;
        int quantidadeImpares = 0;

        // Preenchendo o array
        for (int i = 0; i < numeros.length; i++) {
            try {
                System.out.print("Digite o " + (i + 1) + "º número: ");
                numeros[i] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.nextLine();
                i--;
            }
        }

        System.out.println("\nNúmeros pares:");

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                System.out.println(numeros[i]);
                quantidadePares++;
            }
        }

        System.out.println("\nNúmeros ímpares:");

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 != 0) {
                System.out.println(numeros[i]);
                quantidadeImpares++;
            }
        }

        System.out.println("\nQuantidade de pares: " + quantidadePares);
        System.out.println("Quantidade de ímpares: " + quantidadeImpares);

        scanner.close();
    }
}