package FicheroTexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroTexto {
    public static void main(String[] args) {
        String nombreDelFichero = "saludo.txt";
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