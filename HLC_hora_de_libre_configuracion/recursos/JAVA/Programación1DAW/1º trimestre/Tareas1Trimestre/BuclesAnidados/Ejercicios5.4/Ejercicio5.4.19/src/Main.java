import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza un programa que pinte una pirámide por pantalla. La altura se debe
    pedir por teclado. El carácter con el que se pinta la pirámide también se debe
    pedir por teclado.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        System.out.print("Introduce la altura deseada para la piramide: "); // muestro por pantalla lo que se debe de hacer
        int altura = s.nextInt(); // pido que se introduzca por teclado el número necesario

        System.out.print("Introduce el caracter con el que quieres que se pinte la piramide: "); // muestro por pantalla lo que se debe de hacer
        String caracter = s.next(); // pido que se introduzca por teclado el número necesario

        for (int i = 1; i <= altura; i++) { // for que se repite tantas veces como numero de altura se ha introducido

            for (int x = 1; x <= i; x++) { // bucle for que se ayuda de la variable i para introducir el número de caracteres
                System.out.print(caracter); // print que se encarga de mostrar en pantalla los caracteres
            }

            System.out.println(); // print encargado de dar enter
        }
    }
}