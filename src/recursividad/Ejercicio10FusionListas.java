package recursividad;

/**
 * Ejercicio 2.10: fusionar dos listas enlazadas ordenadas en una sola lista ordenada.
 */
public class Ejercicio10FusionListas {

    public static NodoLista fusionarListas(NodoLista l1, NodoLista l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.dato <= l2.dato) {
            l1.siguiente = fusionarListas(l1.siguiente, l2);
            return l1;
        }
        l2.siguiente = fusionarListas(l1, l2.siguiente);
        return l2;
    }

    public static void main(String[] args) {
        NodoLista a = NodoLista.crear(1, 4, 7, 10);
        NodoLista b = NodoLista.crear(2, 3, 7, 12, 15);
        System.out.println("Fusión: " + NodoLista.aTexto(fusionarListas(a, b)));
        System.out.println("Con una vacía: " + NodoLista.aTexto(fusionarListas(null, NodoLista.crear(5, 6))));
        System.out.println("Las dos vacías: " + NodoLista.aTexto(fusionarListas(null, null)));
    }
}
