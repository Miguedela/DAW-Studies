package FicherosTexto.BoletínFicheros2.Corregidos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1Corregido {
    // Metodo para crear un fichero de texto con contenido
    public static void escribirElArchivo(String rutaFichero, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero, false))) {
            bw.write(contenido);
            System.out.println("Contenido escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodos para crear un fichero de texto con contenido
    public static void mostrarTexto1(String contenido) {
        for (int i = 0; i < contenido.length(); i++) {
            if (Character.isUpperCase(contenido.charAt(i))) {
                System.out.print(Character.toLowerCase(contenido.charAt(i)));
            } else if (Character.isLowerCase(contenido.charAt(i))) {
                System.out.print(Character.toUpperCase(contenido.charAt(i)));
            } else {
                System.out.print(contenido.charAt(i));
            }
        }
    }

    public static void mostrarTexto2(String contenido) {
        StringBuilder contenidoBuilder = new StringBuilder();

        for (char c : contenido.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    contenidoBuilder.append(Character.toLowerCase(c));
                } else {
                    contenidoBuilder.append(Character.toUpperCase(c));
                }
            } else {
                contenidoBuilder.append(c);
            }

            System.out.println(contenidoBuilder.toString());
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce la ruta del fichero donde deseas guardar la información: ");
        String rutaFichero = s.nextLine();
        System.out.print("Introduce el texto que deseas guardar en el fichero " + rutaFichero + ": ");
        String contenido = s.nextLine();
        s.close(); // Cierro el Scanner

        escribirElArchivo(rutaFichero, contenido);
        mostrarTexto1(contenido);
    }
}
