package complejidad;

/**
 * Ejercicio 3.5: bucles anidados (II): veces que se ejecuta a++ con n=10, relación de j con n y complejidad.
 */
public class Ejercicio5BuclesLog {

    public static int metodoLog(int n) {
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                a++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("n=10: a++ se ejecuta " + metodoLog(10) + " veces (j = 1, 2, 4, 8)");
        System.out.println("n\ta\tn*log2(n)");
        int[] valores = {10, 100, 1000, 10000};
        for (int n : valores) {
            System.out.println(n + "\t" + metodoLog(n) + "\t" + Math.round(n * Math.log(n) / Math.log(2)));
        }
        System.out.println("Complejidad: O(n log n)");
    }
}
