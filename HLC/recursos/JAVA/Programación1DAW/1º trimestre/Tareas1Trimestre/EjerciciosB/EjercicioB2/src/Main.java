//Importo la utilidad de Scanner
import java.util.Scanner;
public class Main {
    /*Ejercicio 2 - Desarrolla un programa donde introduzcamos dos números, uno para la
    base y otro para el exponente (ambos enteros). Saca por pantalla el resultado de la
    operación potencia. No podemos utilizar el operador potencia (‘^’).*/
    public static void main(String[] args) {
        //Creo una variable para Scanner
        Scanner s = new Scanner(System.in);

        //Introduce la base
        System.out.println("Introduce la base");
        int base = s.nextInt();
        //Introduce el exponente
        System.out.println("Introduce el exponente");
        int exp = s.nextInt();

        //Creo una variable auxiliar de la base
        int aux = base;

        //for que se repite tantas veces como se desea elevar el número
        for (int i = 1; i <= (exp -1); i++) {
            //Calculo el numero elevado
            base = base * aux;
        }
        //Muestro por pantalla el resultado
        System.out.println(base);
    }
}