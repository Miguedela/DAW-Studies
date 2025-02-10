import java.util.Scanner; // implemento la utilidad Scanner
public class Ejercicio7_4_6 {
    /*Escribe un programa que lea 15 números por teclado y que los almacene en un
    array. Rota los elementos de ese array, es decir, el elemento de la posición 0
    debe pasar a la posición 1, el de la 1 a la 2, etc. El número que se encuentra en
    la última posición debe pasar a la posición 0. Finalmente, muestra el contenido
    del array.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] numero = new int[15]; // creo una array con 15 posiciones
        int[] numeroaux = new int[15]; // creo una array con 15 posiciones

        for (int i = 0; i < numero.length; i++) { // bucle for que sirve para leer un número en cada respectiva posición del array
            System.out.print("Introduce el número " + (i+1) + " por favor: "); // muestro por pantalla que debe de hacer el usuario
            numero[i] = s.nextInt(); // igualo cada posicion del array a un número introducido por teclado

            numeroaux[i] = numero[i]; // igualo la cada posicion de numero a su array auxiliar
        }

        for (int i = 0; i < numero.length; i++) { // bucle for que sirve para leer un número en cada respectiva posición del array
            System.out.println(numero[i+1] + " ");
        }

        for (int i = 0; i < numero.length; i++) { // bucle for que sirve para leer un número en cada respectiva posición del array

            if (i < 14) {
                numeroaux[i+1] = numero[i];
            } else {
                numeroaux[0] = numero[14];
            }

        }

        System.out.print("Contenido de array 'numero': ");
        for (int i = 0; i < numero.length; i++) { // bucle for que sirve para leer un número en cada respectiva posición del array
            System.out.print(numero[i] + " ");
        }

        System.out.println();

        System.out.print("Contenido de array 'numeroaux': ");
        for (int i = 0; i < numero.length; i++) { // bucle for que sirve para leer un número en cada respectiva posición del array
            System.out.print(numeroaux[i] + " ");
        }
    }
}