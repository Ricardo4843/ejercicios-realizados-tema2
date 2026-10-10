package complejidad;

/**
 * Ejercicio 3.3: bucles anidados (I): valor con n=5, número de contador++ en función de n y complejidad.
 */
public class Ejercicio3BuclesAnidados {

    public static long calcular(int n) {
        long contador = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        System.out.println("n=5: contador = " + calcular(5) + " (5+4+3+2+1)");
        System.out.println("n\tcontador\tn(n+1)/2");
        int[] valores = {1, 5, 10, 100, 1000};
        for (int n : valores) {
            System.out.println(n + "\t" + calcular(n) + "\t\t" + (long) n * (n + 1) / 2);
        }
        System.out.println("Complejidad: O(n^2)");
    }
}
