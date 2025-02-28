import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza un programa que vaya pidiendo números hasta que se introduzca un
    numero negativo y nos diga cuantos números se han introducido, la media de
    los impares y el mayor de los pares. El número negativo sólo se utiliza para
    indicar el final de la introducción de datos pero no se incluye en el cómputo.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numero = 0; // inicio las variables
        int cantnum = 0;
        int numimpar = 0;
        int numeroim = 0;
        int media = 0;
        int nummayot = 0;

        do { // bucle do que se repite hasta que la condicion de while se deje de cumplir
            System.out.print("Introduce un número negativo: "); // pido por pantalla que se debe de hacer
            numero = s.nextInt(); // guardo lo que se introduce por teclado en una variable

            if (numero%2 != 0){ // guarda los numeros inmpares para proximamente poder realizar su media
                numeroim = numeroim + numero;
                numimpar++;
            } else { // guarda el número mayor solo de los pares
                if (numero>nummayot) {
                    nummayot = numero;
                }
            }

            cantnum++; // suma uno cada vez que se rehace el bucle para saber el número de intentos realizados
        } while (numero >= 0); // condicion del while

        media = numeroim / numimpar; // calculo de la media de los números impares

        System.out.println("El número de intentos para introducir un número negativo ha sido de: " + cantnum); // mostrar por pantalla los resultados
        System.out.println("La media de los números impares es de: " + media);
        System.out.println("El número par más grande es: " + nummayot);

    }
}