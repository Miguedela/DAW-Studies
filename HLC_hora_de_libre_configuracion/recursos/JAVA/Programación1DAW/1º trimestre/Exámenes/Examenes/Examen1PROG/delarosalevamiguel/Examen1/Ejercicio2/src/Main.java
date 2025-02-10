import java.util.Scanner; // inicio la utilidad Scanner
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int altura = 0; // inicio las variables
        int numast = 0;
        int saltolinea = 10;

        do { // bucle do-while que pide la altura

            System.out.print("Ingrese la altura de la figura: ");
            altura = s.nextInt();

            if ((altura < 3) || (altura % 2 == 0)) { // condicion if que rechaza la altura en caso de ser erronea
                System.out.println("No se admiten alturas menores a 3 ni alturas pares.");
                System.out.print("Ingrese la altura de la figura: ");
            }
        } while ((altura < 3) || (altura%2 == 0)); // condicion del bucle do-while que hasta cuando deberia de repetirse el bucle

        for (int y = 1; y <= altura; y++) { // bucle for que simula el eje y
            for (int x = 1; x <= altura; x++) { // bucle for que simula el eje x

                if ((x == y) || (y == 1) || (x == altura) || (y == altura) && (x == altura-1)) { // if que se encarga de dibujar los asteriscos
                    System.out.print("*"); // print que dibuja los asteriscos
                    numast++; // cada vez que pinto un asterisco le sumo uno a la variable acumulativa
                } else { // else encargado de dibujar los espacios
                    System.out.print(" "); // print que dibuja los espacios
                }

            }
            System.out.println(); // print que dibuja los saltos de línea
        }
        System.out.println("La cantidad de asteriscos usados es de: " + numast); // Muestro por pantalla el número de asteriscos usados

        System.out.println("Pintados quedan:"); // sout que indica que se va a escribir a continuacion

        for (int i = 1; i <= numast; i++) { // bucle for que pinta el número de asteriscos empleados
            System.out.print("*"); // print que dibuja los asteriscos
            if ((i == saltolinea)) { // if que se cumple cuando i vale lo mismo que la variable de salto de linea
                System.out.println(); // print que da salto de linea
                saltolinea += 10; // le sumo 10 a la variable acumulatiba de salto de linea nuevamente
            }
        }
    }
}