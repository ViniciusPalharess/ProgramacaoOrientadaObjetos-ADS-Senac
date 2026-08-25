package atividadeDois;
import java.util.Scanner;

public class atividadeDois {
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