package SegundoExamen.CorregioApartados.Repaso2Trim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ej5_CatalogoAutos {
    public static void main(String[] args) {
        // Crear el HashMap que relaciona una marca de auto con una lista de sus modelos
        Map<String, List<String>> marcaModelos = new HashMap<>();

        // Añadir algunas marcas y modelos al mapa
        marcaModelos.put("Toyota", new ArrayList<>(List.of("Corolla", "Camry", "RAV4")));
        marcaModelos.put("Ford", new ArrayList<>(List.of("Fiesta", "Focus", "Explorer")));
        marcaModelos.put("Honda", new ArrayList<>(List.of("Civic", "Accord", "CR-V")));

        // Mostrar la lista de modelos para una marca específica
        String marca = "Honda"; // Marca de la que queremos mostrar los modelos
        List<String> modelos = marcaModelos.get(marca);

        if (modelos != null) {
            System.out.println("Modelos de " + marca + ": " + modelos);
        } else {
            System.out.println("No se encontraron modelos para la marca especificada.");
        }
    }
}
