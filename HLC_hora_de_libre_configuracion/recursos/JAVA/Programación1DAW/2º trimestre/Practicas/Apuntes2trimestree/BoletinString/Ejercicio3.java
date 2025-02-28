package BoletinString;

public class Ejercicio3 {
    /*Contar cuantas palabras tiene una frase (recuerde que en la gramatica la frase termina en un '.')*/
    public static void main(String[] args) {
        String frase = "Hola que tal.";

        //Igualo una variable del main al metodo
        int nPalabras = contarPalabra(frase);

        System.out.println("La frase cuenta con " + nPalabras + " palabras");
    }

    //Creo el metodo
    public static int contarPalabra(String frase) {
        if (frase.endsWith(".")) {
            frase = frase.substring(0, frase.length() - 1);

            String[] fraseBidimensional = frase.split(" ");

            return fraseBidimensional.length;
        } else {
            System.out.println("!Recuerda que las frases deben de finalizar con un '.'¡");
            return -1;
        }
    }
}