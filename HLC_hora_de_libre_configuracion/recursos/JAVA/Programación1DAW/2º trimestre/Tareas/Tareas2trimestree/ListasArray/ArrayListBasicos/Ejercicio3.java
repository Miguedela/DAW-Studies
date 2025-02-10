import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio3 {
    Scanner s = new Scanner(System.in);
    private ArrayList<Integer> numerosEnteros = new ArrayList<>();
    private int opc;

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("1) Agregar número.");
            System.out.println("2) Comprobar y eliminar repetidos.");
            System.out.println("3) Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt();

            if (opc == 1) {
                agregarEntero();
            } else if (opc == 2) {
                ordenarAscendente();
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt();
                } while (opc != 1 && opc != 2 && opc != 3);
            }
        } while (opc != 3);
    }

    // Método para agregar un número entero a la lista
    public void agregarEntero() {
        System.out.print("Ingresa un número entero: ");
        int nuevoNumero = s.nextInt();
        numerosEnteros.add(nuevoNumero); // Agregar el número entero a la lista
    }

    // Método para ordenar los números de menor a mayor y eliminar repetidos
    public void ordenarAscendente() {
        Collections.sort(numerosEnteros); // Ordenar los números de menor a mayor
        System.out.println("Lista ordenada de menor a mayor: ");
        System.out.println(numerosEnteros); // Mostrar la lista ordenada

        Collections.reverse(numerosEnteros); // Revertir la lista para obtener la ordenación descendente
    }
}
