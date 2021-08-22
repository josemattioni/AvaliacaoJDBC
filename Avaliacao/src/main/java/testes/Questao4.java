package testes;

import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite uma mensagem");
        String msg = ler.nextLine();

        String[] analisar = msg.split("");
        int feliz = 0;
        int triste = 0;
        for (int i = 0; i <analisar.length ; i++) {
            if (analisar[i].contains(":") && analisar[i+1].contains("-") && analisar[i+2].contains(")")) {
                feliz++;
            }
            if (analisar[i].contains(":") && analisar[i+1].contains("-") && analisar[i+2].contains("(")) {
                triste++;
            }
        }
        if (feliz > triste) {
            System.out.println("Divertido");
        }
        else if (triste > feliz) {
            System.out.println("Chateado");
        }else{
            System.out.println("neutro");
        }
    }

}
