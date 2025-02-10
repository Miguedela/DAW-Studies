import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio9 {
    Scanner s = new Scanner(System.in);
    private ArrayList<Integer> lista1 = new ArrayList<>(); // Declaración de ArrayList para almacenar números
    private int opc; // Variable para almacenar la opción del menú
    private int numero; // Variable para almacenar el número ingresado por el usuario

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("----------------------");
            System.out.println("1) Agregar un número."); // Opción para agregar un número
            System.out.println("2) Invertir lista."); // Opción para invertir la lista
            System.out.println("3) Salir."); // Opción para salir del programa
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt(); // Leer la opción ingresada por el usuario

            if (opc == 1) {
                agregarNumero(); // Llamar al método para agregar un número
            } else if (opc == 2) {
                invertirLista(); // Llamar al método para invertir la lista
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt(); // Solicitar una opción válida al usuario
                } while (opc != 1 && opc != 2 && opc != 3); // Repetir hasta que se ingrese una opción válida
            }
        } while (opc != 3); // Salir del bucle cuando se seleccione la opción 3 (Salir)
    }

    // Método para agregar un número a la lista
    public void agregarNumero() {
        System.out.print("Ingresa un número: ");
        numero = s.nextInt(); // Leer el número ingresado por el usuario
        lista1.add(numero); // Agregar el número a la lista
    }

    // Método para invertir la lista de números
    public void invertirLista() {
        Collections.reverse(lista1); // Invertir la lista utilizando el método reverse de la clase Collections
        System.out.println("Lista después de invertir la lista: ");
        System.out.println(lista1); // Mostrar la lista invertida
    }
}

class Ejercicio9Ejecutable {
    public static void main(String[] args) {
        Ejercicio9 lista1 = new Ejercicio9(); // Crear una instancia de Ejercicio9
        lista1.menu(); // Llamar al método menu para iniciar el programa
    }
}
