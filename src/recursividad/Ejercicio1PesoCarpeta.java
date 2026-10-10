package recursividad;

/**
 * Ejercicio 2.1: peso total de una carpeta (sus archivos y los de todas sus subcarpetas).
 */
public class Ejercicio1PesoCarpeta {

    public static double calcularPesoTotal(Carpeta inicio) {
        if (inicio == null) {
            return 0;
        }
        double total = 0;
        for (Archivo a : inicio.getArchivos()) {
            total += a.getPesoMB();
        }
        for (Carpeta c : inicio.getSubcarpetas()) {
            total += calcularPesoTotal(c);
        }
        return total;
    }

    public static void main(String[] args) {
        Carpeta raiz = new Carpeta("raiz");
        raiz.getArchivos().add(new Archivo("notas.txt", 0.5));
        Carpeta fotos = new Carpeta("fotos");
        fotos.getArchivos().add(new Archivo("dublin.jpg", 3.2));
        fotos.getArchivos().add(new Archivo("belgrado.jpg", 2.8));
        Carpeta videos = new Carpeta("videos");
        videos.getArchivos().add(new Archivo("asalto.mp4", 120));
        fotos.getSubcarpetas().add(videos);
        raiz.getSubcarpetas().add(fotos);
        raiz.getSubcarpetas().add(new Carpeta("vacia"));

        System.out.println("Peso total: " + calcularPesoTotal(raiz) + " MB (esperado 126.5)");
        System.out.println("Carpeta vacia: " + calcularPesoTotal(new Carpeta("x")) + " MB");
        System.out.println("null: " + calcularPesoTotal(null) + " MB");
    }
}
