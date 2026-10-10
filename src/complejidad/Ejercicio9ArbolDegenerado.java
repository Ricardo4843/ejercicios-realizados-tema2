package complejidad;

/**
 * Ejercicio 3.9: complejidad de buscar en un árbol binario degenerado, en el peor y en el mejor caso.
 */
public class Ejercicio9ArbolDegenerado {

    static int pasos;

    public static boolean buscar(Node nodo, int x) {
        if (nodo == null) {
            return false;
        }
        pasos++;
        if (nodo.value == x) {
            return true;
        }
        if (x < nodo.value) {
            return buscar(nodo.left, x);
        }
        return buscar(nodo.right, x);
    }

    /** Árbol degenerado: 1 -> 2 -> ... -> n, todos los hijos a la derecha. */
    private static Node crearDegenerado(int n) {
        Node raiz = null;
        for (int v = n; v >= 1; v--) {
            raiz = new Node(v, null, raiz);
        }
        return raiz;
    }

    public static void main(String[] args) {
        System.out.println("n\tpeor (buscar n)\tmejor (buscar la raíz)");
        int[] tamanos = {10, 100, 1000};
        for (int n : tamanos) {
            Node arbol = crearDegenerado(n);
            pasos = 0;
            buscar(arbol, n);
            int peor = pasos;
            pasos = 0;
            buscar(arbol, 1);
            System.out.println(n + "\t" + peor + "\t\t" + pasos);
        }
        System.out.println("Peor caso O(n), mejor caso O(1)");
    }
}
