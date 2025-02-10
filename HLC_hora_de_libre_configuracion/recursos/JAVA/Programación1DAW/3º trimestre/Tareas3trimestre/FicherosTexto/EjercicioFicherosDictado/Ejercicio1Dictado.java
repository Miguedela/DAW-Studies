package FicherosTexto.EjercicioFicherosDictado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/* Escribe un programa en java que cree un archivo numero.txt y escriba los números del 1-10 línea por línea */

public class Ejercicio1Dictado {
    public static void main(String[] args) {
        String nombreDelFichero = "saludo.txt";
        int aux = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreDelFichero, false))) {
            for (int i = 1; i <= 10; i++) {
                aux = aux + i;
                bw.write(String.valueOf(i) + "\t" + String.valueOf(aux));
                bw.newLine(); // Agrega una nueva línea después del contenido
            }
            bw.close();
            System.out.println("Contenido escrito correctamente");
            bw.newLine(); // Agrega una nueva línea después del contenido
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
