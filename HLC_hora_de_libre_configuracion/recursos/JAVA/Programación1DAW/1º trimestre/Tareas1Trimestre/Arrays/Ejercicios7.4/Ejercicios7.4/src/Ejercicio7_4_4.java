import java.util.Random; // implemento la utilidad de Random
public class Ejercicio7_4_4 {
    /*Define tres arrays de 20 números enteros cada una, con nombres numero,
    cuadrado y cubo. Carga el array numero con valores aleatorios entre 0 y 100. En el
    array cuadrado se deben almacenar los cuadrados de los valores que hay en el
    array numero. En el array cubo se deben almacenar los cubos de los valores que
    hay en numero. A continuación, muestra el contenido de los tres arrays dispuesto
    en tres columnas.*/
    public static void main(String[] args) {
        Random r = new Random(); // creo la variable Random para poder generarlos

        int[] numero = new int[20]; // inicio los arrays con 20 posiciones cada uno
        int[] cuadrado = new int[20];
        int[] cubo = new int[20];

        for (int i = 0; i < numero.length; i++) { // bucle for que sirve para leer un número en cada respectiva posición del array
            numero[i] = r.nextInt(0, 100); // igualo cada posicion del array a un número random entre 0 y 100

            cuadrado[i] = numero[i] * numero[i]; // calculo el cuadrado de numero[i]
            cubo[i] = numero[i] * numero[i] * numero[i]; // calculo el cubo de numero[i]
        }

        System.out.println("  Número" + "\tCuadrado:" + "\t\tCubo"); // muestro por pantalla que tipo de número se va a mostrar
        System.out.println("-----------------------------------"); // print que contiene una linea por simple estetica

        for (int i = 0; i < numero.length; i++) { // bucle for que se repite tantas veces como cantidad de posiciones haya en el array numero
            System.out.println("  " + numero[i] + " \t\t" + cuadrado[i] + "  \t\t\t" + cubo[i]); // muestro por pantalla tanto el número, cudarado y cubo
        }
    }
}