package recursividad;

/**
 * Ejercicio 2.8: invertir una lista enlazada simple de forma recursiva.
 */
public class Ejercicio8InvertirLista {

    public static NodoLista invertirRecursivo(NodoLista actual) {
        // Caso base: lista vacía o único elemento
        if (actual == null || actual.siguiente == null) {
            return actual;
        }
        // Paso recursivo:
        NodoLista nuevaCabeza = invertirRecursivo(actual.siguiente);
        actual.siguiente.siguiente = actual;
        actual.siguiente = null;
        return nuevaCabeza;
    }

    public static void main(String[] args) {
        NodoLista lista = NodoLista.crear(1, 2, 3, 4, 5);
        System.out.println("Original:  " + NodoLista.aTexto(lista));
        System.out.println("Invertida: " + NodoLista.aTexto(invertirRecursivo(lista)));
        System.out.println("Un nodo:   " + NodoLista.aTexto(invertirRecursivo(NodoLista.crear(7))));
        System.out.println("Vacía:     " + NodoLista.aTexto(invertirRecursivo(null)));
    }
}
