package recursividad;

/**
 * Ejercicio 2.11: asalto con más tocados (máximo de un array, recursivo).
 */
public class Ejercicio11Maximo {

    static int maximo(int[] t, int i) {
        if (i == t.length - 1)
            return t[i];
        int valor = maximo(t, i + 1);
        int valorMax = valor;
        if (t[i] > valor)
            valorMax = t[i];
        return valorMax;
    }

    public static void main(String[] args) {
        int[] tocados = {3, 5, 2, 5, 4};
        System.out.println("Máximo: " + maximo(tocados, 0));
    }
}
