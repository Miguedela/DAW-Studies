import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        Random r = new Random(); //Creo un objeto para Random

        int N = r.nextInt(30-20+1)+(20);

        //Inicio los arrays unidimensionales
        int[] array1 = new  int[N];
        int[] array2 = new  int[N];

        //Bucles for que rellena el array unidimensional 1 y 2
        for (int i = 0; i < N; i++) {
            array1[i] = r.nextInt(50-(-50)+1)+(-50);
        }
        for (int i = 0; i < N; i++) {
            array2[i] = r.nextInt(50-(-50)+1)+(-50);
        }

        //Bucles for que muestran por pantalla tanto la tabla 1 como la 2
        System.out.println("El primer array unidimensional contiene: ");
        for (int i = 0; i < N; i++) {
            System.out.print(array1[i] + "  ");
        }
        System.out.println();
        System.out.println();
        System.out.println("El segundo array unidimensional contiene: ");
        for (int i = 0; i < N; i++) {
            System.out.print(array2[i] + "  ");
        }

        System.out.println();

        //Lo necesario para poder realizar el array intercaldo
        int[] intercalado = new int[N+N];
        int auxiliarwh = 0;
        int h = 0;

        //Bucle do-while que rellena el array intercalado
        do {
            intercalado[auxiliarwh] = array1[h];
            auxiliarwh++;
            intercalado[auxiliarwh] = array2[h];
            auxiliarwh++;
            h++;
        } while(auxiliarwh < N+N);

        System.out.println();

        System.out.println("El array intercalado contiene: ");
        //Bucle for que muestra por pantalla el array intercalado
        for (int i = 0; i < N+N; i++) {
            System.out.print(intercalado[i] + "  ");
        }
        System.out.println();
        System.out.println();

        int min = 51;
        int max = -51;
        int intermedio = 0;

        //Bucle for que detecta el número más grande del array intercalado
        for (int i = 0; i < N+N; i++) {
            if (intercalado[i] > max) {
                max = intercalado[i];
            }
        }
        System.out.println("El número más grande del array intercalado es: " + max);

        //Bucle for que detecta el número más pequeño del array intercalado
        for (int i = 0; i < N+N; i++) {
            if (intercalado[i] < min) {
                min = intercalado[i];
            }
        }

        System.out.println("El número más pequeño del array intercalado es: " + min);

        //Bucle for que detecta el número intermedio del array intercalado
        for (int i = 0; i < N+N; i++) {
            if ((max + min)/2 == intercalado[i]) {
                intermedio = intercalado[i];
            } else if (((max + min)/2) + 1 == intercalado[i]) {
                intermedio = intercalado[i];
            } else if (((max + min)/2) - 1 == intercalado[i]) {
                intermedio = intercalado[i];
            } else if (((max + min)/2) + 2 == intercalado[i]) {
                intermedio = intercalado[i];
            } else if (((max + min)/2) - 2 == intercalado[i]) {
                intermedio = intercalado[i];
            }
        }

        System.out.println("El número intermedio del array intercalado es: " + intermedio);
        System.out.println();

        //Inicio las variables necesarias para el calculo del cuadrado de las posiciones impares
        int[] cuadrado = new int[N];
        int[] posicion = new int[N];
        int iaux = 0;


        //Bucle que realiza la suma de los cuadrados
        for (int i = 0; i < N+N; i++) {
            if (i % 2 != 0) {
                cuadrado[iaux] = intercalado[i] * intercalado[i];
                posicion[iaux] = i;
                iaux++;
            }
        }
        iaux = 0;

        //Bucle for que muestra la suma de los cuadrados
        for (int i = 0; i < N+N; i++) {
            if (i % 2 != 0) {
                System.out.println("El número posicionado en el hueco " + posicion[iaux] + " da un resultado de: " + cuadrado[iaux]);
                iaux++;
            }
        }
    }
}
