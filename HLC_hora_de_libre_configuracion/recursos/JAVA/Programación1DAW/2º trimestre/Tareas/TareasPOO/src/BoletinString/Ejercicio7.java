package BoletinString;

import java.util.Scanner;

public class Ejercicio7 {
    /*7) Verificar si en una frase se encuentra una determinada palabra.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parrafo = "Lorem fistrum jarl pecador me cago en tus muelas. No te digo trigo por no llamarte Rodrigor caballo blanco caballo negroorl diodenoo ese pedazo de apetecan está la cosa muy malar ese que llega hasta luego Lucas.";

        System.out.print("Introduce la palabra que deseas buscar: ");
        String palabraBuscada = scanner.next();

        //Transformo todo a minuscilas
        parrafo = parrafo.toLowerCase();
        palabraBuscada = palabraBuscada.toLowerCase();

        int buscarPosicion = parrafo.indexOf(palabraBuscada);

        if (buscarPosicion < 0) {
            System.out.println("La palabra \"" + palabraBuscada + "\" no se encuentra en la frase.");
        } else {
            System.out.println("La palabra \"" + palabraBuscada + "\" se encuentra en la frase, y empieza en la posición: " + (buscarPosicion));
        }
    }
}