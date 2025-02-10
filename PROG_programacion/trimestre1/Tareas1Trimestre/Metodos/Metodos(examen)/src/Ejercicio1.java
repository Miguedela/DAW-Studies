//Importo las utilidades necesarias

import java.util.Scanner;
import java.util.Random;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Random r = new Random();

        //Inicio las variables
        int tiradas = 0;

        //1) Introducir el número de tiradas correcto.
        tiradas = inmtroducirTiradas(s);

        //2) Crear array bidimensional del tamaño justo (introducido por teclado).
        int[][] sumaFrecuencia = tamaño();

        //3) Rellenar la primera columna del array.
        columna1(sumaFrecuencia);

        //4) Rellenar la segunda columna del array (hacer la tirada de dados).
        columna2(sumaFrecuencia, tiradas);

        //5) Mostrar resultados por pantalla.
        mostrar(sumaFrecuencia);
    }

    private static int inmtroducirTiradas(Scanner entrada) {
        int tiradas;
        do {
            System.out.print("Introduce el numero de tiradas: ");
            tiradas = entrada.nextInt();
        } while (tiradas < 10 || tiradas > 1000);
        return tiradas;
    }

    private static int[][] tamaño() {
        return new int[11][2];
    }

    public static void columna1(int[][] sumaFrecuencia) {
        for (int i = 0; i < sumaFrecuencia.length; i++) {
            sumaFrecuencia[i][0] = i + 2;
        }
    }

    public static void columna2(int[][] sumaFrecuencia, int tiradas) {
        Random r = new Random();
        for (int i = 0; i < tiradas; i++) {
            int dado1 = r.nextInt(1, 6 + 1);
            int dado2 = r.nextInt(1, 6 + 1);
            int suma = dado1 + dado2;
            sumaFrecuencia[suma - 2][1]++;
        }
    }

    public static void mostrar(int[][] sumaFrecuencia) {
        System.out.println("Suma\tFrecuencia");
        for (int i = 0; i < sumaFrecuencia.length; i++) {
            System.out.println(sumaFrecuencia[i][0] + "\t\t" + sumaFrecuencia[i][1]);
        }
    }
}