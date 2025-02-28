import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Escribe un programa que pida dos números por teclado y que luego mezcle en
    dos números diferentes los dígitos pares y los impares. Se van comprobando
    los dígitos de la siguiente manera: primer dígito del primer número, primer
    dígito del segundo número, segundo dígito del primer número, segundo
    dígito del segundo número, tercer dígito del primer número... Para facilitar
    el ejercicio, podemos suponer que el usuario introducirá dos números de la
    misma longitud y que siempre habrá al menos un dígito par y uno impar. Usa
    long en lugar de int donde sea necesario para admitir números largos.

    Ejemplo 1:
    Por favor, introduzca un número: 9402
    Introduzca otro número: 6782
    El número formado por los dígitos pares es 640822
    El número formado por los dígitos impares es 97

    Ejemplo 2:
    Por favor, introduzca un número: 137
    Introduzca otro número: 909
    El número formado por los dígitos pares es 0
    El número formado por los dígitos impares es 19379*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        String numero1; // inicio las variables de los números que se van a introducir por teclado
        String numero2;

        do { // bucle do que se repite tantas veces sea necesaria

            System.out.print("Introduce el primer número: "); // muestro por pantalla al usuario que debe de hacer
            numero1 = s.next(); // guardo en una variable lo que se ha introducido por teclado

            System.out.print("Introduce el segundo número: "); // muestro por pantalla al usuario que debe de hacer
            numero2 = s.next();; // guardo en una variable lo que se ha introducido por teclado

        } while (numero1.length() != numero2.length()); // condición del bucle do-while (que se repita hasta que la longitud no sea la misma)

        int size = numero1.length(); // creo una variable size que la igualo a la longitud de los numeros

        int[] parx = new int[size]; // inicio los arrays de los números pares e impares tanto para el primer número como para el segundo
        int[] imparx = new int[size];
        int[] pary = new int[size];
        int[] impary = new int[size];

        for (int i = 0; i < size; i++) { // bucle for que se repite tantas veces como longitud tengan los números introducidos

            int x = Character.getNumericValue(numero1.charAt(i)); // cambio el tipo de variable de los números
            int y = Character.getNumericValue(numero2.charAt(i)); // cambio el tipo de variable de los números

            if (x % 2 == 0) { // if que compara los números (x) para determinar si son pares o impares, seguido de eso se manda a una variable
                parx[i] = x; // igualo cada posicion del array a su respectiva variable
            } else {
                imparx[i] = x; // igualo cada posicion del array a su respectiva variable
            }

            if (y % 2 == 0) { // if que compara los números (y) para determinar si son pares o impares, seguido de eso se manda a una variable
                pary[i] = y; // igualo cada posicion del array a su respectiva variable
            } else {
                impary[i] = y; // igualo cada posicion del array a su respectiva variable
            }
        }


        // Todo lo que esta justo debajo de este texto, sirve para mostrar por pantalla el resultado
        System.out.print("Las cifras pares son:"); // muestro por pantalla texto para saber de que tipo de número estamos hablando

        for (int x = 0; x < size; x++) { // bucle for que escribe por pantalla los números pares de x

            if (parx[x] != 0) { // if que tiene la condicion que si es 0 no se muestre en pantalla
                System.out.print(" " + parx[x]); // print que muestra el resutlado
            }

        }

        for (int x = 0; x < size; x++) { // bucle for que escribe por pantalla los números pares de y

            if (pary[x] != 0) { // if que tiene la condicion que si es 0 no se muestre en pantalla
                System.out.print(" " + pary[x]); // print que muestra el resutlado
            }

        }

        System.out.println(); // salto de línea para diferenciar pares e impares

        System.out.print("Las cifras impares son:"); // muestro por pantalla texto para saber de que tipo de número estamos hablando

        for (int x = 0; x < size; x++) { // bucle for que escribe por pantalla los números impares de x

            if (imparx[x] != 0) { // if que tiene la condicion que si es 0 no se muestre en pantalla
                System.out.print(" " + imparx[x]); // print que muestra el resutlado
            }
        }

        for (int x = 0; x < size; x++) { // bucle for que escribe por pantalla los números impares de y

            if (impary[x] != 0) { // if que tiene la condicion que si es 0 no se muestre en pantalla
                System.out.print(" " + impary[x]); // print que muestra el resutlado
            }

        }
    }
}
