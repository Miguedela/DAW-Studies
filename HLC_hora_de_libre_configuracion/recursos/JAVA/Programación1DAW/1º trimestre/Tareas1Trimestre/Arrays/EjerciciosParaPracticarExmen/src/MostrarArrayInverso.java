import java.util.Scanner;

public class MostrarArrayInverso {
    /*Escribe un programa que lea 10 números por teclado y que luego los muestre
    en orden inverso, es decir, el primero que se introduce es el último en
    mostrarse y viceversa.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int[] numeros = new int[10]; // creo una array con 10 posiciones

        for (int i = 0; i < numeros.length; i++) { // bucle for que sirve para leer un número en cada respectiva posición del array
            System.out.print("Introduce el número " + (i+1) + " por favor: "); // muestro por pantalla que debe de hacer el usuario
            numeros[i] = s.nextInt(); // igualo cada posicion del array a un número introducido por teclado
        }

        System.out.println(); // print que sirve de salto de line

        System.out.print("El número al reves sería:"); // muestro por pantalla lo que se va a escribir a continuacion (los números en orden inverso)

        for (int i = numeros.length-1; i >= 0; i--) { // bucle for invertido que sirve para mostrar por pantalla el número al reves
            System.out.print(" " + numeros[i]); // muestro por pantalla cada posiocion del array (a la inversa)
        }
    }
}
