package recursividad;

/**
 * Ejercicio 2.2: coste en salarios de un jefe y de todos sus subordinados (directos e indirectos).
 */
public class Ejercicio2PresupuestoEquipo {

    public static double presupuestoEquipo(Empleado jefe) {
        double dinero = jefe.getSalario();
        for (Empleado sub : jefe.getSubordinados()) {
            dinero += presupuestoEquipo(sub);
        }
        return dinero;
    }

    public static void main(String[] args) {
        Empleado director = new Empleado("Directora", 5000);
        Empleado jefeA = new Empleado("Jefe A", 3000);
        Empleado jefeB = new Empleado("Jefe B", 3200);
        jefeA.getSubordinados().add(new Empleado("Ana", 1800));
        jefeA.getSubordinados().add(new Empleado("Luis", 1700));
        jefeB.getSubordinados().add(new Empleado("Marta", 1900));
        director.getSubordinados().add(jefeA);
        director.getSubordinados().add(jefeB);

        System.out.println("Toda la empresa: " + presupuestoEquipo(director) + " (esperado 16600.0)");
        System.out.println("Equipo de Jefe A: " + presupuestoEquipo(jefeA) + " (esperado 6500.0)");
        System.out.println("Sin subordinados: " + presupuestoEquipo(new Empleado("Becario", 600)));
    }
}
