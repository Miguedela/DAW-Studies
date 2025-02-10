import java.util.Scanner;

public class Ejercicio1 {
    //Ejemplo_1 Leer dos cadenas de texto e imprimir la mayor de ellas y su longitud.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String cadena1;
        String cadena2;

        System.out.print("Introduce la primera cadena de caracteres: ");
        cadena1 = s.next();
        System.out.print("Introduce la segunda cadena de caracteres: ");
        cadena2 = s.next();

        if (cadena1.length() > cadena2.length()) {
            System.out.println(cadena1 + " contiene " + cadena1.length() + " caracteres.");
        } else {
            System.out.println(cadena2 + " contiene " + cadena2.length() + " caracteres.");
        }
    }
}