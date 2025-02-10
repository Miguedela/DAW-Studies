package FicherosTexto.EjerciciosFicheros1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo
        ArrayList<String> lineaFicheros = new ArrayList<>();
        String buscador = null;
        int lineaInfo = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreDelFichero))) {
            String lineaContenido;
            while ((lineaContenido = br.readLine()) != null) {
                lineaFicheros.add(lineaContenido);
            }

            // Muestro el contenido del ARrayList (contiene el contenido del fichero)
            System.out.println("Muestro el contenido de el archivo de texto");
            System.out.println(lineaFicheros);

            // Pido que se ingrese la palabra que se desea encontrar
            System.out.print("Introduce la palabra que quiere buscar: ");
            buscador = s.nextLine();
            s.close(); // Cierro el Scanner(s)

            for (String linea : lineaFicheros) {
                // ------Metodo para noobs------
                if (linea.contains(buscador)) {
                    System.out.println(buscador + " encontrada en la linea(" + lineaInfo + ")");
                }

                // ------Metodo para experimentados------
                String[] palabras = linea.split(" "); // Divido las lineas del texto en las palabras
                
                // Bucle for-i que recorre el array de las palabras
                for (int i = 0; i < palabras.length; i++) {
                    if (palabras[i].equalsIgnoreCase(buscador)) {
                        System.out.println(palabras[i] + " encontrada posición(" + i + "), linea(" + lineaInfo + ")");
                    }
                }

                lineaInfo++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
