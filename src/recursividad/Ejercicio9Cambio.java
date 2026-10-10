package recursividad;

import java.util.Arrays;

/**
 * Ejercicio 2.9: de cuántas formas se puede sumar el objetivo con las monedas de 1, 2 y 5 disponibles.
 */
public class Ejercicio9Cambio {

    private static final int[] VALORES = {1, 2, 5};

    public static int contarFormasCambio(int objetivo, int[] monedas) {
        if (objetivo == 0) {
            return 1;
        }
        if (objetivo < 0 || monedas == null || monedas.length < VALORES.length) {
            return 0;
        }
        // Tipo de moneda más grande que todavía queda
        int tipo = -1;
        for (int i = 0; i < VALORES.length; i++) {
            if (monedas[i] > 0) {
                tipo = i;
            }
        }
        if (tipo == -1) {
            return 0;
        }
        // Formas usando una moneda de ese tipo
        monedas[tipo]--;
        int usando = contarFormasCambio(objetivo - VALORES[tipo], monedas);
        monedas[tipo]++;
        // Formas sin usar ninguna más de ese tipo
        int[] sinEseTipo = monedas.clone();
        sinEseTipo[tipo] = 0;
        int sinUsar = contarFormasCambio(objetivo, sinEseTipo);
        return usando + sinUsar;
    }

    public static void main(String[] args) {
        int[] muchas = {10, 10, 10};
        System.out.println("objetivo 3:  " + contarFormasCambio(3, muchas) + " (esperado 2: 1+1+1, 1+2)");
        System.out.println("objetivo 5:  " + contarFormasCambio(5, muchas) + " (esperado 4)");
        System.out.println("objetivo 10: " + contarFormasCambio(10, muchas) + " (esperado 10)");
        System.out.println("objetivo 5 con {1, 1, 1}: " + contarFormasCambio(5, new int[] {1, 1, 1}) + " (esperado 1: solo 5)");
        System.out.println("objetivo 4 con {0, 1, 0}: " + contarFormasCambio(4, new int[] {0, 1, 0}) + " (esperado 0)");
        System.out.println("El array no cambia: " + Arrays.toString(muchas));
    }
}
