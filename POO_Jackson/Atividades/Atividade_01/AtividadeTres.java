package atividades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AtividadeTres{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Integer soma = 0;
        Integer numero;
        
        try {
            
        do { 
            System.out.println("( 0 ) - Para sair");

            System.out.println("Informe um valor para somar: ");
            
            numero = entrada.nextInt();

            soma += numero;

            System.out.println("O valor dos seus numeros somados é: " + soma);

        } while (soma != 0);
        
        } catch (InputMismatchException e) {
            System.out.println("Valor informado inválido");
        }
        entrada.close();  
    }

}