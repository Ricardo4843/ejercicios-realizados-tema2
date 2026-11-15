package complejidad;

/**
 * Ejercicio 3.13: analizar un árbol binario de búsqueda (depth, size, get, put), explicando las operaciones y su complejidad.
 */
public class Ejercicio13BST {

    static class NodoClave {
        String key;
        Object value;
        NodoClave left;
        NodoClave right;

        NodoClave(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private NodoClave root;

    // altura: O(n), visita cada nodo una vez
    public int depth() {
        return depth(root);
    }

    private int depth(NodoClave node) {
        if (node == null)
            return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    // número de nodos: O(n), visita cada nodo una vez
    public int size() {
        return size(root);
    }

    private int size(NodoClave node) {
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    // buscar: mejor O(1), equilibrado O(log n), degenerado O(n)
    public Object get(String key) {
        return get(root, key);
    }

    private Object get(NodoClave node, String key) {
        if (node == null)
            return null;
        if (key.equals(node.key))
            return node.value;
        if (key.compareTo(node.key) < 0)
            return get(node.left, key);
        else
            return get(node.right, key);
    }

    // insertar o actualizar: equilibrado O(log n), degenerado O(n)
    public void put(String key, Object value) {
        root = put(root, key, value);
    }

    private NodoClave put(NodoClave node, String key, Object value) {
        if (node == null)
            return new NodoClave(key, value);
        if (key.equals(node.key))
            node.value = value;
        else if (key.compareTo(node.key) < 0)
            node.left = put(node.left, key, value);
        else
            node.right = put(node.right, key, value);
        return node;
    }

    // put sin guardar lo que devuelve la llamada recursiva: el nodo nuevo se pierde
    public void putMal(String key, Object value) {
        root = putMal(root, key, value);
    }

    private NodoClave putMal(NodoClave node, String key, Object value) {
        if (node == null)
            return new NodoClave(key, value);
        if (key.equals(node.key))
            node.value = value;
        else if (key.compareTo(node.key) < 0)
            putMal(node.left, key, value);
        else
            putMal(node.right, key, value);
        return node;
    }

    public static void main(String[] args) {
        Ejercicio13BST arbol = new Ejercicio13BST();
        String[] claves = {"M", "F", "T", "C", "H", "P", "W"};
        for (int i = 0; i < claves.length; i++) {
            arbol.put(claves[i], i);
        }
        System.out.println("Equilibrado (M, F, T, C, H, P, W): size = " + arbol.size() + ", depth = " + arbol.depth());
        System.out.println("get(\"H\") = " + arbol.get("H") + ", get(\"Z\") = " + arbol.get("Z"));
        arbol.put("H", 99);
        System.out.println("put(\"H\", 99) con clave existente: get(\"H\") = " + arbol.get("H") + ", size sigue en " + arbol.size());

        Ejercicio13BST degenerado = new Ejercicio13BST();
        for (String k : new String[] {"A", "B", "C", "D", "E", "F", "G"}) {
            degenerado.put(k, k);
        }
        System.out.println("Degenerado (A..G en orden): size = " + degenerado.size() + ", depth = " + degenerado.depth() + " (como una lista)");

        Ejercicio13BST mal = new Ejercicio13BST();
        mal.putMal("B", 1);
        mal.putMal("A", 2);
        System.out.println("putMal(\"B\"), putMal(\"A\"): size = " + mal.size() + ", get(\"A\") = " + mal.get("A") + " -> A se ha perdido");
    }
}
