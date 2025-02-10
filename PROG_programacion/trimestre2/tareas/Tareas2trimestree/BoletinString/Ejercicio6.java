package BoletinString;

import java.util.Scanner;

public class Ejercicio6 {
    /*6) Dado un párrafo con dos frases (separadas por un punto), contar cuántas palabras tiene cada frase.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Introduce varias frases separadas por '.', y contaré cuantas palabras tienen cada una: ");
        String parrafo = s.nextLine();

        String[] frases = parrafo.split("\\."); // Dividir el párrafo en frases

        for (int i = 0; i < frases.length; i++) {
            String frase = frases[i];
            System.out.println("La frase " + (i+1) + " tiene un total de " + contarPalabras(frase) + " palabras");
        }
        s.close();
    }

    public static int contarPalabras(String mullao) {
        mullao = mullao.trim(); // Eliminar posibles espacios en blanco al inicio o final de la frase
        String[] locura = mullao.split(" "); // Dividir la frase por espacios en blanco
        return locura.length;
    }
}