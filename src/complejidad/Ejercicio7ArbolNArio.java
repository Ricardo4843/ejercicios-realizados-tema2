package complejidad;

/**
 * Ejercicio 3.7: complejidad de recorrer un árbol N-ario entero para contar sus nodos.
 */
public class Ejercicio7ArbolNArio {

    static int visitas;

    public static int contarNodos(NodoNArio nodo) {
        if (nodo == null) {
            return 0;
        }
        visitas++;
        int total = 1;
        for (NodoNArio hijo : nodo.getHijos()) {
            total += contarNodos(hijo);
        }
        return total;
    }

    /** Árbol de prueba: cada nodo tiene "ramas" hijos hasta la profundidad indicada. */
    private static NodoNArio crearArbol(int profundidad, int ramas) {
        NodoNArio nodo = new NodoNArio();
        if (profundidad > 0) {
            for (int i = 0; i < ramas; i++) {
                nodo.getHijos().add(crearArbol(profundidad - 1, ramas));
            }
        }
        return nodo;
    }

    public static void main(String[] args) {
        System.out.println("nodos\tvisitas");
        int[][] arboles = {{2, 3}, {4, 3}, {6, 3}, {3, 10}};
        for (int[] a : arboles) {
            visitas = 0;
            int nodos = contarNodos(crearArbol(a[0], a[1]));
            System.out.println(nodos + "\t" + visitas);
        }
        System.out.println("Cada nodo se visita una vez: O(N)");
    }
}
