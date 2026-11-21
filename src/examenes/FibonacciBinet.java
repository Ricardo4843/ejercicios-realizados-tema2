package examenes;

/**
 * Parcial 2016, pregunta 1: complejidad de Fibonacci con bucle frente a la fórmula de Binet.
 */
public class FibonacciBinet {

    static long vueltas;
    static long llamadasPotencia;

    static int f(int i) {
        int a = 1; int b = 1; int c = 1;
        while (i-- > 2) {
            vueltas++;
            c = a + b; a = b; b = c;
        }
        return c;
    }

    static double potencia(double base, int expo) {
        llamadasPotencia++;
        if (expo == 0) return 1;
        if (expo % 2 == 0) return potencia(base * base, expo / 2);
        else return potencia(base * base, expo / 2) * base;
    }

    static double binet(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        return (potencia(phi, n) - potencia(1 - phi, n)) / Math.sqrt(5);
    }

    public static void main(String[] args) {
        System.out.println("f(10) = " + f(10) + ", Binet(10) = " + Math.round(binet(10)));

        System.out.println("\nn\tvueltas bucle (coste M)\tllamadas potencia (coste 20M)\tbucle\tBinet");
        int[] valores = {16, 64, 256, 512, 1024};
        for (int n : valores) {
            vueltas = 0;
            llamadasPotencia = 0;
            f(n);
            binet(n);
            long costeBucle = vueltas;
            long costeBinet = 20 * llamadasPotencia;
            System.out.println(n + "\t" + vueltas + "\t\t\t" + llamadasPotencia + "\t\t\t\t" + costeBucle + "M\t" + costeBinet + "M");
        }
        System.out.println("\nBucle O(n), potencia O(log n), Binet 2 log n -> O(log n)");
        System.out.println("n bajo -> bucle; n muy alto -> Binet (n frente a 40 log n)");
    }
}
