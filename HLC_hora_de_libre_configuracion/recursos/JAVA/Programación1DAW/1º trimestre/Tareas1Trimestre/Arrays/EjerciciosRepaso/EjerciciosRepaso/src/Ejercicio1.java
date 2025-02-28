import java.util.Random;

public class Ejercicio1 {
    /*Array de 50 posiciones de número aleatorios que van desde -1492 a 1898.*/
    public static void main(String[] args) {
        Random r = new Random();

        int[] numeros = new int[50];

        //Bucle for quele da valor a las 50 posiciones del array
        for (int i = 0; i < 50; i++) {
            numeros[i] = r.nextInt(-1492, 1898);
        }

        //Bucle for que muestra las 50 posiciones del array
        for (int i = 0; i < 50; i++) {
            System.out.print(numeros[i] + "  ");
        }
    }
}