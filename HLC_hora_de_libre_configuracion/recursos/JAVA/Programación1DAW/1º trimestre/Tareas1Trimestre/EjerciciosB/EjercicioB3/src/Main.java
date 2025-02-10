import java.util.Scanner; //Introduzco la utilidad Scanner
public class Main {
    /*Ejercicio 3 - Desarrolla un programa que nos pida letras por teclado (caracteres) y nos
    saque por pantalla si se trata de una vocal o de una consonante. El programa tiene que
    terminar cuando introduzcamos un número cualquiera.*/
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); //Creo la variable de Scanner

        System.out.print("Introduce una letra: "); //Leo por primera vez la letra introducida
        String letra = s.nextLine(); //

        while (true) {

            //if que dice si la letra es una vocal o una consonante
            if (letra.equals("a") || letra.equals("e") || letra.equals("i")|| letra.equals("o") || letra.equals("u") || letra.equals("A") || letra.equals("E") || letra.equals("I") || letra.equals("O") || letra.equals("U")) {
                System.out.println("Esta letra es una vocal");
            } else {
                System.out.println("Esta letra es una consonante");
            }

            System.out.print("Vuelve a introducir una letra: ");//Vuelvo a pedir que me introduzca una letra
            letra = s.nextLine();

            //Pido que si el caracter introducido es un número se cierre el programa
            if (letra.equals("1") || letra.equals("2") || letra.equals("3") || letra.equals("4") || letra.equals("5") || letra.equals("6") || letra.equals("7") || letra.equals("8") || letra.equals("9") || letra.equals("0")) {
                break;
            }
        }

    }
}