package FicherosTexto.BoletínFicheros2;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce el nombre del fichero donde deseas guardar la información: ");
        String nFichero = s.nextLine();
        nFichero = nFichero + ".txt";
        System.out.print("Introduce el texto que deseas guardar en el fichero " + nFichero + ": ");
        String contenido = s.nextLine();
        s.close(); // Cierro el Scanner

        // try para crear un fichero con el contenido deseado
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nFichero, false))) {
            bw.write(contenido);
            System.out.println("Contenido escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido

        } catch (IOException e) {
            e.printStackTrace();
        }

        // try para leer un fichero con el contenido deseado
        try (BufferedReader br = new BufferedReader(new FileReader(nFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                for (int i = 0; i < linea.length(); i++) {
                    if (Character.isUpperCase(linea.charAt(i))) {
                        System.out.print(Character.toLowerCase(linea.charAt(i)));
                    } else if (Character.isLowerCase(linea.charAt(i))) {
                        System.out.print(Character.toUpperCase(linea.charAt(i)));
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}