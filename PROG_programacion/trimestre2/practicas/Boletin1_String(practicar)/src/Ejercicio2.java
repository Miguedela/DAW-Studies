import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {
    /*Ejemplo_2 Crear un array con muchos nombres, pedir un texto como filtro y mostrar todos los
    nombres que empiecen por ese texto.*/
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        String[] cadenas = new String[r.nextInt(3, 6)];

        for (int i = 0; i < cadenas.length; i++) {
            System.out.print("Introduce la cadena de caracteres número " + (i+1) + ": ");
            cadenas[i] = s.next();
        }

        System.out.println("Introduce la letra de inicializacion");
        String buscador = s.next();

        for (int i = 0; i < cadenas.length; i++) {
            if (cadenas[i].startsWith(buscador)) {
                System.out.println(cadenas[i]);
            }
        }
    }
}
