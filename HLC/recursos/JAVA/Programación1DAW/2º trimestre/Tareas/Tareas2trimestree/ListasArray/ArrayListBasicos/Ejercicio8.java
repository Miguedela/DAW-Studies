import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio8 {
    Scanner s = new Scanner(System.in);
    private ArrayList<String> lista1 = new ArrayList<>(); // Lista 1
    private ArrayList<String> lista2 = new ArrayList<>(); // Lista 2
    private int opc;
    private String palabra;

    // Método para mostrar el menú y realizar operaciones según la opción
    // seleccionada
    public void menu() {
        do {
            System.out.println("----------------------");
            System.out.println("1) Agregar palabra a lista1.");
            System.out.println("2) Agregar palabra a lista2.");
            System.out.println("3) Reemplazar lista1.");
            System.out.println("4) Salir.");
            System.out.print("Ingrese la opción deseada: ");
            opc = s.nextInt();

            if (opc == 1) {
                agregarPalabralista1(); // Llamar al método para agregar palabra a lista1
            } else if (opc == 2) {
                agregarPalabralista2(); // Llamar al método para agregar palabra a lista2
            } else if (opc == 3) {
                reemplazarLista1(); // Llamar al método para reemplazar lista1
            } else {
                do {
                    System.out.print("Elección no válida, inténtelo nuevamente: ");
                    opc = s.nextInt(); // Solicitar una opción válida al usuario
                } while (opc != 1 && opc != 2 && opc != 3 && opc != 4); // Repetir hasta que se ingrese una opción
                                                                        // válida
            }
        } while (opc != 4); // Salir del bucle cuando se seleccione la opción 4 (Salir)
    }

    // Método para agregar una palabra a lista1
    public void agregarPalabralista1() {
        System.out.print("Ingresa una palabra: ");
        palabra = s.next(); // Leer la palabra ingresada por el usuario
        lista1.add(palabra); // Agregar la palabra a lista1
    }

    // Método para agregar una palabra a lista2
    public void agregarPalabralista2() {
        System.out.print("Ingresa una palabra: ");
        palabra = s.next(); // Leer la palabra ingresada por el usuario
        lista2.add(palabra); // Agregar la palabra a lista2
    }

    // Método para reemplazar lista1 con los elementos de lista2
    public void reemplazarLista1() {
        lista1.removeAll(lista1); // Eliminar todos los elementos de lista1
        lista1.addAll(lista2); // Agregar todos los elementos de lista2 a lista1
        System.out.println("Ahora la lista1 contiene: ");
        System.out.println(lista1); // Mostrar la lista1 actualizada
    }
}

class Ejercicio8Ejecutable {
    public static void main(String[] args) {
        Ejercicio8 lista1 = new Ejercicio8(); // Crear una instancia de Ejercicio8
        lista1.menu(); // Llamar al método menu para iniciar el programa
    }
}
