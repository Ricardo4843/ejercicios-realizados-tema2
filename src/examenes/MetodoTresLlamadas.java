package examenes;

/**
 * Parcial 2015, pregunta 1: qué devuelve m(a) y complejidad en función de N.
 */
public class MetodoTresLlamadas {

    static long computos;
    static long llamadas;

    static void metodoConMuchoComputo(int x) {
        computos++;
    }

    public int m(int x) {
        llamadas++;
        if (x <= 0) return 0;
        metodoConMuchoComputo(x);
        x = m(x - 1);
        x = m(x - 1);
        x = m(x - 1);
        return x;
    }

    public static void main(String[] args) {
        MetodoTresLlamadas o = new MetodoTresLlamadas();
        System.out.println("N\tdevuelve\tlinea 3\tllamadas (3N+1)");
        int[] valores = {0, 1, 3, 10, 1000};
        for (int n : valores) {
            computos = 0;
            llamadas = 0;
            int r = o.m(n);
            System.out.println(n + "\t" + r + "\t\t" + computos + "\t" + llamadas);
        }
        System.out.println("Siempre devuelve 0; la linea 3 se ejecuta N veces -> O(N)");
    }
}
