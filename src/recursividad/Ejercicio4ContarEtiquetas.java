package recursividad;

/**
 * Ejercicio 2.4: cuántas veces aparece una etiqueta en el árbol que empieza en un elemento.
 */
public class Ejercicio4ContarEtiquetas {

    public static int contarEtiquetas(ElementoHTML elemento, String tagBuscado) {
        if (elemento == null || tagBuscado == null) {
            return 0;
        }
        int veces = 0;
        if (tagBuscado.equals(elemento.getTag())) {
            veces = 1;
        }
        for (ElementoHTML hijo : elemento.getHijos()) {
            veces += contarEtiquetas(hijo, tagBuscado);
        }
        return veces;
    }

    public static void main(String[] args) {
        ElementoHTML body = new ElementoHTML("body");
        ElementoHTML div = new ElementoHTML("div");
        ElementoHTML div2 = new ElementoHTML("div");
        div.getHijos().add(new ElementoHTML("p"));
        div.getHijos().add(new ElementoHTML("img"));
        div2.getHijos().add(new ElementoHTML("p"));
        div2.getHijos().add(new ElementoHTML("p"));
        div.getHijos().add(div2);
        body.getHijos().add(div);
        body.getHijos().add(new ElementoHTML("p"));

        System.out.println("p: " + contarEtiquetas(body, "p") + " (esperado 4)");
        System.out.println("div: " + contarEtiquetas(body, "div") + " (esperado 2)");
        System.out.println("body: " + contarEtiquetas(body, "body") + " (esperado 1)");
        System.out.println("h1: " + contarEtiquetas(body, "h1") + " (esperado 0)");
    }
}
