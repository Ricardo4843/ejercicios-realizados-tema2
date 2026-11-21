package examenes;

/**
 * Parcial 2019, pregunta 1: n-ésimo número de Catalan con factoriales y de forma recursiva.
 */
public class Catalan {

    public static long fact(long n) {
        long f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static long catalan1(long n) {
        if (n == 1)
            return 1;
        long f = fact(2 * n) / (fact(n + 1) * fact(n));
        return f;
    }

    public static long catalan2(long n) {
        if (n == 0)
            return 1;
        long f = 2 * (2 * n - 1) * catalan2(n - 1) / (n + 1);
        return f;
    }

    public static void main(String[] args) {
        for (int n = 0; n <= 12; n++) {
            System.out.println("n=" + n + "  catalan1=" + catalan1(n) + "  catalan2=" + catalan2(n));
        }
    }
}
