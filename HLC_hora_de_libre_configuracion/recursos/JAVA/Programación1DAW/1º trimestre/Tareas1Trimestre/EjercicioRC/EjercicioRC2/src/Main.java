//Importo la utilidad de Scanner
import java.util.Scanner;
public class Main {
    //Enunciado
    /*2. Realizar un programa que lea los lados de n triángulos, e informar:
    a) De cada uno de ellos, qué tipo de triángulo es: equilátero (tres lados iguales),
    isósceles (dos lados iguales), o escaleno (ningún lado igual)
    b) Cantidad de triángulos de cada tipo.
    c) Tipo de triángulo que posee menor cantidad.*/
    public static void main(String[] args) {
        //Creo la variable de Scanner
        Scanner s = new Scanner(System.in);

        //Inicio las variables
        int trieq = 0;
        int triis = 0;
        int tries = 0;

        //Pregunto cuál va a ser el número de triangulos a introducir en el programa
        System.out.println("¿Cuántos triángulos quieres leer?");
        int ntri = s.nextInt();

        //for que se repite tantas veces como le hayamos pedido
        for (int i = 1; i <=ntri; i++) {

            //Pido que introduzcan las medidas de los 3 lados del triangulo por separado
            System.out.println("Dí cuanto mide el primer lado " + i + "ª triángulo");
            double lad1 = s.nextDouble();
            System.out.println("Dí cuanto mide el segundo lado " + i + "ª triángulo");
            double lad2 = s.nextDouble();
            System.out.println("Dí cuanto mide el tercer lado " + i + "ª triángulo");
            double lad3 = s.nextDouble();

            //Este if se encarga de decir que tipo de triangulos son y de sumar uno a su variable propia
            if ((lad1 == lad2) && (lad1 == lad3)) {
                System.out.println("El triángulo es equilátero");
                trieq++;
            } else if ((lad1 == lad2) || (lad2 == lad3) || (lad1 == lad3)) {
                System.out.println("El triángulo es isósceles");
                triis++;
            } else {
                System.out.println("El triángulo es escaleno");
                tries++;
            }
        }

        //Se encarga de mostrar por pantalla el número de triangulos que hay de cada tipo
        System.out.println("Hay " + trieq + " triángulos equiláteros");
        System.out.println("Hay " + triis + " triángulos isósceles");
        System.out.println("Hay " + tries + " triángulos escalenos");

        //Dice que tipo de triángulos son los menos abundantes
        if ((trieq <= tries) && (trieq <= triis)) {
            System.out.println("El tipo de triangulos menos comúnes son los equiláteros");
        } else if ((tries <= trieq) && (tries <= triis)) {
            System.out.println("El tipo de triangulos menos comúnes son los escalenos");
        } else if ((triis <= tries) && (triis <= trieq)) {
            System.out.println("El tipo de triangulos menos comúnes son los isósceles");
        //Dice si son dos los tipos de triangulos de menos comúnes
        } else if ((trieq <= triis) && (trieq == tries)) {
            System.out.println("Los tipos de triangulos menos comúnes son los equilateros y escalenos");
        } else if ((trieq <= tries) && (trieq == triis)) {
            System.out.println("Los tipos de triangulos menos comúnes son los equilateros e isosceles");
        } else if ((triis <= trieq) && (triis == tries)) {
            System.out.println("Los tipos de triangulos menos comúnes son los isosceles y escalenos");
        } else if ((triis <= tries) && (triis == trieq)) {
            System.out.println("Los tipos de triangulos menos comúnes son los isosceles y equilateros");
        } else if ((tries <= trieq) && (tries == triis)) {
            System.out.println("Los tipos de triangulos menos comúnes son los escalenos y isosceles");
        } else if ((tries <= triis) && (tries == trieq)) {
            System.out.println("Los tipos de triangulos menos comúnes son los escalenos y equilateros");
        }
    }
}