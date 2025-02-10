package FicherosTexto.EjerciciosFicheros1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // ATRIBUTOS
        String nombreDelFichero = "saludo.txt"; // Atributo con el nombre del archivo
        ArrayList<String> lineaFicheros = new ArrayList<>();
        String buscador = null;
        String remplazo = null;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreDelFichero))) {
            // Mostrar el contenido actualizado del archivo
            System.out.println("Contenido del archivo después del reemplazo:");
            for (String line : lineaFicheros) {
                System.out.println(line);
            }String lineaContenido;

            while ((lineaContenido = br.readLine()) != null) {
                lineaFicheros.add(lineaContenido);
            }

            // Muestro el contenido del ARrayList (contiene el contenido del fichero)
            System.out.println("Muestro el contenido de el archivo de texto");
            System.out.println(lineaFicheros);

            // Pido que se ingrese la palabra que se desea encontrar
            System.out.print("Introduce la palabra que quiere buscar: ");
            buscador = s.nextLine();

            // Pido que se ingrese la palabra que se desea cambiar
            System.out.print("Introduce la palabra por la que desea remplazar: ");
            remplazo = s.nextLine();
            s.close(); // Cierro el Scanner(s)

            // Realizar el reemplazo en cada línea del archivo
            for (int i = 0; i < lineaFicheros.size(); i++) {
                String linea = lineaFicheros.get(i);
                linea = linea.replaceAll(buscador, remplazo);
                lineaFicheros.set(i, linea);
            }

            // Escribir las líneas actualizadas de vuelta al archivo
            try (FileWriter fw = new FileWriter(nombreDelFichero)) {
                for (String line : lineaFicheros) {
                    fw.write(line + "\n");
                }
                System.out.println("Reemplazo completado y guardado en el archivo.");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Mostrar el contenido actualizado del archivo
            System.out.println("Contenido del archivo después del reemplazo:");
            for (String line : lineaFicheros) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
