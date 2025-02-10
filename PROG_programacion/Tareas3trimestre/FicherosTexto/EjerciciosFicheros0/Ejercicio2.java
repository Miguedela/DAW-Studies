package FicherosTexto.EjerciciosFicheros0;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        String nombreDelFichero = "saludo.txt"; // Nombre del archivo
        String contenido = "Añadido el " + fechaHoraActual; // Contenido a escribir en el archivo

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero, true))) {
            // Escribir el contenido en el archivo
            bw.write(contenido);
            bw.newLine(); // Agregar una nueva línea después del contenido
            System.out.println("Contenido escrito correctamente");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
