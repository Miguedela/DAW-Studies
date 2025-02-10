import java.util.Scanner; // importo la utilidad de Scanner
public class Main {
    /*Realiza un programa que sume los 100 números siguientes a un número entero
    y positivo introducido por teclado. Se debe comprobar que el dato introducido
    es correcto (que es un número positivo).*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // creo la variable Scanner

        int numero = 0; // inicio las variables
        int suma = 0;

        do { // bucle do-while que se rhace mientras el número introducido no sea positivo
            System.out.print("Introduce un número positivo: "); // muestro por pantalla lo que se debe introducir
            numero = s.nextInt(); // pido que se introduzca un número por teclado
        } while (numero < 0);

        for (int i = numero + 1; i <= (numero+100); i++) { // bucle for que se repite 100 veces para poder sumar los 100 siguientes números
            suma = suma + i; // variable suma acumulatiba de las 100 repeticiones del bucle
        }

        System.out.println("Después de sumar el número introducido con los 100 siguientes números el resultado es: " + suma); // mostar resultado de la suma
    }
}