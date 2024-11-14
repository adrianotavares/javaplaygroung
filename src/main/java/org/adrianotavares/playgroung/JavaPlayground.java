package org.adrianotavares.playgroung;

import java.text.Normalizer;
import java.util.Arrays;

/**
 * This class provides several utility methods for string manipulation.
 *
 * <p>
 * Methods included:
 * <ul>
 * <li>{@link #reverteStringLoop(String)} - Reverses a string using a loop.</li>
 * <li>{@link #reverteStringBuffer(String)} - Reverses a string using StringBuilder.</li>
 * <li>{@link #reverteStringRecursive(String)} - Reverses a string using recursion.</li>
 * <li>{@link #isPalindrome(String)} - Checks if a string is a palindrome.</li>
 * <li>{@link #isAnagram(String, String)} - Checks if two strings are anagrams using sorting.</li>
 * <li>{@link #isAnagram2(String, String)} - Checks if two strings are anagrams using character counting.</li>
 * </ul>
 * </p>
 *
 * @author adrianotavares
 */
public class JavaPlayground {

    /**
     * Reverses a string using a loop.
     */
    public static String reverteStringLoop(String s) {
        char[] r = new char[s.length()];
        int lastPosition = s.length() - 1;
        for (int i = 0; i <= lastPosition; i++) {
            r[lastPosition - i] = s.charAt(i);
        }
        return new String(r);
    }

    /**
     * Reverses a string using StringBuilder.
     */
    public static String reverteStringBuffer(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Reverses a string using recursion.
     */
    public static String reverteStringRecursive(String s) {
        // Base case: if the string is null or has only one character
        if (s == null || s.length() <= 1) {
            return s;
        }
        // calling the method recursively, removing the first character
        // and concatenating it to the end of the string
        return reverteStringRecursive(s.substring(1)) + s.charAt(0);
    }

    /**
     * Checks if a string is a palindrome using a loop.
     */
    public static boolean isPalindrome(String s) {
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

    /**
     * Checks if two strings are anagrams using sorting.
     */
    public static boolean isAnagram(String str1, String str2) {
        // Verify if the strings have the same length
        if (str1.length() != str2.length()) {
            return false; // if different, they are not anagrams
        }

        // Convert the strings to arrays of characters
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        // Order the arrays
        Arrays.sort(a); // Order the first array
        Arrays.sort(b); // Order the second array

        // Compare the arrays
        return Arrays.equals(a, b); // if the arrays are equal, they are anagrams
    }

    /**
     * Checks if two strings are anagrams using character counting.
     */
    public static boolean isAnagram2(String str1, String str2) {
        // Verify if the strings have the same length
        // if different, they are not anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Crate an array to count the characters
        // The array has 256 positions, one for each ASCII character
        int[] counter = new int[256];

        // Loop through the strings
        for (int i = 0; i < str1.length(); i++) {
            // Increment the counter for the current character of str1
            counter[str1.charAt(i)]++;
            // Decrease the counter for the current character of str2
            counter[str2.charAt(i)]--;
        }

        // Verify if the counters are zero
        // If any counter is different from zero, the strings are not anagrams
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        // If all counters are zero, the strings are anagrams
        return true;
    }

    public static void main(String[] args) {
        /*
        * Reverse a string
         */
        String s = "ABCD";
        System.out.println("reverteStringLoop:"+reverteStringLoop(s));
        System.out.println("reverteStringBuffer:"+reverteStringBuffer(s));
        System.out.println("reverteStringRecursive:"+reverteStringRecursive(s));

        /*
        * Check if a string is a palindrome
         */
        System.out.println("isPalindrome:" + isPalindrome("Ame a ema"));

        /*
        * Check if a string is an anagram
         */
        System.out.println("isAnagram:" + isAnagram("rumo", "muro"));
        System.out.println("isAnagram2:" + isAnagram2("roma", "amor"));
    }
}
