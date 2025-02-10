package FicheroTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroTexto {
    public static void main(String[] args) {
        String nombreDelFichero = "archivo.txt";
        String contenido = "Este es el contenido que quiero escribir en el fichero.";

        try (BufferedWriter bw = new BufferedWriter(new

        FileWriter(nombreDelFichero, true))) {
            bw.write(contenido);
            bw.newLine(); // Agrega una nueva línea después del contenido

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}