import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    Scanner s = new Scanner(System.in);
    private ArrayList<String> usuario = new ArrayList<>(); // ArrayList para almacenar nombres de usuario
    private int opc; // Variable para almacenar la opción seleccionada por el usuario
    private String nombre; // Variable para almacenar el nombre del usuario

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("----------------------");
            System.out.println("1) Agregar un usuario.");
            System.out.println("2) Eliminar un usuario.");
            System.out.println("3) Ver usuarios.");
            System.out.println("4) Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt();

            if (opc == 1) {
                agregarUsuario();
            } else if (opc == 2) {
                eliminarUsuario();
            } else if (opc == 3) {
                mostrarArrayList();
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt();
                } while (opc != 1 && opc != 2 && opc != 3 && opc != 4);
            }
        } while (opc != 4);
    }

    // Método para agregar un usuario a la lista
    public void agregarUsuario() {
        System.out.print("Ingresa el nombre del usuario: ");
        nombre = s.next();
        usuario.add(nombre); // Agregar el nombre del usuario al ArrayList
    }

    // Método para eliminar un usuario de la lista
    public void eliminarUsuario() {
        System.out.print("Ingresa el nombre del usuario que deseas eliminar: ");
        nombre = s.next();
        if (usuario.remove(nombre)) { // Comprobar si se elimina correctamente
            System.out.println(nombre + " se ha eliminado de la lista.");
        } else {
            System.out.println("No se ha encontrado el nombre en la lista.");
        }
    }

    // Método para mostrar los usuarios almacenados en el ArrayList
    public void mostrarArrayList() {
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println((i + 1) + ") " + usuario.get(i)); // Mostrar los nombres de usuario con su respectivo
                                                                 // índice
        }
    }
}

// Clase ejecutable para probar el funcionamiento de la clase Ejercicio1
class Ejercicio1Ejecutable {
    public static void main(String[] args) {
        Ejercicio1 lista1 = new Ejercicio1();
        lista1.menu(); // Llamar al método menu para iniciar el programa
    }
}
