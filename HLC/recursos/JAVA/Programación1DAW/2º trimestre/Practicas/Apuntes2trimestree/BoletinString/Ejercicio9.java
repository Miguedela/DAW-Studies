package BoletinString;

import java.util.Scanner;

public class Ejercicio9 {
    /*9) Realizar un clase que lea una cadena de caracteres, la imprima invertida.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce la frase que desea mostrar inversa: ");
        String palabra = s.nextLine();

        System.out.println("La frase original es: " + palabra);
        //Llamo al metodo (DENTRO DEL MAIN)
        System.out.print("La frase invertida es: " + invertir(palabra));
        s.close();
    }

    //Creo el metodo (FUERA DEL MAIN)
    /*private static void imprimirPorFila(String palabra) {
        for (int i = palabra.length(); i > 0; i--) {
            //Creo una variable char en la cual guardo palabra por palabra
            char letra = palabra.charAt(i-1);
            //Print que escribe las palabras guardadas
            System.out.print(letra);
        }
    }*/

    private static String invertir(String palabra) {
        StringBuilder resultado = new StringBuilder(palabra);
        resultado.reverse();
        return resultado.toString();
    }
}
