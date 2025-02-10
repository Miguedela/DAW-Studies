package FicherosTexto.EjercicioFicherosDictado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Pedir nombre completo para contar la cantidad de letras */

public class Ejercicio2Dictado {
    public static void main(String[] args) {
        // Instancio el objeto de Scanner
        Scanner s = new Scanner(System.in);

        // HashMap para almacenar el conteo de cada letra
        Map<Character, Integer> conteoLetras = new HashMap<>();

        // Artibutos String para nombrar los archivos de texto
        String nombreDelFichero1 = "nombre.txt";
        String nombreDelFichero2 = "conteo.txt";

        // Pido que se introduzca el nombre por teclado
        System.out.print("Introduce tú nombre completo: ");
        String nombreCompleto = s.nextLine();

        // Cierro el Scanner
        s.close();

        // Convertir el texto a minúsculas para hacer el conteo insensible a mayúsculas
        String nombreCompletoMinusculas = nombreCompleto.toLowerCase();


        // Iterar sobre cada carácter del String
        for (char letra : nombreCompletoMinusculas.toCharArray()) {
            // Comprobar si el carácter es una letra
            if (Character.isLetter(letra)) {
                conteoLetras.put(letra, conteoLetras.getOrDefault(letra, 0) + 1);
            }
        }

        // try para escribir el nombre en el archivo de nombre
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero1, false))) {

            bw.write(nombreCompleto); // Agrego el nombre completo
            bw.newLine(); // Agrega una nueva línea después del contenido
            bw.close();

            System.out.println("Nombre completo escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try para meter el conteo de letra en el archivo de conteo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero2, false))) {

            for (Map.Entry<Character, Integer> lineaHashMap : conteoLetras.entrySet()) {
                bw.write(lineaHashMap.getKey() + ": " + lineaHashMap.getValue()); // Agrego el conjunto clave-valor al archivo
                bw.newLine(); // Agrega una nueva línea después del contenido
            }
            bw.close();

            System.out.println("Conteo de letras escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
