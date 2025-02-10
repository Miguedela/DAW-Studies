package BoletinString;

public class Ejercicio1 {
    /*Programa que imprime una palabra o frase fila por fila*/
    public static void main(String[] args) {

        //Declaro la variable de la palabra
        String palabra = "Hola que tal estas";
        //Llamo al metodo (DENTRO DEL MAIN)
        imprimirPorFila(palabra);
    }

    //Creo el metodo (FUERA DEL MAIN)
    private static void imprimirPorFila(String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            //Creo una variable char en la cual guardo palabra por palabra
            char letra = palabra.charAt(i);
            //Print que escribe las palabras guardadas
            System.out.println(letra);
        }
    }
}