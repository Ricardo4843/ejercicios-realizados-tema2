package complejidad;

/**
 * Nodo de un árbol binario (ejercicios 3.8 y 3.9).
 */
public class Node {

    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
