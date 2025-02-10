package FicherosTexto.EjerciciosFicheros0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio5 {
    public static void main(String[] args) {
        String archivoOrigen = "saludo.txt";
        String archivoDestino = "saludoCopia.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoOrigen));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoDestino))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine(); // Agrega una nueva línea después de cada línea leída del archivo origen
            }

            System.out.println("Contenido copiado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
