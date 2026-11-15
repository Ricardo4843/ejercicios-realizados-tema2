package complejidad;

/**
 * Ejercicio 3.11: estimar el orden de complejidad de cuatro algoritmos en función de N.
 */
public class Ejercicio11Complejidades {

    // a) el bucle interior llega hasta n, que se divide entre 2 en cada vuelta
    public static long a(int N) {
        long sum = 0;
        for (int n = N; n > 0; n /= 2)
            for (int i = 0; i < n; i++)
                sum++;
        return sum;
    }

    // b) i se duplica y el bucle interior llega hasta i
    public static long b(int N) {
        long sum = 0;
        for (int i = 1; i < N; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
        return sum;
    }

    // c) i se duplica y el bucle interior llega siempre hasta N
    public static long c(int N) {
        long sum = 0;
        for (int i = 1; i < N; i *= 2)
            for (int j = 0; j < N; j++)
                sum++;
        return sum;
    }

    // d) para cada i, c empieza en i y se divide entre 2 hasta llegar a 0
    public static long d(int N) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int c = i;
            while (c > 0) {
                sum++; // algo_de_O(1)
                c /= 2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("a) N=16: " + a(16) + " (16+8+4+2+1)");
        System.out.println("b) N=16: " + b(16) + " (1+2+4+8)");
        System.out.println("c) N=16: " + c(16) + " (4 vueltas x 16)");
        System.out.println("d) N=8:  " + d(8) + " (0+1+2+2+3+3+3+3)");

        System.out.println("\nN\ta\tb\tc\td\t2N\tN*log2(N)");
        int[] valores = {16, 1024, 65536, 1048576};
        for (int N : valores) {
            long nlog = Math.round(N * Math.log(N) / Math.log(2));
            System.out.println(N + "\t" + a(N) + "\t" + b(N) + "\t" + c(N) + "\t" + d(N) + "\t" + 2L * N + "\t" + nlog);
        }
        System.out.println("\na) O(N): N + N/2 + N/4 + ... < 2N");
        System.out.println("b) O(N): 1 + 2 + 4 + ... < 2N");
        System.out.println("c) O(N log N): log N vueltas x N");
        System.out.println("d) O(N log N): cada i da unas log2(i) vueltas");
    }
}
