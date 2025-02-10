import java.util.Random;

public class GirarFormaReloj {
    /*Realiza un programa que sea capaz de rotar todos los elementos de una
    matriz cuadrada una posición en el sentido de las agujas del reloj. La matriz
    debe tener 12 filas por 12 columnas y debe contener números generados al
    azar entre 0 y 100. Se debe mostrar tanto la matriz original como la matriz
    resultado, ambas con los números convenientemente alineados.*/
    public static void main(String[] args) {
        Random r = new Random(); // creo el objeto random

        int[][] matriz12x12 = new int[12][12];

        System.out.println("Matriz 12x12 SIN ROTAR");
        System.out.println();
        //Para recorrer las filas
        for (int fila = 0; fila < 12; fila++) {
            //Para recorrer las columnas
            for (int columna = 0; columna < 12; columna++) {
                matriz12x12[fila][columna] = r.nextInt(101);
                System.out.printf("%5d", matriz12x12[fila][columna]); //printf "%5d" Significa que cada nº q imprima obtendra 5 espacios
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("MATRIZ ROTADA SENTIDO HORARIO");
        System.out.println();

        int aux = 12; //Para ayudarnos a recorrer los bucles

        for (int nivel = 0; nivel < aux / 2; nivel++) { //

            int limite = aux - nivel - 1; //Nos sirve para recorrer los bucles internos
            int guarda = matriz12x12[nivel][nivel];
            for (int i = nivel; i < limite; i++) { //Rotar desde abajo hacia arriba dentro de los niveles de la matriz
                matriz12x12[i][nivel] = matriz12x12[i + 1][nivel];
            }
            for (int i = nivel; i < limite; i++) {
                matriz12x12[limite][i] = matriz12x12[limite][i + 1];
            }
            for (int i = limite; i > nivel; i--) {
                matriz12x12[i][limite] = matriz12x12[i - 1][limite];
            }
            for (int i = limite; i > nivel; i--) {
                matriz12x12[nivel][i] = matriz12x12[nivel][i - 1];
            }
            matriz12x12[nivel][nivel + 1] = guarda;
        }
        for (int fila = 0; fila < 12; fila++) {
            //Para recorrer las columnas
            for (int columna = 0; columna < 12; columna++) {
                System.out.printf("%5d", matriz12x12[fila][columna]); //printf "%5d" Significa que cada nº que imprima obtendra 5 espacios
            }
            System.out.println();
        }
    }
}
