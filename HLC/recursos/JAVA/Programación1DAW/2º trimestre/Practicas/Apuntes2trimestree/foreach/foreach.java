// for (tipo elemento : colección) {
//     // Cuerpo del bucle
//     }

public class foreach {
    public static void main(String[] args) {
        // Matriz unidimensional
        int[] numeros = { 1, 2, 3, 4, 5 }; // Matriz de enteros que va desde 1 a 5
        
        for (int numero : numeros) {
            System.out.println(numero);
        }

        // Matriz bidimensional
        int[][] matriz = { // Matriz bidimensional de 3*3, que recore un tablero del número 1 al 9
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        //Bucle for-each que recorre el array bidimensional
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }
}