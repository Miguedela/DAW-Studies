import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    Scanner s = new Scanner(System.in);
    private ArrayList<String> palabras = new ArrayList<>(); // ArrayList para almacenar palabras
    private String nombre; // Variable para almacenar el nombre de la palabra
    private int opc; // Variable para almacenar la opción seleccionada por el usuario

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("-----------------------");
            System.out.println("1) Agregar una palabra.");
            System.out.println("2) Modificar una palabra.");
            System.out.println("3) Ver palabras.");
            System.out.println("4) Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt();

            if (opc == 1) {
                agregarPalabra();
            } else if (opc == 2) {
                modificarPalabra();
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

    // Método para agregar una palabra al ArrayList
    public void agregarPalabra() {
        System.out.print("Ingresa la palabra: ");
        nombre = s.next();
        palabras.add(nombre); // Agregar la palabra al ArrayList
    }

    // Método para modificar una palabra en el ArrayList
    public void modificarPalabra() {
        System.out.print("Ingresa la palabra que deseas buscar: ");
        nombre = s.next();
        int indice = palabras.indexOf(nombre);
        if (indice >= 0) {
            System.out.print("Ingresa la nueva palabra: ");
            String nuevaPalabra = s.next();
            palabras.set(indice, nuevaPalabra); // Reemplazar la palabra en el índice dado
        } else {
            System.out.println("Palabra no encontrada");
        }
    }

    // Método para mostrar las palabras almacenadas en el ArrayList
    public void mostrarArrayList() {
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println((i + 1) + ") " + palabras.get(i)); // Mostrar las palabras con su respectivo índice
        }
    }
}

// Clase ejecutable para probar el funcionamiento de la clase Ejercicio2
class Ejercicio2Ejecutable {
    public static void main(String[] args) {
        Ejercicio2 palabras1 = new Ejercicio2();
        palabras1.menu(); // Llamar al método menu para iniciar el programa
    }
}
