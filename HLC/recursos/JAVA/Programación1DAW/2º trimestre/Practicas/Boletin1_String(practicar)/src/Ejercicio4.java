import java.util.Scanner;

public class Ejercicio4 {
    /*Ejemplo_4 Mostrar un parrafo de varias lineas y pedir una palabra, mostrar todas las
    posiciones en las que aparece dicha palabra.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String parrafo = "Lorem fistrum jarl pecador me cago en tus muelas. No te digo trigo por no llamarte Rodrigor caballo blanco caballo negroorl diodenoo ese pedazo de apetecan está la cosa muy malar ese que llega hasta luego Lucas.";

        System.out.println("Introduce la letra que desea buscar");
        String buscador = s.next();

        int buscarPosicion = parrafo.indexOf(buscador);
        int buscarPosicionSig = parrafo.indexOf(buscador, buscarPosicion + 1);

        System.out.println((buscarPosicion + 1) + " " + (buscarPosicionSig + 1));
    }
}
