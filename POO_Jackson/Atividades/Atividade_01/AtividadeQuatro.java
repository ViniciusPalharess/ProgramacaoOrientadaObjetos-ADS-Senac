package atividades;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AtividadeQuatro {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {

            System.out.println("Informe um número (1 a 10): ");
            Integer numeroUm = entrada.nextInt();

            for (int i = 0; i <= 10; i++) {
            int valor = numeroUm * i;
            System.out.println(numeroUm + "x" + i + "=" + valor);
            }

        } catch (InputMismatchException e) {
            System.out.println("Informe um valor válido");
        }

        entrada.close();  
    }
}