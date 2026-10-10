package complejidad;

/**
 * Ejercicio 3.8: método misterioso (II): qué calcula sobre un árbol binario.
 */
public class Ejercicio8MetodoMisterioso {

    public int metodoMisterioso(Node nodo) {
        if (nodo == null) return 0;
        int izq = metodoMisterioso(nodo.left);
        int der = metodoMisterioso(nodo.right);
        return 1 + Math.max(izq, der);
    }

    public static void main(String[] args) {
        Ejercicio8MetodoMisterioso m = new Ejercicio8MetodoMisterioso();
        //        8
        //      /   \
        //     3     10
        //    / \      \
        //   1   6      14
        //      /
        //     4
        Node arbol = new Node(8, new Node(3, new Node(1), new Node(6, new Node(4), null)), new Node(10, null, new Node(14)));
        System.out.println("Árbol de 4 niveles: " + m.metodoMisterioso(arbol));
        System.out.println("Un solo nodo: " + m.metodoMisterioso(new Node(5)));
        System.out.println("Árbol vacío: " + m.metodoMisterioso(null));
        System.out.println("Calcula la altura del árbol (número de niveles)");
    }
}
