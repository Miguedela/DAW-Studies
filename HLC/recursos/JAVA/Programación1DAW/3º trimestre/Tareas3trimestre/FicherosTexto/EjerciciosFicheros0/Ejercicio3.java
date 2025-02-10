package FicherosTexto.EjerciciosFicheros0;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        String nombreDelFichero = "datos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(nombreDelFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
