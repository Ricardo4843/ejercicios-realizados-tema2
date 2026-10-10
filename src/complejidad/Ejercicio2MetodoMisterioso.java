package complejidad;

import java.util.Arrays;

/**
 * Ejercicio 3.2: método misterioso (I): traza, qué algoritmo es y complejidad en el mejor y peor caso.
 */
public class Ejercicio2MetodoMisterioso {

    static int comparaciones;

    public static void procesar(int[] datos, boolean traza) {
        int n = datos.length;
        for (int i = 1; i < n; i++) {
            int clave = datos[i];
            int j = i - 1;
            while (j >= 0 && cuenta(datos[j] > clave)) {
                datos[j + 1] = datos[j];
                j = j - 1;
            }
            datos[j + 1] = clave;
            if (traza) {
                System.out.println("  tras i=" + i + ": " + Arrays.toString(datos));
            }
        }
    }

    /** Cuenta cada comparación datos[j] > clave. */
    private static boolean cuenta(boolean comparacion) {
        comparaciones++;
        return comparacion;
    }

    public static void main(String[] args) {
        int[] datos = {5, 2, 4, 6, 1, 3};
        System.out.println("Traza con " + Arrays.toString(datos) + ":");
        procesar(datos, true);

        int n = 1000;
        int[] ordenado = new int[n];
        int[] alReves = new int[n];
        for (int i = 0; i < n; i++) {
            ordenado[i] = i;
            alReves[i] = n - i;
        }
        comparaciones = 0;
        procesar(ordenado, false);
        System.out.println("n=" + n + " ya ordenado: " + comparaciones + " comparaciones (n-1, mejor caso O(n))");
        comparaciones = 0;
        procesar(alReves, false);
        System.out.println("n=" + n + " al revés:    " + comparaciones + " comparaciones (n(n-1)/2 = " + n * (n - 1) / 2
                + ", peor caso O(n^2))");
    }
}
