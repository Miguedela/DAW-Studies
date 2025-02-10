import java.util.Scanner;

public class Ejercicio5 {
    /*Intercambiar un String dado, hasta volverlo a su forma original:
    Ejemplo: Hola, ahol, laho, olah, hola (stop).*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabra = s.nextLine();

        cambiarOreden(palabra);
    }

    //Creo el metodo (FUERA DEL MAIN)
    private static void cambiarOreden(String palabra) {
        char[] letras = new char[palabra.length()];
        char[] aux = new char[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = palabra.charAt(i);
        }

        for (int x = 0; x < palabra.length(); x++) {

            for (int i = 0; i < palabra.length(); i++) {
                if (x == 0) {
                    System.out.print(letras[i]);
                }
            }

            System.out.print("\t");

            for (int y = 0; y < palabra.length(); y++) {
                if (y == 0) {
                    aux[0] = letras[palabra.length() - 1];
                    letras[palabra.length() - 1] = letras[palabra.length() - 2];
                } else if (y == palabra.length() - 1) {
                    aux[palabra.length() - 1] = letras[palabra.length() - 2];
                } else {
                    aux[y] = letras[(y - 1)];
                }
            }

            for (int i = 0; i < palabra.length(); i++) {
                System.out.print(aux[i]);
            }

            System.out.print("\t");
            if (x == (palabra.length() - 1)) {
                System.out.print(" (acaba)");
            }
        }
    }
}