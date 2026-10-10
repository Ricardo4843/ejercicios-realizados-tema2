package complejidad;

/**
 * Ejercicio 3.4: búsqueda binaria recursiva: valores de medio, array sin ordenar y complejidad.
 */
public class Ejercicio4BusquedaBinaria {

    static int llamadas;
    static boolean traza;

    public static int busqueda(int[] arr, int inicio, int fin, int x) {
        llamadas++;
        if (fin < inicio) return -1;
        int medio = inicio + (fin - inicio) / 2;
        if (traza) {
            System.out.println("  inicio=" + inicio + " fin=" + fin + " -> medio=" + medio + " (valor " + arr[medio] + ")");
        }
        if (arr[medio] == x) return medio;
        if (arr[medio] > x)
            return busqueda(arr, inicio, medio - 1, x);
        return busqueda(arr, medio + 1, fin, x);
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        traza = true;
        System.out.println("Buscando 23:");
        System.out.println("  posición " + busqueda(arr, 0, arr.length - 1, 23));

        int[] desordenado = {38, 2, 91, 23, 5, 72, 8, 56, 16, 12};
        System.out.println("Buscando 23 en un array sin ordenar (está en la posición 3):");
        System.out.println("  resultado " + busqueda(desordenado, 0, desordenado.length - 1, 23));
        traza = false;

        System.out.println("n\tllamadas (peor caso)");
        int[] tamanos = {10, 100, 1000, 1000000};
        for (int n : tamanos) {
            int[] grande = new int[n];
            for (int i = 0; i < n; i++) {
                grande[i] = 2 * i;
            }
            llamadas = 0;
            busqueda(grande, 0, n - 1, -1);
            System.out.println(n + "\t" + llamadas);
        }
        System.out.println("Complejidad: O(log n)");
    }
}
