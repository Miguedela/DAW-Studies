import java.sql.SQLOutput;
import java.util.Random;

public class Ejercicio6 {
    /*Sacar por pantalla dicho valor (de cada array), y la posición del valor (en cada
    array).*/
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

        //Bucle for que almacena los numeros pares e impares en distintas tablas
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
            //Salto de linea cada 5 numeros
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(tablapares[i] + "  ");
        }
        System.out.println();
        System.out.println();

        //Bucle for que muestra los distintos numeros impares
        System.out.println("Los numeros impares son: ");
        for (int i = 0; i < tablaimpares.length; i++) {
            //Salto de linea cada 5 numeros
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(tablaimpares[i] + "  ");
        }
        System.out.println();
        System.out.println();

        //Bucle para ordenar el array de num pares (menor a mayor)
        for (int i = 0; i < tablapares.length - 1; i++) {
            for (int j = 0; j < tablapares.length - 1; j++) {
                //Si la posicion es mayor que la siguiente posicion
                if (tablapares[j] > tablapares[j + 1]) {
                    int auxpar = tablapares[j]; // esta var se aguala a esa posicion
                    tablapares[j] = tablapares[j + 1]; // la primera posicion se cambia por el num mas chico
                    tablapares[j + 1] = auxpar; // la siguiente posicion se iguala al mayor
                }
            }
        }

        //Bucle para ordenar el array de num impares (menor a mayor)
        for (int i = 0; i < tablaimpares.length - 1; i++) {
            for (int j = 0; j < tablaimpares.length - 1; j++) {
                //Si la posicion es mayor que la siguiente posicion
                if (tablaimpares[j] > tablaimpares[j + 1]) {
                    int auximpar = tablaimpares[j]; // esta var se aguala a esa posicion
                    tablaimpares[j] = tablaimpares[j + 1]; // la primera posicion se cambia por el num mas chico
                    tablaimpares[j + 1] = auximpar; // la siguiente posicion se iguala al mayor
                }
            }
        }

        //Bucle for que muestra los distintos numeros pares
        System.out.println("Los numeros pares son: ");
        for (int i = 0; i < tablapares.length; i++) {
            //Salto de linea cada 5 numeros
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(tablapares[i] + "  ");
        }
        System.out.println();
        System.out.println();

        //Bucle for que muestra los distintos numeros impares
        System.out.println("Los numeros impares son: ");
        for (int i = 0; i < tablaimpares.length; i++) {
            //Salto de linea cada 5 numeros
            if (i % 5 == 0) {
                System.out.println();
            }
            System.out.print(tablaimpares[i] + "  ");
        }
        System.out.println();
        System.out.println();



        //Creo las variables necesarias para el mayor y menor
        int mayor1 = Integer.MIN_VALUE;
        int menor2 = Integer.MAX_VALUE;
        int posicion1 = 0;
        int posicion2 = 0;

        //Bucle for que coje el valor más grande de el subarray1 (tablapares)
        for (int i = 0; i < tablapares.length; i++) {
            if (tablapares[i] > mayor1) {
                mayor1 = tablapares[i];
                posicion1 = i;
            }
        }

        //Bucle for que coje el valor más pequeño de el subarray2 (tablapares)
        for (int i = 0; i < tablaimpares.length; i++) {
            if (tablaimpares[i] < menor2) {
                menor2 = tablaimpares[i];
                posicion2 = i;
            }
        }

        int valorMedio = (mayor1 + menor2) / 2;

        System.out.println("El número más grande del primer subarray es: " + mayor1 + " en la posicion: " + (posicion1 + 1));
        System.out.println("El número más pequeño del segundo subarray es: " + menor2 + " en la posicion: " + (posicion2 + 1));
        System.out.println("El valor medio es de: " + valorMedio);

        //Creo las variables necesarias para las medias
        int calculo1 = 0;
        int calculo1aux = Integer.MAX_VALUE;
        int calculo2 = 0;
        int calculo2aux = Integer.MAX_VALUE;

        //Bucle for que busca la media de la tabla pares
        for (int i = 0; i < tablapares.length; i++) {
            calculo1 = Math.abs(tablapares[i] - valorMedio);
            if (calculo1 < Math.abs(calculo1aux - valorMedio)) {
                calculo1aux = tablapares[i];
            }
        }

        //Bucle for que busca la media de la tabla impares
        for (int i = 0; i < tablaimpares.length; i++) {
            calculo2 = Math.abs(tablaimpares[i] - valorMedio);
            if (calculo2 < Math.abs(calculo2aux - valorMedio)) {
                calculo2aux = tablaimpares[i];
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
