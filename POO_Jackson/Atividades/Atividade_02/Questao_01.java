import java.util.Scanner;

// # Questão 1: Cadastro e Análise de Notas com Array

// Desenvolva um programa que solicite ao usuário a quantidade de alunos de uma turma e armazene as notas deles em um array de double. 
// O programa deve calcular e exibir a média da turma, a maior nota, a menor nota e a quantidade de alunos aprovados, considerando média mínima igual a 6,0.
// Utilize Scanner para a entrada, try/catch para tratar valores inválidos, conversão de tipos quando necessário e um laço for para percorrer o array. 
// Use if/else para classificar os alunos como aprovados ou reprovados.

public class Questao_01 {

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
