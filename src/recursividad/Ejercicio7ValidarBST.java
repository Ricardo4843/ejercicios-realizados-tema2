package recursividad;

/**
 * Ejercicio 2.7: comprobar si un árbol binario es un BST, acotando cada nodo con min y max.
 */
public class Ejercicio7ValidarBST {

    public static boolean esBST(Nodo nodo) {
        return esBSTAux(nodo, null, null);
    }

    private static boolean esBSTAux(Nodo nodo, Nodo min, Nodo max) {
        if (nodo == null) {
            return true;
        }
        if (min != null && nodo.valor <= min.valor) {
            return false;
        }
        if (max != null && nodo.valor >= max.valor) {
            return false;
        }
        return esBSTAux(nodo.izq, min, nodo) && esBSTAux(nodo.der, nodo, max);
    }

    public static void main(String[] args) {
        //        8
        //      /   \
        //     3     10
        //    / \      \
        //   1   6      14
        Nodo bueno = new Nodo(8, new Nodo(3, new Nodo(1), new Nodo(6)), new Nodo(10, null, new Nodo(14)));
        System.out.println("BST correcto: " + esBST(bueno) + " (esperado true)");

        // El 9 está bien respecto a su padre (3) pero no respecto al 8 de la raíz
        Nodo trampa = new Nodo(8, new Nodo(3, new Nodo(1), new Nodo(9)), new Nodo(10));
        System.out.println("9 en el subárbol izquierdo del 8: " + esBST(trampa) + " (esperado false)");

        Nodo repetido = new Nodo(5, new Nodo(5), null);
        System.out.println("Valor repetido: " + esBST(repetido) + " (esperado false)");
        System.out.println("Árbol vacío: " + esBST(null) + " (esperado true)");
    }
}
