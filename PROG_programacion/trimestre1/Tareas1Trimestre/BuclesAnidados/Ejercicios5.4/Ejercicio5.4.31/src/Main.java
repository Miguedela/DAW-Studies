import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza un programa que pinte la letra L por pantalla hecha con asteriscos. El
    programa pedirá la altura. El palo horizontal de la L tendrá una longitud de la
    mitad (división entera entre 2) de la altura más uno.
    Ejemplo:
    Introduzca la altura de la L: 5
    *
    *
    *
    *
    * * **/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicio las variables

        do { // bucle do que se realiza hasta que se deje de cumplir lo del bucle while
            System.out.print("Introduce la altura: "); // muestro por pantalla que debe de hacer el usuario
            altura = s.nextInt(); // guardo en una variable lo que se ha introducido por teclado

            System.out.println("La altura debe ser al menos 2 para que la letra L sea visible."); // muestra por pantalla un mensaje de que se vuelva a introducir un número
        } while (altura < 2); // condicion de while

        for (int y = 1; y <= altura; y++) { // bucle for que se repite tantas veces como tenga de altura (simula el eje y)
            for (int x = 1; x <= altura / 2 + 1; x++) { // bucle for que se repite tantas veces como tenga de anchura (simula el eje x, la ultima linea)
                if (x == 1 || (y == altura)) { // if que dibuja los asteriscos
                    System.out.print(" * ");
                } else { // else que dibuja los espacios
                    System.out.print(" ");
                }
            }
            System.out.println(); // print que dibuja los saltos de linea
        }


    }
}