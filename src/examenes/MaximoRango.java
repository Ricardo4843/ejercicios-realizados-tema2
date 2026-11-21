package examenes;

/**
 * Ordinario 2025-26, ejercicio 2: máximo de un rango del array dividiendo en dos mitades.
 */
public class MaximoRango {

    public static float findMaxRecursive(float[] data, int inicio, int fin) {
        if (inicio - fin == 0)
            return data[inicio];
        int m = inicio + (fin - inicio) / 2;
        float izq = findMaxRecursive(data, inicio, m);
        float der = findMaxRecursive(data, m + 1, fin);
        if (izq < der) {
            return der;
        } else
            return izq;
    }

    public static void main(String[] args) {
        float[] data = {3.5f, 7.2f, 1.0f, 9.8f, 4.4f, 6.1f};
        System.out.println("Maximo [0, 5]: " + findMaxRecursive(data, 0, 5));
        System.out.println("Maximo [0, 2]: " + findMaxRecursive(data, 0, 2));
        System.out.println("Maximo [4, 5]: " + findMaxRecursive(data, 4, 5));
    }
}
