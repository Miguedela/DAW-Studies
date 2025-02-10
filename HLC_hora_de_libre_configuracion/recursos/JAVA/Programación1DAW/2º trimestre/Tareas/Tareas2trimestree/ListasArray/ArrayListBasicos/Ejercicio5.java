import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio5 {
    Scanner s = new Scanner(System.in);
    ArrayList<Integer> numerosEnteros = new ArrayList<>(); // Lista para almacenar los números enteros ingresados por el
                                                           // usuario
    private int opc; // Variable para almacenar la opción seleccionada por el usuario

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("1) Agregar número.");
            System.out.println("2) Comprobar y eliminar repetidos.");
            System.out.println("3) Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt(); // Leer la opción ingresada por el usuario

            if (opc == 1) {
                agregarEntero(); // Llamar al método para agregar un número entero
            } else if (opc == 2) {
                eliminarDuplicado(); // Llamar al método para eliminar duplicados
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt(); // Pedir al usuario que ingrese una opción válida
                } while (opc != 1 && opc != 2 && opc != 3); // Repetir hasta que se ingrese una opción válida
            }
        } while (opc != 3); // Salir del bucle cuando se seleccione la opción 3 (Salir)
    }

    // Método para agregar un número entero a la lista
    public void agregarEntero() {
        System.out.println("Introduce el número: ");
        int nuevoNumero = s.nextInt(); // Leer el número entero ingresado por el usuario
        numerosEnteros.add(nuevoNumero); // Agregar el número a la lista
    }

    // Método para eliminar duplicados de la lista de números enteros
    public void eliminarDuplicado() {
        HashSet<Integer> set = new HashSet<>(numerosEnteros); // Crear un HashSet a partir de la lista para eliminar
                                                              // duplicados
        numerosEnteros.clear(); // Limpiar la lista original
        numerosEnteros.addAll(set); // Agregar los elementos únicos de HashSet de vuelta a la lista original
        System.out.println("Lista de duplicados eliminados."); // Mostrar mensaje indicando que se eliminaron duplicados
        System.out.println(numerosEnteros);
    }
}

class Ejercicio5Ejecutable {
    public static void main(String[] args) {
        Ejercicio5 lista1 = new Ejercicio5(); // Crear una instancia de Ejercicio5
        lista1.menu(); // Llamar al método menu para iniciar el programa
    }
}
