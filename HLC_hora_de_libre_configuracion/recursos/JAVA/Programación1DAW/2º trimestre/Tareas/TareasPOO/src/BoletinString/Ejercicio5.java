package BoletinString;

import java.util.Scanner;

public class Ejercicio5 {
    /*Intercambiar un String dado, hasta volverlo a su forma original:
        Ejemplo: Hola, ahol, laho, olah, hola (stop).*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce una palabra: ");
        String palabra = s.nextLine();

        rotaOriginal(palabra);
    }

    //Creo el metodo (FUERA DEL MAIN)
    /*private static void cambiarOreden(String palabra) {
        System.out.print(palabra);

        for (int i = 0; i < palabra.length(); i++) {
            palabra = palabra.charAt(palabra.length() - 1) + palabra.substring(0, palabra.length() - 1);
            System.out.print(palabra + " ");
        }
    }*/

    private static void rotaOriginal(String palabra) {
        System.out.print(palabra + "\t");

        String cadenaRotada = palabra;
        do {
          cadenaRotada = rota(cadenaRotada);
            System.out.println(cadenaRotada + "  ");
        } while (!cadenaRotada.equals(palabra));
    }

    private static String rota(String palabra) {
        char ultimaLetra = palabra.charAt(palabra.length()-1);
        return ultimaLetra + palabra.substring(0, palabra.length()-1);
    }
}