package FicherosTexto.BoletínFicheros2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {

    public static void encontrarPalabra(String nFichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(nFichero))) {
            Scanner s = new Scanner(System.in);

            ArrayList<String> lineaFicheros = new ArrayList<>();
            String lineaContenido;
            String buscador;
            Boolean encontrado = false;

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
                String[] palabras = linea.split(" ");

                for (int i = 0; i < palabras.length; i++) {
                    if (palabras[i].equalsIgnoreCase(buscador)) {
                        encontrado = true;
                        break;
                    }
                }
            }

            System.out.println(encontrado);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String nombreDelFichero = "biblioteca.txt";

        encontrarPalabra(nombreDelFichero);
    }
}
