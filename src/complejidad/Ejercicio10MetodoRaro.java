package complejidad;

/**
 * Ejercicio 3.10: llamadas a metodoRaro con n=3 y complejidad en función de n.
 */
public class Ejercicio10MetodoRaro {

    static long llamadas;
    static boolean imprimir;

    public void metodoRaro(int n) {
        llamadas++;
        if (n <= 0) return;
        if (imprimir) {
            System.out.print(n + " ");
        }
        metodoRaro(n - 1);
        metodoRaro(n - 1);
    }

    public static void main(String[] args) {
        Ejercicio10MetodoRaro m = new Ejercicio10MetodoRaro();
        imprimir = true;
        System.out.print("n=3 imprime: ");
        m.metodoRaro(3);
        System.out.println();
        System.out.println("n=3: " + llamadas + " llamadas (2^(n+1) - 1)");
        imprimir = false;

        System.out.println("n\tllamadas\t2^(n+1)-1");
        int[] valores = {1, 5, 10, 20};
        for (int n : valores) {
            llamadas = 0;
            m.metodoRaro(n);
            System.out.println(n + "\t" + llamadas + "\t\t" + ((1L << (n + 1)) - 1));
        }
        System.out.println("Complejidad: O(2^n)");
    }
}
