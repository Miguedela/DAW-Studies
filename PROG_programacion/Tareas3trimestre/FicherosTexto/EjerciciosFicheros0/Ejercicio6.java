package FicherosTexto.EjerciciosFicheros0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la palabra a buscar: ");
        String palabraBuscar = scanner.nextLine();
        scanner.close();

        String archivoEntrada = "saludo.txt";
        String archivoSalida = "saludoCopia.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoEntrada));
             BufferedWriter bw = new BufferedWriter(new FileWriter(archivoSalida))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equalsIgnoreCase(linea)) {
                    bw.write(linea);
                    bw.newLine(); // Agrega una nueva línea después de cada línea que contiene la palabra buscada
                }
            }

            System.out.println("Se han escrito las líneas que contienen la palabra '" + palabraBuscar + "' en " + archivoSalida + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
