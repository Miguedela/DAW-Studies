import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza un programa que pinte la letra U por pantalla hecha con asteriscos. El
    programa pedirá la altura. Fíjate que el programa inserta un espacio y pinta
    dos asteriscos menos en la base para simular la curvatura de las esquinas
    inferiores.
    Ejemplo:
    Introduzca la altura de la U: 5
    *     *
    *     *
    *     *
    *     *
     * * *  */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicio las variables

        do { // bucle do que se realiza hasta que se deje de cumplir lo del bucle while
            System.out.print("Introduce la altura: "); // muestro por pantalla que debe de hacer el usuario
            altura = s.nextInt(); // guardo en una variable lo que se ha introducido por teclado

            System.out.println("La altura debe ser al menos 3 para que la letra U sea visible."); // muestra por pantalla un mensaje de que se vuelva a introducir un número
        } while (altura < 3); // condicion de while

        for (int y = 1; y <= altura; y++) { // bucle for que se repite tantas veces como tenga de altura (simula el eje y)
            for (int x = 1; x <= altura; x++) { // bucle for que se repite tantas veces como tenga de anchura (simula el eje x)
                if (y == altura) { // if que dibuja la ultima linea
                        if ((x == 1) || (x == altura)) {
                            System.out.print(" ");
                        } else {
                            System.out.print("*");
                        }
                } else if ((x == 1) || (x == altura)) { // if que dibuja los palos verticales de la U
                    System.out.print("*");
                } else { // else que dibuja los espacios de la U
                    System.out.print(" ");
                }
            }
            System.out.println(); // print que dibuja los saltos de linea
        }

    }
}