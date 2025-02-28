import java.util.ArrayList;

public class ComandosEstrucDinamicas {
    /*
     * a) Busca la diferencia y tipos de las estructuras dinámicas más usadas en
     * Java:
     * Set, List, Map.
     */
    // "List" es una coleccion ordenada que permite duplicados, "Set" es una
    // * coleccion
    // * sin orden garantizados pero que no permite duplicados, y "Map" es una
    // * coleccion
    // * de pares ("key" => "valor") conde la clave ("key") es unica pero valores sí
    // * pueden duplicarse.

    /*
     * b) Escriba un programa Java para vaciar un ArrayList.
     */
    public static void vaciarArrayList(ArrayList<String> list) {
        System.out.println("Lista antes de vaciar: " + list);

        // Vaciar el ArrayList
        list.clear();

        System.out.println("Lista después de vaciar: " + list);
    }

    /*
     * c) Escriba un programa Java para probar si un ArrayList está vacío o no.
     */
    public static void comprobarDatosArrayList(ArrayList<String> list) {
        // Probar si está vacío
        if (list.isEmpty()) {
            System.out.println("El ArrayList está vacío.");
        } else {
            System.out.println("El ArrayList no está vacío.");
        }
    }

    /*
     * d) Escriba un programa Java para recortar la capacidad de un ArrayList al
     * tamaño actual de la lista. Usa el método trimToSize, para ello revisa la
     * API de Java de la clase ArrayList:
     * https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/util/ArrayList.
     * html
     */
    public static void cambiarCapacidadArrayList(ArrayList<String> list) {
        System.out.println("Capacidad antes de recortar: " + list.size());

        // Recortar la capacidad al tamaño actual
        list.trimToSize();

        System.out.println("Capacidad después de recortar: " + list.size());
    }

    /*
     * e) Escriba un programa Java para reemplazar el segundo elemento de una
     * ArrayList con el elemento especificado.
     */
    public static void remplazarElemento(ArrayList<String> list) {
        System.out.println("Lista antes del reemplazo: " + list);

        // Reemplazar el segundo elemento
        list.set(1, "Elemento Reemplazado");

        System.out.println("Lista después del reemplazo: " + list);
    }

    /*
     * f) Escriba un programa Java para imprimir todos los elementos de una
     * ArrayList utilizando la posición de los elementos.
     */
    public static void imprimirArrayList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}