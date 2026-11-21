package arboles;

/**
 * Recorridos recursivos de árboles, tipo examen.
 */
public class ArbolesRecursivos {

    // Contar los nodos del árbol que empieza en n
    public static int contarNodos(Nodo n) {
        if (n == null)
            return 0;
        return 1 + contarNodos(n.izquierda) + contarNodos(n.derecha);
    }

    // Sumar los valores de todos los nodos del árbol que empieza en n
    public static int sumarValores(Nodo n) {
        if (n == null)
            return 0;
        return n.valor + sumarValores(n.izquierda) + sumarValores(n.derecha);
    }

    // Buscar un valor en un BST de forma recursiva
    public static boolean contains(Nodo n, int valor) {
        if (n == null)
            return false;
        if (n.valor == valor)
            return true;
        if (n.valor < valor)
            return contains(n.derecha, valor);
        else {
            return contains(n.izquierda, valor);
        }
    }

    // Longitud de la cadena de segmentos más larga que sale de startNode
    public static double getMaxReach(Node startNode) {
        if (startNode.getChildren().size() == 0)
            return 0;
        double mejor = 0;
        for (Segment s : startNode.getChildren()) {
            Node n = s.getEndNode();
            double candidato = s.getLength() + getMaxReach(n);
            if (candidato > mejor)
                mejor = candidato;
        }
        return mejor;
    }

    public static void main(String[] args) {
        //        7
        //      /   \
        //     4     9
        //    / \   / \
        //   1   5 8   15
        Nodo raiz = new Nodo(7,
                new Nodo(4, new Nodo(1), new Nodo(5)),
                new Nodo(9, new Nodo(8), new Nodo(15)));
        System.out.println("contarNodos: " + contarNodos(raiz) + " (esperado 7)");
        System.out.println("sumarValores: " + sumarValores(raiz) + " (esperado 49)");
        System.out.println("contains 5: " + contains(raiz, 5) + " (esperado true)");
        System.out.println("contains 100: " + contains(raiz, 100) + " (esperado false)");
        System.out.println("Árbol vacío: " + contarNodos(null) + " " + sumarValores(null) + " " + contains(null, 3)
                + " (esperado 0 0 false)");

        // Hombro --30--> Codo --25--> Muñeca --8--> Dedo
        //                Codo --10--> Sensor
        Node hombro = new Node("Hombro");
        Node codo = new Node("Codo");
        Node muneca = new Node("Muñeca");
        Node dedo = new Node("Dedo");
        Node sensor = new Node("Sensor");
        hombro.addChild(new Segment(30, codo));
        codo.addChild(new Segment(25, muneca));
        codo.addChild(new Segment(10, sensor));
        muneca.addChild(new Segment(8, dedo));
        System.out.println("getMaxReach(Hombro): " + getMaxReach(hombro) + " (esperado 63.0)");
        System.out.println("getMaxReach(Codo): " + getMaxReach(codo) + " (esperado 33.0)");
        System.out.println("getMaxReach(Dedo): " + getMaxReach(dedo) + " (esperado 0.0)");
    }
}
