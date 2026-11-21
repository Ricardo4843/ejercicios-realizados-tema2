package examenes;

/**
 * Parcial 2014, pregunta 1.1: complejidad de dos bucles con una ordenación n log n dentro.
 */
public class BuclesConOrdenacion {

    static long ops;

    static int calculoAleatorio(int i) {
        ops++;
        return (int) (Math.random() * 100) + i;
    }

    static void ordenaOptimo(int[] a) {
        java.util.Arrays.sort(a);
        ops += Math.round(a.length * Math.log(a.length) / Math.log(2));
    }

    static long fragmento(int n) {
        int[] a = new int[n];
        ops = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[j] = calculoAleatorio(i);
            ordenaOptimo(a);
        }
        return ops;
    }

    public static void main(String[] args) {
        System.out.println("n\toperaciones\tn^2 log n");
        int[] valores = {16, 64, 256, 1024};
        for (int n : valores) {
            long n2logn = Math.round((double) n * n * Math.log(n) / Math.log(2));
            System.out.println(n + "\t" + fragmento(n) + "\t\t" + n2logn);
        }
        System.out.println("O(n) * (O(n) + O(n log n)) = O(n^2 log n)");
    }
}
