import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicio las variables
        int aux = 0;
        int cantidadast = 0;

        do { // bucle do que se realiza hasta que se deje de cumplir lo del bucle while
            System.out.print("Introduce la altura: "); // muestro por pantalla que debe de hacer el usuario
            altura = s.nextInt(); // guardo en una variable lo que se ha introducido por teclado

            System.out.println("La altura debe de ser impar para poder hacer la x."); // muestra por pantalla un mensaje de que se vuelva a introducir un número
        } while (altura % 2 == 0); // condicion de while

        aux = altura; // variable uxiliar que la igualo a altura mas uno para poder dibujar el otro palo vertical

        for (int y = 1; y <= altura; y++) { // bucle for que se repite tantas veces como tenga de altura (simula el eje y)

            aux -= 1 ; // cada vez que entro en el bucle le resto uno a la variable auxiliar

            for (int x = 1; x <= altura; x++) { // bucle for que se repite tantas veces como tenga de anchura (simula el eje x)

                if (x == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                if (x == y - altura/2 || x == aux - 1) { // if que se encarga de dibujar los asteriscos
                    System.out.print("*"); // print que dibuja los asteriscos
                } else { // else encargado de dibujar los asteriscos
                    System.out.print(" "); // print que dibuja los espacios
                }

            }
            System.out.println(); // print que dibuja los saltos de linea
        }
    }
}