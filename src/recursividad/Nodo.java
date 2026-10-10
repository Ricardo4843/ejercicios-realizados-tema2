package recursividad;

/**
 * Nodo de un árbol binario (ejercicio 2.7).
 */
public class Nodo {

    int valor;
    Nodo izq, der;

    public Nodo(int valor) {
        this.valor = valor;
    }

    public Nodo(int valor, Nodo izq, Nodo der) {
        this.valor = valor;
        this.izq = izq;
        this.der = der;
    }
}
