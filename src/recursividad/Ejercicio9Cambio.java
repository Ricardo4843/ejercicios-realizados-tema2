package recursividad;

import java.util.Arrays;

/**
 * Ejercicio 2.9: de cuántas formas se puede sumar el objetivo con las monedas de 1, 2 y 5 disponibles.
 */
public class Ejercicio9Cambio {

    public static int contarFormasCambio(int objetivo, int[] monedas) {
        if (objetivo == 0) {
            return 1;
        } else if (objetivo < 0) {
            return 0;
        } else if (monedas[0] == 0 && monedas[1] == 0 && monedas[2] == 0) {
            return 0;
        }
        int tipo = 0;
        int[] valores = {1, 2, 5};
        for (int i = 0; i < monedas.length; i++) {
            if (monedas[i] != 0) {
                tipo = i;
            }
        }
        int[] usando = {monedas[0], monedas[1], monedas[2]};
        usando[tipo] -= 1;
        int formasUsando = contarFormasCambio(objetivo - valores[tipo], usando);

        int[] cerrando = {monedas[0], monedas[1], monedas[2]};
        cerrando[tipo] = 0;
        int formasCerrando = contarFormasCambio(objetivo, cerrando);

        return formasUsando + formasCerrando;
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
