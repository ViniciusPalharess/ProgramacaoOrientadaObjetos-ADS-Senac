package atividades;

import java.util.Scanner;

public class AtividadeUm {

    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    System.out.println("Digite o primeiro valor: ");
    Double valorUm = entrada.nextDouble();

    System.out.println("Digite o segundo valor: ");
    Double valorDois = entrada.nextDouble();

    System.out.println("Escolha uma das seguintes operações (+, -, /, *, %): ");
    String opcaoCondicao = entrada.next();
    
    Double resultado = null;

    switch (opcaoCondicao) {
        case "+":
            resultado = valorUm + valorDois;
            break;
        case "-":
            resultado = valorUm - valorDois;
            break;
        case "*":
            resultado = valorUm * valorDois;
            break;                    
       case "/":
    try {
        if (valorDois == 0) {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
        resultado = valorUm / valorDois;
    } catch (ArithmeticException e) {
        System.out.println(e.getMessage());
        return;
    }
    break;
    case "%":
    resultado = valorUm % valorDois;
    break;
        default:
            System.out.println("Operação inválida.");
            break;
    }
        System.out.println("O resultado é: " + resultado);
        entrada.close();    
    }
}
