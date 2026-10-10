package recursividad;

/**
 * Ejercicio 2.6: palíndromo recursivo (sin espacios y en minúsculas).
 */
public class Ejercicio6Palindromo {

    public static boolean esPalindromo(String texto) {
        if (texto == null) {
            return false;
        }
        if (texto.length() <= 1) {
            return true;
        }
        if (texto.charAt(0) != texto.charAt(texto.length() - 1)) {
            return false;
        }
        return esPalindromo(texto.substring(1, texto.length() - 1));
    }

    public static void main(String[] args) {
        String[] pruebas = {"reconocer", "anilina", "abba", "esgrima", "ab", "a", ""};
        for (String p : pruebas) {
            System.out.println("\"" + p + "\": " + esPalindromo(p));
        }
    }
}
