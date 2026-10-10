package recursividad;

/**
 * Archivo con un tamaño en MB (ejercicio 2.1).
 */
public class Archivo {

    private String nombre;
    private double pesoMB;

    public Archivo(String nombre, double peso) {
        this.nombre = nombre;
        this.pesoMB = peso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPesoMB() {
        return this.pesoMB;
    }
}
