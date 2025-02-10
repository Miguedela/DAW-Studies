package FicherosTexto.EjerciciosFicheros0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        String nombreDelFichero = "saludo.txt"; // Nombre del archivo de texto a leer

        int numeroLineas = 0;
        int numeroPalabras = 0;
        int numeroCaracteres = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreDelFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                numeroLineas++;
                numeroCaracteres += linea.length(); // Contar caracteres de la línea

                // Contar palabras de la línea (delimitadas por espacios)
                String[] palabras = linea.split("\\s+");
                numeroPalabras += palabras.length;
            }

            System.out.println("Número de líneas: " + numeroLineas);
            System.out.println("Número de palabras: " + numeroPalabras);
            System.out.println("Número de caracteres: " + numeroCaracteres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
