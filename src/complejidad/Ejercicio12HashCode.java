package complejidad;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Ejercicio 3.12: hashCode que devuelve siempre 17. ¿Errores de compilación? ¿De ejecución? ¿Es buena implementación?
 */
public class Ejercicio12HashCode {

    // hashCode del enunciado: siempre 17
    static class AlumnoConstante {
        String nombre;
        double nota;

        AlumnoConstante(String nombre, double nota) {
            this.nombre = nombre;
            this.nota = nota;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof AlumnoConstante)) return false;
            AlumnoConstante o = (AlumnoConstante) obj;
            return this.nombre.equals(o.nombre) && this.nota == o.nota;
        }

        @Override
        public int hashCode() {
            return 17;
        }
    }

    // hashCode aleatorio: incumple la regla (iguales -> mismo hashCode)
    static class AlumnoAleatorio extends AlumnoConstante {
        AlumnoAleatorio(String nombre, double nota) {
            super(nombre, nota);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlumnoAleatorio)) return false;
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return (int) (Math.random() * 1000);
        }
    }

    // hashCode bueno: iguales -> mismo hashCode, y distintos se reparten
    static class AlumnoBueno extends AlumnoConstante {
        AlumnoBueno(String nombre, double nota) {
            super(nombre, nota);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AlumnoBueno)) return false;
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre, nota);
        }
    }

    public static void main(String[] args) {
        Set<AlumnoConstante> constante = new HashSet<>();
        constante.add(new AlumnoConstante("Ana", 8.0));
        System.out.println("return 17 -> contains(otra Ana 8.0): " + constante.contains(new AlumnoConstante("Ana", 8.0)));

        Set<AlumnoConstante> aleatorio = new HashSet<>();
        aleatorio.add(new AlumnoAleatorio("Ana", 8.0));
        int fallos = 0;
        for (int i = 0; i < 1000; i++) {
            if (!aleatorio.contains(new AlumnoAleatorio("Ana", 8.0))) fallos++;
        }
        System.out.println("Math.random -> contains falla " + fallos + " de 1000 veces");

        // tiempo de meter y buscar N alumnos: con 17 todos caen en el mismo cajón
        int N = 20000;
        long t0 = System.nanoTime();
        Set<AlumnoConstante> s1 = new HashSet<>();
        for (int i = 0; i < N; i++) s1.add(new AlumnoConstante("A" + i, i));
        long tConstante = (System.nanoTime() - t0) / 1000000;

        t0 = System.nanoTime();
        Set<AlumnoConstante> s2 = new HashSet<>();
        for (int i = 0; i < N; i++) s2.add(new AlumnoBueno("A" + i, i));
        long tBueno = (System.nanoTime() - t0) / 1000000;

        System.out.println("Meter " + N + " alumnos: return 17 = " + tConstante + " ms, Objects.hash = " + tBueno + " ms");
        System.out.println("\nCompila y no da errores de ejecución: los iguales dan el mismo hashCode (17), así que es correcto.");
        System.out.println("No es bueno: todos colisionan en el mismo cajón y buscar pasa de O(1) a O(n).");
    }
}
