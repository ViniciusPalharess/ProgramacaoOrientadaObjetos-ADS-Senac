
import java.util.InputMismatchException;
import java.util.Scanner;

// # Questão 2: Validação de Idade com Estrutura Condicional

// Crie um programa que solicite a idade do usuário e determine se é maior de idade (≥ 18 anos),
// menor de idade ou idoso (≥ 60 anos). Utilize estruturas if/else para implementar a lógica e trate 
// erros de entrada com try/catch.

public class Questao_02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("-- Verificação de idade -- \n\n");

        try {
            System.out.println("Informe sua idade: ");
            int idade = entrada.nextInt();

            if (idade >= 18) {
                System.out.println("Maior de idade.");
            } else if (idade >= 60) {
                System.out.println("Idoso.");
            } else if (idade > 0) {
                System.out.println("Menor de idade.");
            } else {
                System.out.println("Idade incorreta.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Informe uma idade válida");
        }
    }
}