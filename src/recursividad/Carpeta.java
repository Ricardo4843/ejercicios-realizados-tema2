package recursividad;

import java.util.ArrayList;
import java.util.List;

/**
 * Carpeta con archivos y subcarpetas (ejercicio 2.1).
 */
public class Carpeta {

    private String nombre;
    private List<Archivo> archivos;
    private List<Carpeta> subcarpetas;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.archivos = new ArrayList<>();
        this.subcarpetas = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Archivo> getArchivos() {
        return this.archivos;
    }

    public List<Carpeta> getSubcarpetas() {
        return this.subcarpetas;
    }
}
