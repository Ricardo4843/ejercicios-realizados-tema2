package recursividad;

/**
 * Ejercicio 2.5: true si la pieza o alguno de sus componentes (a cualquier nivel) es defectuoso.
 */
public class Ejercicio5Defectos {

    public static boolean contieneDefectos(Pieza piezaPrincipal) {
        boolean fallo = false;
        if (piezaPrincipal.isDefectuosa()) {
            return true;
        }
        for (Pieza p : piezaPrincipal.getComponentes()) {
            fallo = contieneDefectos(p);
            if (fallo) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Pieza espada = new Pieza("espada", false);
        Pieza cazoleta = new Pieza("cazoleta", false);
        Pieza hoja = new Pieza("hoja", false);
        Pieza punta = new Pieza("punta electrica", false);
        hoja.getComponentes().add(punta);
        espada.getComponentes().add(cazoleta);
        espada.getComponentes().add(hoja);
        System.out.println("Todo bien: " + contieneDefectos(espada) + " (esperado false)");

        punta.getComponentes().add(new Pieza("muelle", true));
        System.out.println("Muelle roto dentro de la punta: " + contieneDefectos(espada) + " (esperado true)");
        System.out.println("Solo la cazoleta: " + contieneDefectos(cazoleta) + " (esperado false)");
    }
}
