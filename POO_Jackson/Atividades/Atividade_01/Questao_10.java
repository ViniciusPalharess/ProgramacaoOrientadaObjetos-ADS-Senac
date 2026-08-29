// # Questão 10: Jogo de Adivinhação com Estruturas de Controle

// Desenvolva um jogo em que o programa gera um número aleatório entre 1 e 100, e o usuário tenta
// adivinhar. Utilize while para repetir até acertar, if/else para comparar o palpite com o número
// secreto, Scanner para entrada e try/catch para validação. Exiba dicas ("maior" ou "menor") a
// cada tentativa.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Questao_10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Jogo de Adivinhação -- \n\n");
        System.out.println("Tente advinhar o número de 1 - 100.");

        int numeroSecreto = (int) (Math.random() * 100) + 1;
        int palpite = 0;

        try {
            while (palpite != numeroSecreto) {
                System.out.println("Informe seu número");
                palpite = entrada.nextInt();

                if (palpite < numeroSecreto) {
                    System.out.println("O número secreto é maior.");
                } else if (palpite > numeroSecreto) {
                    System.out.println("O número secreto é menor");
                } else {
                    System.out.println("Parbéns! Vôce acerto.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Informe um número.");
        }
    }
}