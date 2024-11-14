package org.adrianotavares.playgroung;

import java.text.Normalizer;

/**
 *
 * @author adrianotavares
 */
public class JavaPlayground {

    public static String reverteStringLoop(String s) {
        char[] resultado = new char[s.length()];
        int ultimaPosicao = s.length() - 1;
        for (int i = 0; i <= ultimaPosicao; i++) {
            resultado[ultimaPosicao - i] = s.charAt(i);
        }
        return new String(resultado);
    }

    public static String reverteStringBuffer(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverteStringRecursivo(String s) {
        // Caso base: se a string estiver vazia ou tiver apenas um caractere
        if (s == null || s.length() <= 1) {
            return s;
        }
        // Chamada recursiva com a substring excluindo o primeiro caractere
        // e anexando o primeiro caractere no final
        return reverteStringRecursivo(s.substring(1)) + s.charAt(0);
    }

    public static boolean isPalindromo(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int esquerda = 0;
        int direita = s.length() - 1;
    
        while (esquerda < direita) {
            if (s.charAt(esquerda) != s.charAt(direita)) {
                return false;
            }
            esquerda++;
            direita--;
        }
        return true;
    }

    public static void main(String[] args) {
       /*
        * Reverse a string
        */
       String s =  "ABCD";
       String r = reverteStringLoop(s);
       System.out.println(r);
       r = reverteStringBuffer(s);
       System.out.println(r);
       r = reverteStringRecursivo(s);
       System.out.println(r);

       /*
        * Check if a string is a palindrome
        */        
       System.out.println(isPalindromo("Ame a ema"));
    }
}
