import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {
    /*Ejemplo_3 Completar el ejercicio anterior añadiendo otro filtro con la terminación del nombre. Si
    se introduce el texto vacío ignorar el filtro.*/
    public static void main(String[] args) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        String[] cadenas = new String[r.nextInt(3,6)];

        for (int i = 0; i < cadenas.length; i++) {
            System.out.print("Introduce la cadena de caracteres número " + (i+1) + ": ");
            cadenas[i] = s.next();
        }

        System.out.println("Introduce la letra de inicializacion");
        String buscadorinic = s.next();
        System.out.println("Introduce la letra de finalizacion");
        String buscadorfin = s.next();

        for (int i = 0; i < cadenas.length; i++) {
            if (cadenas[i].equals("")) {
            } else {
                if (cadenas[i].startsWith(buscadorinic) && cadenas[i].endsWith(buscadorfin)) {
                    System.out.println(cadenas[i]);
                }
            }
        }
    }
}
