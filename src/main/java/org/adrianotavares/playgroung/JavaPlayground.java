package org.adrianotavares.playgroung;

import java.text.Normalizer;
import java.util.Arrays;

/**
 * This class provides several utility methods for string manipulation.
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

    /**
     * Bubble sort algorithm.
     */
    public static void bubbleSort(int[] array) {
        boolean swap = true;
        int n = array.length - 1;
        while (swap) {
            swap = false; // Start with swap as false
            // Iterate through the array
            for (int i = 0; i < n; i++) {
                // Compare the current element with the next element
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    swap = true; // Change swap to true, if elements are swapped
                }
            }
            n--; // Reduce the number of elements to sort
        }
    }

    /**
     * Bubble sort swap method to swap two elements in an array.
     */
    private static void swap(int[] elementos, int i, int j) {
        int temp = elementos[i]; // Save the current element
        elementos[i] = elementos[j]; // Change the current element
        elementos[j] = temp; // Complete the swap updating the other element
    }

    /**
     * Merge sort algorithm. The principal method for merge sort.
     */
    public static void mergeSort(int[] array) {
        // Um array temporário é usado para auxiliar na fusão dos subarrays
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    /**
     * Auxliliar method for merge sort, uses the divide and conquer approach.
     */
    private static void mergeSort(int[] array, int[] temp, int inicioEsquerda, int fimDireita) {
        // Condição de base: se o subarray tem um único elemento, não é necessário
        // ordenar
        if (inicioEsquerda >= fimDireita) {
            return;
        }

        // Encontra o ponto médio para dividir o array em subarrays
        int meio = (inicioEsquerda + fimDireita) / 2;
        // Ordena recursivamente a metade esquerda do array
        mergeSort(array, temp, inicioEsquerda, meio);
        // Ordena recursivamente a metade direita do array
        mergeSort(array, temp, meio + 1, fimDireita);
        // Funde as duas metades ordenadas
        merge(array, temp, inicioEsquerda, fimDireita);
    }

    /**
     * Auxiliar method for merge sort, merges two sorted halves of an array into a
     * single sorted subarray.
     */
    private static void merge(int[] array, int[] temp, int inicioEsquerda, int fimDireita) {
        // Calcula o fim do subarray esquerdo e o início do subarray direito
        int fimEsquerda = (inicioEsquerda + fimDireita) / 2;
        int inicioDireita = fimEsquerda + 1;
        // Inicializa os ponteiros para acompanhar a posição atual em cada subarray e no
        // array temporário
        int esquerdaAtual = inicioEsquerda;
        int direitaAtual = inicioDireita;
        int tempIndice = inicioEsquerda;

        // Enquanto houver elementos em ambos os subarrays, compara e ordena no array
        // temporário
        while (esquerdaAtual <= fimEsquerda && direitaAtual <= fimDireita) {
            if (array[esquerdaAtual] < array[direitaAtual]) {
                temp[tempIndice++] = array[esquerdaAtual++];
            } else {
                temp[tempIndice++] = array[direitaAtual++];
            }
        }

        // Copia os elementos restantes do subarray esquerdo para o array temporário
        System.arraycopy(array, esquerdaAtual, temp, tempIndice, fimEsquerda - esquerdaAtual + 1);
        // Copia os elementos restantes do subarray direito para o array temporário
        System.arraycopy(array, direitaAtual, temp, tempIndice, fimDireita - direitaAtual + 1);
        // Copia os elementos do array temporário de volta para o array original
        System.arraycopy(temp, inicioEsquerda, array, inicioEsquerda, fimDireita - inicioEsquerda + 1);
    }

    /**
     * Quick sort algorithm.
     */
    public static void quicksort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    // Método sobrecarregado do Quick Sort para trabalhar com sub-arrays
    private static void quicksort(int[] numeros, int esquerda, int direita) {
        // Base da recursão: se há apenas um elemento ou nenhum, não é necessário
        // ordenar
        if (esquerda < direita) {
            // Particionar o array e obter a posição do pivô
            int partition = particionar(numeros, esquerda, direita);
            // Ordenar recursivamente a parte esquerda do pivô
            quicksort(numeros, esquerda, partition - 1);
            // Ordenar recursivamente a parte direita do pivô
            quicksort(numeros, partition + 1, direita);
        }
    }

    // Método para particionar o array e rearranjar os elementos em relação ao pivô
    private static int particionar(int[] numeros, int esquerda, int direita) {
        // Inicializa o pivô Index no começo do sub-array
        int pIndex = esquerda;
        // O pivô é escolhido como o elemento mais à direita do sub-array
        int pivo = numeros[direita];
        // Iterar sobre os elementos do sub-array
        for (int i = esquerda; i < direita; i++) {
            // Se o elemento atual é menor que o pivô, ele deve ir para a esquerda do pivô
            // Index
            if (numeros[i] < pivo) {
                // Trocar o elemento no pivô Index com o elemento atual
                int temp = numeros[pIndex];
                numeros[pIndex] = numeros[i];
                numeros[i] = temp;
                // Mover o pivô Index uma posição para a direita
                pIndex++;
            }
        }

        // Colocar o pivô na posição correta no meio do sub-array
        int temp = numeros[direita];
        numeros[direita] = numeros[pIndex];
        numeros[pIndex] = temp;
        // Retornar a posição do pivô Index, agora que o pivô está no lugar certo
        return pIndex;
    }

    /**
     * Método auxiliar para criar um array de inteiros com valores aleatórios.
     */
    private static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public static void main(String[] args) {
        /*
         * Reverse a string
         */
        String s = "ABCD";
        System.out.println("reverteStringLoop:" + reverteStringLoop(s));
        System.out.println("reverteStringBuffer:" + reverteStringBuffer(s));
        System.out.println("reverteStringRecursive:" + reverteStringRecursive(s));

        /*
         * Check if a string is a palindrome
         */
        System.out.println("isPalindrome:" + isPalindrome("Ame a ema"));

        /*
         * Check if a string is an anagram
         */
        System.out.println("isAnagram:" + isAnagram("rumo", "muro"));
        System.out.println("isAnagram2:" + isAnagram2("roma", "amor"));

        /**
         * Sorting algorithms
         */
        int size = 100000; // Comparing the sorting algorithms with an array of hundred thousand elements
        int[] array = createArray(size);
        System.out.println("Array Size: " + size);

        /*
         * Bubble sort Complexity: O(n^2)
         */
        Timer timer = new Timer();
        bubbleSort(array);
        System.out.println("Time to bubble sort: " + timer);

        /*
         * Merge sort Complexity: O(n log n)
         */
        array = createArray(size);
        timer = new Timer();
        mergeSort(array);
        System.out.println("Time to merge sort: " + timer);

        /*
         * Quick sort Complexity: O(n log n) average, O(n^2) worst case
         */
        array = createArray(size);
        timer = new Timer();
        quicksort(array);
        System.out.println("Time to quick sort: " + timer);

    }
}