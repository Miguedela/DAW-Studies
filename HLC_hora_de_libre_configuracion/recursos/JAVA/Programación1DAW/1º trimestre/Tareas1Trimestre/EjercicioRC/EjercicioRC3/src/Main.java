//Importo la utilidad de Scanner
import java.util.Scanner;
public class Main {
    /*3. Escribir un programa que pida ingresar coordenadas (x,y) que representan puntos
    en el plano.
    Informar cuántos puntos se han ingresado en el primer, segundo, tercer y cuarto
    cuadrante. Al comenzar el programa se pide que se ingrese la cantidad de puntos
    a procesar.*/
    public static void main(String[] args) {
        //Creo la variable de Scanner
        Scanner s = new Scanner(System.in);

        //Inicializacion de variables
        int rep = 0;
        double coox = 0;
        double cooy = 0;

        //Introducir el número de puntos que se desea procesar
        System.out.println("¿Cuántos puntos desea procesar?");
        rep = s.nextInt();

        //for que se repite tantas veces como queramos
        for (int i = 1; i <= rep; i++) {
            //Leer las coordenadas
            System.out.print("Introduce la coordenada de x: ");
            coox = s.nextInt();
            System.out.print("Introduce la coordenada de y: ");
            cooy = s.nextInt();

            //Muestra por pantalla a que cuadrante pertenece
            if (coox > 0 && cooy > 0) {
                System.out.println("Pertenece al primer cuadrante debido a que ambos números son positivos");
            } else if ((coox < 0) && (cooy > 0)) {
                System.out.println("Pertenece al segundo cuadrante debido a que x es negativo e y positivo");
            } else if ((coox > 0) && (cooy < 0)) {
                System.out.println("Pertenece al cuarto cuadrante debido a que x es positivo e y es negativo");
            } else if ((coox < 0) && (cooy < 0)) {
                System.out.println("Pertenece al tercer cuadrante debido a que ambos números son negativos");
            }
        }
    }
}