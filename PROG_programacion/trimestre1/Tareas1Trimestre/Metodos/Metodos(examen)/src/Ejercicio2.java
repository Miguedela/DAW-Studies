//Importo las utilidades necesarias

import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {

        //Inicio las variables
        int[] apuesta = generarApuesta();
        int[] apuestaGanadora = {-77, -62, -50, -44, -43, -37};

        ganador(apuesta, apuestaGanadora);
    }

    // Método para generar apuesta de 6 números sin repetir
    private static int[] generarApuesta() {

        //Creo los objetos
        Random r = new Random();

        //Inicio las variables
        int[] apuesta = new int[6];
        int index = 0;

        while (index < 6) {
            int numeroAleatorio = r.nextInt(-31 - (-80) + 1) + (-80);
            boolean repetido = false;

            for (int i = 0; i < apuesta.length; i++) {
                if (apuesta[i] == numeroAleatorio) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {
                apuesta[index] = numeroAleatorio;
                index++;
            }
        }

        return apuesta;
    }

    // Método para comprobar aciertos en una apuesta
    private static int aciertos(int[] apuesta, int[] loteria) {
        int nAciertos = 0;
        for (int x = 0; x < apuesta.length; x++) {
            for (int y = 0; y < apuesta.length; y++) {
                if (apuesta[x] == loteria[y]) {
                    nAciertos++;
                }
            }
        }
        return nAciertos;
    }

    // Método para mostrar resultados
    private static void ganador(int[] apuesta, int[] loteria) {
        int nAciertos = aciertos(apuesta, loteria);
        for (int i = 0; i < 6; i++) {

            if (i == 0) {
                System.out.print("La apuesta ganadora es: \t" + loteria[i] + " ");
            } else {
                System.out.print(loteria[i] + " ");
            }
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 6; i++) {

            if (i == 0) {
                System.out.print("Tu apuesta es: \t\t\t\t" + apuesta[i] + " ");
            } else {
                System.out.print(apuesta[i] + " ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.print("Aciertos 1 apuesta: \t\t" + nAciertos);
        System.out.println();
    }

    // Método para mostrar un array
    private static void mostrar(int[] array) {
        for (int i = 0; i < 6; i++) {
            System.out.print(array[i] + " ");
        }
    }
}