package complejidad;

/**
 * Ejercicio 3.1: valor final de contador en función de N y complejidad.
 */
public class Ejercicio1Contador {

    public static int contar(int N) {
        int contador = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        System.out.println("N\tcontador\tN(N-1)/2");
        int[] valores = {1, 2, 5, 10, 100, 1000};
        for (int N : valores) {
            System.out.println(N + "\t" + contar(N) + "\t\t" + N * (N - 1) / 2);
        }
        System.out.println("Complejidad: O(N^2)");
    }
}
