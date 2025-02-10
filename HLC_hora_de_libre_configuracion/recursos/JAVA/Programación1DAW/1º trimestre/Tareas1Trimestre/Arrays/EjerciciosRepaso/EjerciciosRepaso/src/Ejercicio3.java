import java.util.Random;

public class Ejercicio3 {
    /*Sacar por pantalla el array grande, y los dos subarrays creados.*/
    public static void main(String[] args) {
        Random r = new Random();

        int[] numeros = new int[50];
        int pares = 0;
        int impares = 0;

        //Bucle for quele da valor a las 50 posiciones del array
        for (int i = 0; i < 50; i++) {
            numeros[i] = r.nextInt(-1492, 1898);
        }

        //Bucle for que muestra las 50 posiciones del array
        System.out.println("El array contiene: ");
        for (int i = 0; i < 50; i++) {
            System.out.print(numeros[i] + "  ");
        }
        System.out.println();
        System.out.println();

        //Bucle for que cuenta la cantidad de pares e impares que hay
        for (int i = 0; i < 50; i++) {
            if (numeros[i] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }

        int[] tablapares = new int[pares];
        int[] tablaimpares = new int[impares];
        int aux1 = 0;
        int aux2 = 0;

        for (int i = 0; i < 50; i++) {
            if (numeros[i] % 2 == 0) {
                tablapares[aux1] = numeros[i];
                aux1++;
            } else {
                tablaimpares[aux2] = numeros[i];
                aux2++;
            }
        }

        //Bucle for que muestra los distintos numeros pares
        System.out.println("Los numeros pares son: ");
        for (int i = 0; i < tablapares.length; i++) {
            System.out.print(tablapares[i] + "  ");
        }
        System.out.println();

        //Bucle for que muestra los distintos numeros impares
        System.out.println("Los numeros impares son: ");
        for (int i = 0; i < tablaimpares.length; i++) {
            System.out.print(tablaimpares[i] + "  ");
        }
    }
}
