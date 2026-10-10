package complejidad;

import java.util.ArrayList;
import java.util.List;

/**
 * Nodo de un árbol N-ario, con una lista de hijos (ejercicio 3.7).
 */
public class NodoNArio {

    private List<NodoNArio> hijos = new ArrayList<>();

    public List<NodoNArio> getHijos() {
        return this.hijos;
    }
}
