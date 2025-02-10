package SegundoExamen.CorregioApartados.Repaso2Trim;

import java.util.HashMap;
import java.util.Map;

// Ejercicio 6: Escribe un programa que tome un String como entrada y cuente cuántas veces
// aparece cada letra. Utiliza un HashMap donde cada clave es una letra y cada valor es el
// número de veces que esa letra aparece en el String.

public class Ej6_ContadorLetras {
    public static void main(String[] args) {
        // El String para analizar
        String texto = "Clase de 1º de DAW de programación, turno de tarde.";

        // HashMap para almacenar el conteo de cada letra
        Map<Character, Integer> conteoLetras = new HashMap<>();

        // Convertir el texto a minúsculas para hacer el conteo insensible a mayúsculas
        texto = texto.toLowerCase();

        // Iterar sobre cada carácter del String
        for (char letra : texto.toCharArray()) {
            // Comprobar si el carácter es una letra
            if (Character.isLetter(letra)) {
                conteoLetras.put(letra, conteoLetras.getOrDefault(letra, 0) + 1);
            }
        }

        // Imprimir el conteo de cada letra
        for (Map.Entry<Character, Integer> entrada : conteoLetras.entrySet()) {
            System.out.println("Letra: " + entrada.getKey() + ", Cantidad: " + entrada.getValue());
        }
    }
}
