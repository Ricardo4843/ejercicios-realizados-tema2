package complejidad;

import java.util.Arrays;

/**
 * Ejercicio 3.6: bubble sort optimizado: comparaciones con el array ordenado, para qué sirve intercambiado y complejidad.
 */
public class Ejercicio6BubbleSort {

    static int comparaciones;

    static void ordenar(int[] arr) {
        int n = arr.length;
        boolean intercambiado;
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    // swap temp
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambiado = true;
                }
            }
            if (intercambiado == false) break;
        }
    }

    public static void main(String[] args) {
        int[] ordenado = {1, 2, 3, 4, 5};
        comparaciones = 0;
        ordenar(ordenado);
        System.out.println(Arrays.toString(ordenado) + ": " + comparaciones + " comparaciones (mejor caso, n-1)");

        int[] alReves = {5, 4, 3, 2, 1};
        comparaciones = 0;
        ordenar(alReves);
        System.out.println("{5, 4, 3, 2, 1}: " + comparaciones + " comparaciones (peor caso, n(n-1)/2)");
        System.out.println("Mejor caso O(n), peor caso O(n^2)");
    }
}
