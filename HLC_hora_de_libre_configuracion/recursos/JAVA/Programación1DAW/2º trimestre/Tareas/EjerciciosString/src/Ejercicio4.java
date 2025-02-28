import java.util.Scanner;

public class Ejercicio4 {
    /*Verificar si un String leído por teclado finaliza con la misma palabra que empieza.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Introduce una frase por teclado: ");
        String frase = s.nextLine();

        sacarPalabra(frase);
    }

    //Creo el metodo
    public static void sacarPalabra(String frase) {
        frase = frase.substring(0, frase.length());

        String[] fraseBidimensional = frase.split(" ");

        if (fraseBidimensional[0].equals(fraseBidimensional[fraseBidimensional.length - 1])) {
            System.out.println("La frase empieza y acaba por la misma palabra.");
        } else {
            System.out.println("La frase no empieza y acaba por la misma palabra.");
        }
    }
}
