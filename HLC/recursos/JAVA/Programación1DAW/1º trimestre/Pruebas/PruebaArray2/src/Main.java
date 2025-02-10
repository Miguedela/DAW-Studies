public class Main {
    /*2- Conteo de elementos pares e impares
    Desarrolla un programa en Java que declare un array de enteros de tamaño 7 y le
    asignes valores. Luego, cuenta y muestra en pantalla la cantidad de elementos pares e
    impares en el array.*/
    public static void main(String[] args) {

        int[] tabla = {3, 4, 1, 2, 6, 7, 8}; // creo el array con las 7 valores ya asignados

        int impar = 0; // inicio la variable de la cantidad de números impares
        int par = 0; // inicio la variable de la cantidad de números pares

        for (int i = 0; i < tabla.length; i++) { // creo un bucle el cual se va a repetir tantas veces como posiciones tenga el array
            if (tabla[i] % 2 == 0) { // if que me resuelva si el número que esta en cada posicion del array es par o impar
                par ++;
            } else {
                impar++;
            }
        }

        System.out.println("Hay " + par + " números pares"); // muestro por pantalla la cantidad de números pares que hay
        System.out.println("Hay " + impar + " números pares"); // muestro por pantalla la cantidad de números impares que hay

    }
}