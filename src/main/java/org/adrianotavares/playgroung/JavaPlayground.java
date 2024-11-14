package org.adrianotavares.playgroung;

import java.text.Normalizer;

/**
 * This class provides several utility methods for string manipulation.
 * 
 * <p>Methods included:
 * <ul>
 *   <li>{@link #reverteStringLoop(String)} - Reverses a string using a loop.</li>
 *   <li>{@link #reverteStringBuffer(String)} - Reverses a string using StringBuilder.</li>
 *   <li>{@link #reverteStringRecursivo(String)} - Reverses a string using recursion.</li>
 *   <li>{@link #isPalindromo(String)} - Checks if a string is a palindrome.</li>
 * </ul>
 * </p>
 * 
 * @author adrianotavares
 */
public class JavaPlayground {

    public static String reverteStringLoop(String s) {
        char[] r = new char[s.length()];
        int lastPosition = s.length() - 1;
        for (int i = 0; i <= lastPosition; i++) {
            r[lastPosition - i] = s.charAt(i);
        }
        return new String(r);
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
        // The palindrome check method normalizes the string by removing 
        // diacritical marks and non-alphanumeric characters, and converts it 
        // to lowercase before performing the check.</p>
        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int left = 0;
        int right = s.length() - 1;
    
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
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
