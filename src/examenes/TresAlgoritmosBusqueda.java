package examenes;

import java.util.Arrays;

/**
 * Parcial 2022, pregunta 1: elegir entre tres algoritmos de búsqueda de un rango según N y M.
 */
public class TresAlgoritmosBusqueda {

    static long ops;

    static void ordenaOptimo(int[] a) {
        Arrays.sort(a);
        ops += Math.round(a.length * Math.log(a.length) / Math.log(2));
    }

    static int busquedaBinaria(int[] a, int x) {
        int ini = 0, fin = a.length - 1;
        while (ini <= fin) {
            ops++;
            int m = (ini + fin) / 2;
            if (a[m] == x) return m;
            if (a[m] < x) ini = m + 1; else fin = m - 1;
        }
        return -1;
    }

    // primera posición con valor >= x
    static int limiteInferior(int[] a, int x) {
        int ini = 0, fin = a.length;
        while (ini < fin) {
            ops++;
            int m = (ini + fin) / 2;
            if (a[m] < x) ini = m + 1; else fin = m;
        }
        return ini;
    }

    public static int buscar1(int[] buscados, int inicio, int fin) {
        int encontrados = 0;
        ordenaOptimo(buscados);
        for (int unNumero = inicio; unNumero <= fin; unNumero++)
            if (busquedaBinaria(buscados, unNumero) != -1)
                encontrados++;
        return encontrados;
    }

    public static int buscar2(int[] buscados, int inicio, int fin) {
        int encontrados = 0;
        for (int unNumero = inicio; unNumero <= fin; unNumero++)
            for (int i = 0; i < buscados.length; i++) {
                ops++;
                if (buscados[i] == unNumero) {
                    encontrados++;
                    break;
                }
            }
        return encontrados;
    }

    // misma idea que buscar3: ordenar y dos búsquedas binarias de los extremos del rango
    public static int buscar3(int[] buscados, int inicio, int fin) {
        ordenaOptimo(buscados);
        return limiteInferior(buscados, fin + 1) - limiteInferior(buscados, inicio);
    }

    static int[] arrayDesordenado(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = 2 * i;
        for (int i = n - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int t = a[i]; a[i] = a[j]; a[j] = t;
        }
        return a;
    }

    static void caso(String nombre, int N, int M) {
        int[] base = arrayDesordenado(N);
        long[] coste = new long[3];
        int[] res = new int[3];
        for (int k = 0; k < 3; k++) {
            int[] a = base.clone();
            ops = 0;
            if (k == 0) res[k] = buscar1(a, 0, M - 1);
            if (k == 1) res[k] = buscar2(a, 0, M - 1);
            if (k == 2) res[k] = buscar3(a, 0, M - 1);
            coste[k] = ops;
        }
        System.out.println(nombre + " (N=" + N + ", M=" + M + ")  resultado=" + res[0] + "/" + res[1] + "/" + res[2]
                + "  buscar1=" + coste[0] + "  buscar2=" + coste[1] + "  buscar3=" + coste[2]);
    }

    public static void main(String[] args) {
        int[] ejemplo = {1, 9, 4, 5, -3, 8, 7};
        System.out.println("Ejemplo [5, 7]: " + buscar2(ejemplo.clone(), 5, 7) + " (esperado 2)");
        caso("Caso 1: M = 2      -> buscar2", 100000, 2);
        caso("Caso 2: M = N      -> buscar1 o buscar3", 20000, 20000);
        caso("Caso 3: M >> N     -> buscar3", 1000, 1000000);
        System.out.println("buscar1 = N log N + M log N, buscar2 = M N/2, buscar3 = N log N + 2 log N");
    }
}
