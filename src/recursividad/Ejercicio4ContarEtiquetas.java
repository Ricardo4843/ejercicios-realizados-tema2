package recursividad;

/**
 * Ejercicio 2.4: cuántas veces aparece una etiqueta en el árbol que empieza en un elemento.
 */
public class Ejercicio4ContarEtiquetas {

    public static int contarEtiquetas(ElementoHTML elemento, String tagBuscado) {
        int encontrado = 0;
        if (elemento.getTag().compareTo(tagBuscado) == 0) {
            encontrado++;
        }
        for (ElementoHTML e : elemento.getHijos()) {
            encontrado += contarEtiquetas(e, tagBuscado);
        }
        return encontrado;
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
