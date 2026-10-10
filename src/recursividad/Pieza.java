package recursividad;

import java.util.ArrayList;
import java.util.List;

/**
 * Pieza formada por otras piezas (ejercicio 2.5).
 */
public class Pieza {

    private String nombre;
    private boolean esDefectuosa;
    private List<Pieza> componentes;

    public Pieza(String nombre, boolean esDefectuosa) {
        this.nombre = nombre;
        this.esDefectuosa = esDefectuosa;
        this.componentes = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean isDefectuosa() {
        return this.esDefectuosa;
    }

    public List<Pieza> getComponentes() {
        return this.componentes;
    }
}
