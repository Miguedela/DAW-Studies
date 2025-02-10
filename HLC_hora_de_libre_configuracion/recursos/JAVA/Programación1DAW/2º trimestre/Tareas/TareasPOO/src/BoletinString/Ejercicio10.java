package BoletinString;

import java.util.Scanner;

public class Ejercicio10 {
    /*10) Escribir un programa que lea por teclado un nombre (con sus apellidos) y escriba en pantalla las
    iniciales de dicho nombre.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce tu nombre y apellidos: ");
        String nombreApellido = s.nextLine();

        primeraInicial(nombreApellido);
    }

    public static void primeraInicial(String nombreApellido) {
        String[] split = nombreApellido.split(" ");

        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i].charAt(0) + " ");
        }
    }
}
