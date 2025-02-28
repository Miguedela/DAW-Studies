import java.util.Random;

public class EjercicioParImpar {
    public static void main(String[] args) {
        Random r = new Random();

        int[] miArray = new int[50];
        int[] numPares;
        int[] numImpares;
        int contadorImpares = 0;
        int contadorIaux = 0;
        int contadorPaux = 0;
        int contadorPares = 0;

        for (int i = 0; i < miArray.length; i++) {

            miArray[i] = r.nextInt(-1492, 1898);

            if (miArray[i] % 2 == 0) {

                contadorPares++;

            } else {

                contadorImpares++;

            }

        }

        numPares = new int[contadorPares];
        numImpares = new int[contadorImpares];

        System.out.println("Array de 50 numeros");

        for (int i = 0; i < miArray.length; i++) {

            if (i % 5 == 0) {

                System.out.println();

            }

            System.out.printf("%6d", miArray[i]);

        }

        for (int i = 0; i < miArray.length; i++) {

            if (miArray[i] % 2 == 0) {

                numPares[contadorPaux] = miArray[i];
                contadorPaux++;

            } else {

                numImpares[contadorIaux] = miArray[i];
                contadorIaux++;

            }

        }

        System.out.println();
        System.out.println();
        System.out.printf("Array de numeros pares de " + contadorPares + " numeros");

        for (int i = 0; i < numPares.length; i++) {

            if (i % 5 == 0) {

                System.out.println();

            }

            System.out.printf("%6d", numPares[i]);

        }

        System.out.println();
        System.out.println();
        System.out.printf("Array de numeros impares de " + contadorImpares + " numeros");

        for (int i = 0; i < numImpares.length; i++) {

            if (i % 5 == 0) {

                System.out.println();

            }
            System.out.printf("%6d", numImpares[i]);

        }

// bucle para ordenar el array de num pares (menor a mayor)
        for (int i = 0; i < numPares.length - 1; i++) {

            for (int j = 0; j < numPares.length - 1; j++) {

// si la posicion es mayor que la siguiente posicion
                if (numPares[j] > numPares[j + 1]) {

                    int auxpar = numPares[j]; // esta var se aguala a esa posicion
                    numPares[j] = numPares[j + 1]; // la primera posicion se cambia por el num mas chico
                    numPares[j + 1] = auxpar; // la siguiente posicion se iguala al mayor

                }

            }
        }

// bucle para ordenar el array de num impares (menor a mayor)
        for (int i = 0; i < numImpares.length - 1; i++) {

            for (int j = 0; j < numImpares.length - 1; j++) {

// si la posicion es mayor que la siguiente posicion
                if (numImpares[j] > numImpares[j + 1]) {

                    int auximpar = numImpares[j]; // esta var se aguala a esa posicion
                    numImpares[j] = numImpares[j + 1]; // la primera posicion se cambia por el num mas chico
                    numImpares[j + 1] = auximpar; // la siguiente posicion se iguala al mayor

                }

            }
        }

        System.out.println();
        System.out.println("Numeros pares ordenados");

        for (int i = 0; i < numPares.length; i++) {

            if (i % 5 == 0) {

                System.out.println();

            }

            System.out.printf("%6d", numPares[i]);

        }

        System.out.println();
        System.out.println("Numeros impares ordenados");

        for (int i = 0; i < numImpares.length; i++) {

            if (i % 5 == 0) {

                System.out.println();

            }

            System.out.printf("%6d", numImpares[i]);

        }

        System.out.println();
        System.out.println();
        System.out.println("Valor mas alto de los pares " + numPares[numPares.length - 1]);
        System.out.println("Valor mas bajo de los impares " + numImpares[0]);

        int valorMedio = (numPares[numPares.length - 1] + numImpares[0]) / 2;

        System.out.println("Valor medio " + valorMedio);

        int calculo1 = 0;
        int calculo1aux = Integer.MAX_VALUE;
        int calculo2 = 0;
        int calculo2aux = Integer.MAX_VALUE;

        for (int i = 0; i < numPares.length; i++) {
            calculo1 = Math.abs(numPares[i] - valorMedio);
            if (calculo1 < Math.abs(calculo1aux - valorMedio)) {
                calculo1aux = numPares[i];
            }
        }

        for (int i = 0; i < numImpares.length; i++) {
            calculo2 = Math.abs(numImpares[i] - valorMedio);
            if (calculo2 < Math.abs(calculo2aux - valorMedio)) {
                calculo2aux = numImpares[i];
            }
        }

        //Muestro por pantalla ambas medias
        if (calculo1aux == valorMedio) {
            System.out.println("El valor medio ha sido encontrado en el primer array, y es: " + calculo1aux);
        } else {
            System.out.println("El valor medio mas aproximado del primer array es: " + calculo1aux);
        }

        if (calculo1aux == valorMedio) {
            System.out.println("El valor medio ha sido encontrado en el segundo array, y es: " + calculo2aux);
        } else {
            System.out.println("El valor medio mas aproximado del segundo array es: " + calculo2aux);
        }
    }
}