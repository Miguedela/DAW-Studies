package FicherosTexto.EjerciciosFicheros1.Corregidos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4Corregido {
    public static void main(String[] args) {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("saludo.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas.add(linea); // Añado la linea al ArrayList
            }
        } catch (Exception e) {
            System.out.println("Ocurrio error en el archivo saludo.txt" + e.getMessage());
            return;
        }

        try {
            Scanner s = new Scanner(System.in);

            System.out.print("Ingresa la palabra que desea buscar: ");
            String buscador = s.nextLine();

            s.close();
            
            int posicionLinea = 1;

            for (String string : lineas) {
                if (string.contains(buscador)) {
                    System.out.println(buscador + " encontrado en la linea " + posicionLinea);
                }
                
                posicionLinea++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
