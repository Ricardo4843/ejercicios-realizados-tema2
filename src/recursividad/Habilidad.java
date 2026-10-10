package recursividad;

import java.util.ArrayList;
import java.util.List;

/**
 * Habilidad del árbol de un videojuego (ejercicio 2.3).
 */
public class Habilidad {

    private String id;
    private int costePuntos;
    private List<Habilidad> desbloqueables;

    public Habilidad(String id, int costePuntos) {
        this.id = id;
        this.costePuntos = costePuntos;
        this.desbloqueables = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public int getCoste() {
        return this.costePuntos;
    }

    public List<Habilidad> getDesbloqueables() {
        return this.desbloqueables;
    }
}
