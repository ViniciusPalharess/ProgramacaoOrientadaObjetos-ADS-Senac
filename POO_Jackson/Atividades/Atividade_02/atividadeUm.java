package atividadeDois;
import java.util.Scanner;

public class atividadeUm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite a quantidade de alunos: ");
            int quantidade = scanner.nextInt();

            double[] notas = new double[quantidade];

            double soma = 0;
            double maiorNota = 0;
            double menorNota = 10;
            int aprovados = 0;

            for (int i = 0; i < notas.length; i++) {

                System.out.print("Digite a nota do aluno " + (i + 1) + ": ");

                try {
                    notas[i] = scanner.nextDouble();

                    soma += notas[i];

                    if (i == 0 || notas[i] > maiorNota) {
                        maiorNota = notas[i];
                    }

                    if (i == 0 || notas[i] < menorNota) {
                        menorNota = notas[i];
                    }

                    if (notas[i] >= 6.0) {
                        aprovados++;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Nota inválida. Digite um número.");
                }
            }

            double media = soma / quantidade;

            System.out.println("\n--- Resultado da Turma ---");
            System.out.printf("Média da turma: %.2f%n", media);
            System.out.printf("Maior nota: %.2f%n", maiorNota);
            System.out.printf("Menor nota: %.2f%n", menorNota);
            System.out.println("Quantidade de aprovados: " + aprovados);

            System.out.println("\n--- Situação dos Alunos ---");

            for (int i = 0; i < notas.length; i++) {

                if (notas[i] >= 6.0) {
                    System.out.println("Aluno " + (i + 1) + ": Aprovado");
                } else {
                    System.out.println("Aluno " + (i + 1) + ": Reprovado");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Quantidade de alunos inválida.");
        }

    }
}
