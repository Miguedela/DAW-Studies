package FicherosTexto.EjerciciosFicheros1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo
        ArrayList<String> lineaFicheros = new ArrayList<>();
        String contenido = null;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero, false))) {
            System.out.println("Ingresa el contenido, para finalizar escribe (stop)");
            do {
                contenido = s.nextLine();

                if (!(contenido.equalsIgnoreCase("stop"))) {
                    bw.write(contenido); // Escribir el contenido el archivo
                    bw.newLine(); // Salto de linea en el archivo
                    lineaFicheros.add(contenido); // Agregar contenido (cada linea un objeto en el ArrayList)
                    System.out.println("Linea añadida correctamente, para finalizar escribe (stop)");
                }
            } while (!(contenido.equalsIgnoreCase("stop")));
            s.close(); // Cierro el objeto Scanner

            System.out.println("Contenido escrito correctamente");

            System.out.println(lineaFicheros); // Mostrar por pantalla el contenido de el ArrayList

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
