package FicherosTexto.BoletínFicheros2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    // Metodo para crear un fichero de texto con contenido
    public static void escribirElArchivo(String rutaFichero, String matricula, String marca, double tamanoDeposito, String modelo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFichero, true))) {
            bw.write(matricula + "," + marca + "," + tamanoDeposito + "," + modelo);
            System.out.println("Contenido escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nFichero = "coches.txt";

        String matricula;
        String marca;
        double tamañoDeposito = 0;
        String modelo;

        System.out.print("Introduce la matrícula: ");
        matricula = s.nextLine();
        System.out.print("Introduce la marca: ");
        marca = s.nextLine();
        System.out.print("Introduce el tamañoDeposito: ");
        tamañoDeposito = s.nextDouble();
        s.nextLine();
        System.out.print("Introduce el modelo: ");
        modelo = s.nextLine();
        s.close();

        escribirElArchivo(nFichero, matricula, marca, tamañoDeposito, modelo);
    }
}
