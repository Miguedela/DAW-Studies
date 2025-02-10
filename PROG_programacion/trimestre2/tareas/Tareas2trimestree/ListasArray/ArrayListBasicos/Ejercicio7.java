import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio7 {
    Scanner s = new Scanner(System.in);
    private ArrayList<Integer> numerosEnteros = new ArrayList<>();
    private int opc;

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("1) Agregar número.");
            System.out.println("2) Comprobar repeticiones.");
            System.out.println("3) Ver números.");
            System.out.println("4) Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt();

            if (opc == 1) {
                agregarEntero(); // Llamar al método para agregar un número entero
            } else if (opc == 2) {
                obtenerMaxMin(); // Llamar al método para obtener el número máximo y mínimo
            } else if (opc == 3) {
                mostrarArrayList(); // Llamar al método para mostrar la lista de números
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt(); // Pedir al usuario que ingrese una opción válida
                } while (opc != 1 && opc != 2 && opc != 3 && opc != 4); // Repetir hasta que se ingrese una opción
                                                                        // válida
            }
        } while (opc != 4); // Salir del bucle cuando se seleccione la opción 4 (Salir)
    }

    // Método para agregar un número entero a la lista
    public void agregarEntero() {
        System.out.print("Ingresa un número entero: ");
        int nuevoNumero = s.nextInt(); // Leer el número entero ingresado por el usuario
        numerosEnteros.add(nuevoNumero); // Agregar el número a la lista
    }

    // Método para obtener el número máximo y mínimo de la lista de números
    public void obtenerMaxMin() {
        if (!numerosEnteros.isEmpty()) { // Verificar si la lista no está vacía
            System.out.println("El número máximo es: " + Collections.max(numerosEnteros)); // Mostrar el número máximo
            System.out.println("El número mínimo es: " + Collections.min(numerosEnteros)); // Mostrar el número mínimo
        } else {
            System.out.println("La lista está vacía."); // Mostrar un mensaje si la lista está vacía
        }
    }

    // Método para mostrar la lista de números
    public void mostrarArrayList() {
        for (int i = 0; i < numerosEnteros.size(); i++) {
            System.out.println((i + 1) + ") " + numerosEnteros.get(i)); // Mostrar cada número en la lista con su índice
        }
    }
}

class Ejercicio7Ejecutable {
    public static void main(String[] args) {
        Ejercicio7 lista1 = new Ejercicio7(); // Crear una instancia de Ejercicio7
        lista1.menu(); // Llamar al método menu para iniciar el programa
    }
}
