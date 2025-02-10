import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio10 {
    Scanner s = new Scanner(System.in);
    private ArrayList<Integer> numerosEnteros = new ArrayList<>(); // Declaración de ArrayList para almacenar números
                                                                   // enteros
    private int opc; // Variable para almacenar la opción del menú

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("1) Agregar número."); // Opción para agregar un número
            System.out.println("2) Eliminar números."); // Opción para eliminar números de la lista
            System.out.println("3) Ver números."); // Opción para mostrar los números en la lista
            System.out.println("4) Salir."); // Opción para salir del programa
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt(); // Leer la opción ingresada por el usuario

            if (opc == 1) {
                agregarEntero(); // Llamar al método para agregar un número
            } else if (opc == 2) {
                eliminarNumeros(); // Llamar al método para eliminar números de la lista
            } else if (opc == 3) {
                mostrarArrayList(); // Llamar al método para mostrar los números en la lista
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt(); // Solicitar una opción válida al usuario
                } while (opc != 1 && opc != 2 && opc != 3 && opc != 4); // Repetir hasta que se ingrese una opción
                                                                        // válida
            }
        } while (opc != 4); // Salir del bucle cuando se seleccione la opción 4 (Salir)
    }

    // Método para agregar un número a la lista
    public void agregarEntero() {
        System.out.print("Ingresa un número entero: ");
        int nuevoNumero = s.nextInt(); // Leer el número ingresado por el usuario
        numerosEnteros.add(nuevoNumero); // Agregar el número a la lista
    }

    // Método para eliminar números de la lista
    public void eliminarNumeros() {
        System.out.print("Ingresa la posición de inicio para el guardado: ");
        int posicionInicio = s.nextInt(); // Leer la posición de inicio ingresada por el usuario
        System.out.print("Ingresa la posición final para el guardado: ");
        int posicionFinal = s.nextInt(); // Leer la posición final ingresada por el usuario
        for (int i = posicionInicio; i <= posicionFinal; i++) {
            numerosEnteros.remove(posicionInicio); // Eliminar el número en la posición especificada
        }
    }

    // Método para mostrar los números en la lista
    public void mostrarArrayList() {
        for (int i = 0; i < numerosEnteros.size(); i++) {
            System.out.println((i + 1) + ") " + numerosEnteros.get(i)); // Mostrar cada número en la lista
        }
    }
}

class Ejercicio10Ejecutable {
    public static void main(String[] args) {
        Ejercicio10 lista1 = new Ejercicio10(); // Crear una instancia de Ejercicio10
        lista1.menu(); // Llamar al método menu para iniciar el programa
    }
}
