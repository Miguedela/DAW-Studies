package SegundoExamen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Ejercicio 5: Desarrolla un programa que utilice un HashMap para mapear una marca de auto
// (String) con una lista de modelos (ArrayList de String). Añade algunas marcas y modelos al
// mapa, y luego muestra la lista de modelos para una marca dada.

public class Ejercicio5_modelos {
    public static void main(String[] args) {

        // Crear el HashMap que relaciona una marca de auto con una lista de sus modelos
        HashMap<String, ArrayList<String>> marcaModelos = new HashMap<>();

        // Añadir algunas marcas y modelos al mapa
        marcaModelos.put("Toyota", new ArrayList<>(List.of("Corolla", "Camry", "RAV4")));
        marcaModelos.put("Ford", new ArrayList<>(List.of("Fiesta", "Focus", "Explorer")));
        marcaModelos.put("Honda", new ArrayList<>(List.of("Civic", "Accord", "CR-V")));

        // Mostrar la lista de modelos para una marca específica
        String marca = "Toyota"; // Marca de la que queremos mostrar los modelos
        ArrayList<String> modelos = marcaModelos.get(marca);

        if (modelos != null) {
            System.out.println("Modelos de " + marca + ": " + modelos);
        } else {
            System.out.println("No se encontraron modelos para la marca especificada.");
        }
    }
}
