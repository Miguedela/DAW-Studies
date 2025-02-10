//Importo la utilidad de Java
import java.util.*;
public class Main {
    /*Tenemos la siguiente clase:
            import java.util.*;
    public class Test {
        public static void main(String[] args) {
            Random rnd = new Random();
            int valor = rnd.nextInt();
        }
    }
    Modifica el programa para que “valor” sea un número entre [100-200] y muestre
    por pantalla si los valores generados son par o impar. El programa termina cuando
    aparezca un 0.*/
    public static void main(String[] args) {

        //Esta linea la he dejado igual que en el ejemplo
        Random rnd = new Random();
        //El unico cambio que he efectuado aquí es que he introducido la orquilla de valores de los números randoms
        int valor = rnd.nextInt(100, 200);

        //Bucle que se repite hasta que el valor sea '0'
        do {

            //Pido que me muestre por pantalla el número random generado
            System.out.println("El número generado entre (100-200) es: " + valor);

            //if que realiza la operacion para que diga si es par o impar
            if (valor % 2 == 0) {
                System.out.println("El número es par");
            } else {
                System.out.println("El número es inpar");
            }

            //Vuelvo a generar un ´numero aleatorio entre 0 y 100
            valor = rnd.nextInt(100, 200);

        //Pido al bucle que se repita hasta que el número sea igual a 100
        } while (valor != 100);
    }
}