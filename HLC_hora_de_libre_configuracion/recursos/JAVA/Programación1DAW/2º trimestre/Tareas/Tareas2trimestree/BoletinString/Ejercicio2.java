package BoletinString;

//Importo las utilidades

import java.util.Scanner;

public class Ejercicio2 {
    /*Cambiar todas las vocales que hay en una frase por una vocal que se pida por teclado*/
    public static void main(String[] args) {
        //Creo un objeto para la utilidad Scanner
        Scanner s = new Scanner(System.in);
        
        String frase = "Mi moto alpina derrapante";
        
        System.out.print("Introduzcla la vocal por la que desea sustituir: ");
        String vocalCambiar = s.nextLine();
        
        //Llamo al metodo (DENTRO DEL MAIN)a
        String fraseNueva = cambiarVocales(frase, vocalCambiar);
        
        System.out.println("La antigua frase era: \t" + frase);
        System.out.println("La nueva frase es: \t\t" + fraseNueva);
        
        s.close();
    }

    //Creo el metodo (FUERA DEL MAIN)
    public static String cambiarVocales(String frase, String vocalCambiar) {

        frase = frase.replace('a', vocalCambiar.charAt(0));
        frase = frase.replace('e', vocalCambiar.charAt(0));
        frase = frase.replace('i', vocalCambiar.charAt(0));
        frase = frase.replace('o', vocalCambiar.charAt(0));
        frase = frase.replace('u', vocalCambiar.charAt(0));

        return frase;
    }
}

