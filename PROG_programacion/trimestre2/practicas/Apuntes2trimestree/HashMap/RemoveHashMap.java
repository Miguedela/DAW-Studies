package HashMap;

import java.util.HashMap;

public class RemoveHashMap {
    public static void main(String[] args) {
        // Crear un HashMap que almacene nombres y edades
        HashMap<String, Integer> mapaEdades = new HashMap<>();
        // Agregar elementos al HashMap
        mapaEdades.put("Juan", 25);
        mapaEdades.put("María", 30);
        mapaEdades.put("Pedro", 40);
        // Obtener el valor asociado con una clave
        int edadMaria = mapaEdades.get("María");
        System.out.println("La edad de María es: " + edadMaria);
        // Verificar si una clave existe en el HashMap
        String nombre = "Pedro";
        if (mapaEdades.containsKey(nombre)) {
            System.out.println(nombre + " está en el HashMap.");
        } else {

            System.out.println(nombre + " no está en el HashMap.");
        }
        // Iterar sobre las claves y valores del HashMap
        System.out.println("Nombres y edades en el HashMap:");
        for (String clave : mapaEdades.keySet()) {
            int edad = mapaEdades.get(clave);
            System.out.println(clave + ": " + edad);
        }
        // Eliminar un elemento del HashMap
        mapaEdades.remove("Juan");
        System.out.println("Después de eliminar a Juan, el tamaño del HashMap es: " + mapaEdades.size());


        // Apuntes hecho por ChatGPT
        // Crear un HashMap
        HashMap<Integer, String> mapaNumeros = new HashMap<>();

        // Añadir elementos al HashMap
        mapaNumeros.put(1, "Uno");
        mapaNumeros.put(2, "Dos");
        mapaNumeros.put(3, "Tres");

        // Acceder a un valor por su clave
        String valor = mapaNumeros.get(2);
        System.out.println("Valor asociado a la clave 2: " + valor);

        // Iterar sobre las claves
        System.out.println("Claves en el HashMap:");
        for (Integer clave : mapaNumeros.keySet()) {
            System.out.println(clave);
        }

        // Iterar sobre los valores
        System.out.println("Valores en el HashMap:");
        for (String valorr : mapaNumeros.values()) {
            System.out.println(valorr);
        }

        // Verificar si una clave está presente
        boolean contieneClave = mapaNumeros.containsKey(3);
        System.out.println("¿Contiene la clave 3? " + contieneClave);

        // Verificar si un valor está presente
        boolean contieneValor = mapaNumeros.containsValue("Cuatro");
        System.out.println("¿Contiene el valor 'Cuatro'? " + contieneValor);

        // Obtener el tamaño del HashMap
        int tamaño = mapaNumeros.size();
        System.out.println("Tamaño del HashMap: " + tamaño);

        // Eliminar un elemento por su clave
        mapaNumeros.remove(1);

        // Actualizar el tamaño después de remover la clave 1
        tamaño = mapaNumeros.size();
        System.out.println("Tamaño del HashMap después de eliminar la clave 1: " + tamaño);

        // Limpiar el HashMap
        mapaNumeros.clear();

        // Verificar si el HashMap está vacío
        boolean estaVacio = mapaNumeros.isEmpty();
        System.out.println("¿El HashMap está vacío? " + estaVacio);
    }
}