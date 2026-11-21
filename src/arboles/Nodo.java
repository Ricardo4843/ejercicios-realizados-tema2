package arboles;

/**
 * Nodo de un árbol binario de búsqueda (como el de la clase 7).
 */
public class Nodo {

    int valor;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
    }

    public Nodo(int valor, Nodo izquierda, Nodo derecha) {
        this.valor = valor;
        this.izquierda = izquierda;
        this.derecha = derecha;
    }
}
