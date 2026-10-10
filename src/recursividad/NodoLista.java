package recursividad;

/**
 * Nodo de una lista enlazada simple (ejercicios 2.8 y 2.10).
 */
public class NodoLista {

    int dato;
    NodoLista siguiente;

    public NodoLista(int dato) {
        this.dato = dato;
    }

    /** Crea una lista enlazada con los valores en el mismo orden. */
    public static NodoLista crear(int... valores) {
        NodoLista cabeza = null;
        for (int i = valores.length - 1; i >= 0; i--) {
            NodoLista nuevo = new NodoLista(valores[i]);
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
        return cabeza;
    }

    /** Texto de la lista a partir de este nodo: [1, 2, 3]. */
    public static String aTexto(NodoLista cabeza) {
        String texto = "[";
        for (NodoLista n = cabeza; n != null; n = n.siguiente) {
            texto += n.dato;
            if (n.siguiente != null) {
                texto += ", ";
            }
        }
        return texto + "]";
    }
}
