package recursividad;

import java.util.ArrayList;
import java.util.List;

/**
 * Elemento de una página web en el modelo DOM (ejercicio 2.4).
 */
public class ElementoHTML {

    private String tag;
    private List<ElementoHTML> hijos;

    public ElementoHTML(String tag) {
        this.tag = tag;
        this.hijos = new ArrayList<>();
    }

    public String getTag() {
        return this.tag;
    }

    public List<ElementoHTML> getHijos() {
        return this.hijos;
    }
}
