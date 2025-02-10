package Ejercicios_foreach;

// Escribe un programa que calcule la suma de todos los elementos pares en un array
// unidimensional de enteros.

public class Ejercicio5 {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3, 4, 5 };
        int suma = 0;

        for (int numero : numeros) {
            if (numero % 2 == 0) {
                suma += numero;
            }
        }

        System.out.println("La suma total del array da: " + suma);
    }
}
