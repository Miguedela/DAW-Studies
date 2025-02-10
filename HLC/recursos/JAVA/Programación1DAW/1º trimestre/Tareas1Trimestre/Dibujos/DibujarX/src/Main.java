import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicio las variables
        int cantidadast = 0;

        do { // bucle do que se realiza hasta que se deje de cumplir lo del bucle while
            System.out.print("Introduce la altura: "); // muestro por pantalla que debe de hacer el usuario
            altura = s.nextInt(); // guardo en una variable lo que se ha introducido por teclado

            System.out.println("La altura debe de ser impar para poder hacer la x."); // muestra por pantalla un mensaje de que se vuelva a introducir un número
        } while (altura % 2 == 0); // condicion de while

        for (int y = 1; y <= altura; y++) { // bucle for que se repite tantas veces como tenga de altura (simula el eje y)

            for (int x = 1; x <= altura; x++) { // bucle for que se repite tantas veces como tenga de anchura (simula el eje x)

                if (x == y || x + y == altura + 1) { // if que se encarga de dibujar los asteriscos
                    System.out.print("*"); // print que dibuja los asteriscos
                    cantidadast++; // suma uno a la cariable "cantidadast" cada vez que se dibuja un asterisco
                } else { // else encargado de dibujar los asteriscos
                    System.out.print(" "); // print que dibuja los espacios
                }

            }

            System.out.println(); // print que dibuja los saltos de línea
        }

        System.out.println("La cantidad de asteriscos utilizados ha sido de: " + cantidadast); // muestro por pantalla la cantidad de astericos empleados en el dibujo

    }
}