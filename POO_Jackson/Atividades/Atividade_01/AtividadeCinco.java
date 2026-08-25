package atividades;
import java.util.Scanner;

public class AtividadeCinco {
    public static void main(String args[]) {
    
    Scanner entrada = new Scanner(System.in);
    
    try{
    System.out.println("Digite a sua idade: ");
    Integer idade = entrada.nextInt();

    if (idade < 18) {
        System.out.println("Você é menor de idade.");
    } else if (idade >= 60) {
        System.out.println("Você é idoso.");
    } else {
        System.out.println("Você é adulto.");
    }
    } catch (Exception e) {
        System.out.println("Idade inválida. Por favor, digite um número inteiro.");
    } finally {
        entrada.close();
    }
}
} 
