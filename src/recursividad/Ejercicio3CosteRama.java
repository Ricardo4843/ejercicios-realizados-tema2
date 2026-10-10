package recursividad;

/**
 * Ejercicio 2.3: puntos para desbloquear una habilidad y todas las que descienden de ella.
 */
public class Ejercicio3CosteRama {

    public static int costeRamaCompleta(Habilidad raiz) {
        if (raiz == null) {
            return 0;
        }
        int total = raiz.getCoste();
        for (Habilidad h : raiz.getDesbloqueables()) {
            total += costeRamaCompleta(h);
        }
        return total;
    }

    public static void main(String[] args) {
        Habilidad estocada = new Habilidad("estocada", 1);
        Habilidad fondo = new Habilidad("fondo", 2);
        Habilidad flecha = new Habilidad("flecha", 3);
        Habilidad parada = new Habilidad("parada", 2);
        Habilidad respuesta = new Habilidad("parada-respuesta", 4);
        estocada.getDesbloqueables().add(fondo);
        estocada.getDesbloqueables().add(parada);
        fondo.getDesbloqueables().add(flecha);
        parada.getDesbloqueables().add(respuesta);

        System.out.println("Rama completa: " + costeRamaCompleta(estocada) + " (esperado 12)");
        System.out.println("Rama de fondo: " + costeRamaCompleta(fondo) + " (esperado 5)");
        System.out.println("Hoja: " + costeRamaCompleta(flecha) + " (esperado 3)");
    }
}
