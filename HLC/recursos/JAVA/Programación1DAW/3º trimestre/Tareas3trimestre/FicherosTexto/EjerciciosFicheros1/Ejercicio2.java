package FicherosTexto.EjerciciosFicheros1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo
        String contenido = null;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero, false))) {
            System.out.println("Ingresa el contenido, para finalizar escribe (stop)");
            do {
                contenido = s.nextLine();

                if (!(contenido.equalsIgnoreCase("stop"))) {
                    bw.write(contenido); // Escribir el contenido el archivo
                    bw.newLine(); // Salto de linea en el archivo
                    System.out.println("Linea añadida correctamente");
                }
            } while (!(contenido.equalsIgnoreCase("stop")));
            s.close(); // Cierro el objeto Scanner

            System.out.println("Contenido escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
