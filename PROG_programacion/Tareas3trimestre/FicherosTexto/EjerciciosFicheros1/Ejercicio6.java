package FicherosTexto.EjerciciosFicheros1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio6 {
    public static void main(String[] args) {
        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo
        ArrayList<String> listaFrases = new ArrayList<>();
        String linea = null;

        // Try que al encontrar el archivo vuelca su contenido en el ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader(nombreDelFichero))) {
            while ((linea = br.readLine()) != null) {
                listaFrases.add(linea);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
            return;
        }

        Collections.sort(listaFrases); // Ordeno el contenido del ArrayList con el collections.sort()

        // Try que vuelca el contenido actualizado del ArrayList en el fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero))) {
            for (String lineaActual : listaFrases) {
                bw.write(lineaActual); // Escribir la línea en el archivo
                bw.newLine(); // Agregar una nueva línea
            }
            System.out.println(nombreDelFichero + " ha sido ordenado correctamente.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
    }
}
