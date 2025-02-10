package FicherosTexto.EjerciciosFicheros1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo

        try (BufferedReader br = new BufferedReader(new FileReader(nombreDelFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea); // Muestro por pantalla el contenido del fichero
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
