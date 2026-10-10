package recursividad;

import java.util.ArrayList;
import java.util.List;

/**
 * Empleado con sus subordinados directos (ejercicio 2.2).
 */
public class Empleado {

    private String nombre;
    private double salario;
    private List<Empleado> subordinados;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
        this.subordinados = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getSalario() {
        return this.salario;
    }

    public List<Empleado> getSubordinados() {
        return this.subordinados;
    }
}
