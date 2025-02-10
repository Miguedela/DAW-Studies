package FicherosTexto.EjerciciosFicheros0;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        String nombreDelFichero = "saludo.txt";
        String contenido = "Hola, Mundo";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero, false))) {
            bw.write(contenido);
            System.out.println("Contenido escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
